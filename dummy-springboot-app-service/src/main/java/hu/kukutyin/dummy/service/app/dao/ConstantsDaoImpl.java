package hu.kukutyin.dummy.service.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.kukutyin.dummy.service.app.dao.dto.ConstantsDto;
import hu.kukutyin.dummy.service.app.dao.exception.ConstantsDaoException;
import hu.kukutyin.dummy.service.app.dao.mapper.ConstantsMapper;

import static hu.kukutyin.dummy.service.app.valueset.Constants.CALLBACK_VERIFY_TOKEN;
import static hu.kukutyin.dummy.service.app.valueset.Constants.GROUP_ID_CALLBACK;
import static hu.kukutyin.dummy.service.app.valueset.Constants.GROUP_ID_SEND;
import static hu.kukutyin.dummy.service.app.valueset.Constants.SEND_FB_URL;
import static hu.kukutyin.dummy.service.app.valueset.Constants.SEND_PATH_MESSAGE_ME;
import static hu.kukutyin.dummy.service.app.valueset.Constants.SEND_QUERY_KEY_ACCESS_TOKEN;
import static hu.kukutyin.dummy.service.app.valueset.Constants.SEND_QUERY_VALUE_ACCESS_TOKEN;

@Service
public class ConstantsDaoImpl implements ConstantsDao {
    private final ConstantsMapper constantsMapper;

    @Autowired
    public ConstantsDaoImpl(ConstantsMapper constantsMapper) {
        this.constantsMapper = constantsMapper;
    }

    @Override
    public String completeFbUrl() throws ConstantsDaoException {
        return this.getRow(GROUP_ID_SEND, SEND_FB_URL).getGroupIdValue() +
                this.getRow(GROUP_ID_SEND, SEND_PATH_MESSAGE_ME).getGroupIdValue() +
                this.getRow(GROUP_ID_SEND, SEND_QUERY_KEY_ACCESS_TOKEN).getGroupIdValue() +
                this.getRow(GROUP_ID_SEND, SEND_QUERY_VALUE_ACCESS_TOKEN).getGroupIdValue();
    }

    @Override
    public String getVerifyToken() throws ConstantsDaoException {
        return this.getRow(GROUP_ID_CALLBACK, CALLBACK_VERIFY_TOKEN).getGroupIdValue();
    }

    public ConstantsDto getRow(String groupId, String groupIdKey) throws ConstantsDaoException {
        ConstantsDto constantsDto = constantsMapper.getRow(groupId, groupIdKey);
        if (constantsDto == null) {
            throw new ConstantsDaoException("Check \'constants table\' values!!");
        }
        return constantsDto;
    }
}
