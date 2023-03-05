package hu.kukutyin.dummy.service.app.dao;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import hu.kukutyin.dummy.service.app.dao.dto.ConstantsDto;
import hu.kukutyin.dummy.service.app.dao.exception.ConstantsDaoException;
import hu.kukutyin.dummy.service.app.dao.mapper.ConstantsMapper;

import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.FB_URL;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.GET_ROW;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.GROUP_ID_CALLBACK;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.GROUP_ID_SEND;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.SEND_PATH_MESSAGE_ME;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.SEND_QUERY_KEY_ACCESS_TOKEN;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.SEND_QUERY_VALUE_ACCESS_TOKEN;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.VERIFY_TOKEN;

@Slf4j
@Service
public class ConstantsDaoImpl implements ConstantsDao {
    private final ConstantsMapper constantsMapper;

    @Autowired
    public ConstantsDaoImpl(ConstantsMapper constantsMapper) {
        this.constantsMapper = constantsMapper;
    }

    @Cacheable(
            value = FB_URL
            , keyGenerator="customKeyGenerator"
    )
    @Override
    public String completeFbUrl() throws ConstantsDaoException {
        return this.getRow(GROUP_ID_SEND, FB_URL).getGroupIdValue() +
                this.getRow(GROUP_ID_SEND, SEND_PATH_MESSAGE_ME).getGroupIdValue() +
                this.getRow(GROUP_ID_SEND, SEND_QUERY_KEY_ACCESS_TOKEN).getGroupIdValue() +
                this.getRow(GROUP_ID_SEND, SEND_QUERY_VALUE_ACCESS_TOKEN).getGroupIdValue();
    }

    @Cacheable(
            value = VERIFY_TOKEN
            , keyGenerator="customKeyGenerator"
    )
    @Override
    public String getVerifyToken() throws ConstantsDaoException {
        return this.getRow(GROUP_ID_CALLBACK, VERIFY_TOKEN).getGroupIdValue();
    }

    private ConstantsDto getRow(String groupId, String groupIdKey) throws ConstantsDaoException {
        log.info("Get row with \"{}\" and \"{}\" params.", groupId, groupIdKey);
        ConstantsDto constantsDto = constantsMapper.getRow(groupId, groupIdKey);
        if (constantsDto == null) {
            throw new ConstantsDaoException("Check \'constants table\' values!!");
        }
        return constantsDto;
    }
}
