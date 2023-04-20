package hu.kukutyin.dummy.service.app.api;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hu.kukutyin.dummy.service.app.aop.logging.Log;
import hu.kukutyin.dummy.service.app.dao.ConstantsDao;
import hu.kukutyin.dummy.service.app.dao.exception.ConstantsDaoException;
import hu.kukutyin.dummy.service.app.domain.ConstantsResponse;

@Slf4j
@Service
public class ConstantsServiceApiDelegateImpl implements ConstantsServiceApiDelegate {

    private final ConstantsDao constantsDao;

    @Autowired
    public ConstantsServiceApiDelegateImpl(
            ConstantsDao constantsDao
    ) {
        this.constantsDao = constantsDao;
    }

    /**
     * GET /dummy
     *
     * @param groupId    Constants: groupId (required)
     * @param groupIdKey Constants: groupIdKey (required)
     * @return Success. (status code 200)
     * or Invalid (status code 403)
     * or Invalid (status code 404)
     * or Internal server error. (status code 500)
     * @see ConstantsServiceApi#constantsService
     */
    @Log
    @Override
    public ResponseEntity<ConstantsResponse> constantsService(
            String groupId,
            String groupIdKey
    ) {
        try {
            return ResponseEntity.ok(new ConstantsResponse().groupIdValue(constantsDao.completeFbUrl()));
        } catch (ConstantsDaoException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
