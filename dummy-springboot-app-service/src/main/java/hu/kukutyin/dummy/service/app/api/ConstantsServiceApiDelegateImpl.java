package hu.kukutyin.dummy.service.app.api;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hu.kukutyin.dummy.service.api.ConstantsServiceApi;
import hu.kukutyin.dummy.service.api.ConstantsServiceApiDelegate;
import hu.kukutyin.dummy.service.app.dao.ConstantsDao;
import hu.kukutyin.dummy.service.app.dao.exception.ConstantsDaoException;
import hu.kukutyin.dummy.service.domain.ConstantsRequest;
import hu.kukutyin.dummy.service.domain.ConstantsResponse;

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
     * @param constantsRequest (optional)
     * @return Success. (status code 200)
     * or Invalid (status code 403)
     * or Invalid (status code 404)
     * or Internal server error. (status code 500)
     * @see ConstantsServiceApi#constantsService
     */
    @Override
    public ResponseEntity<ConstantsResponse> constantsService(ConstantsRequest constantsRequest) {
        log.info("constantsService: {}", this.getClass());
        ConstantsResponse constantsResponse = new ConstantsResponse();
        try {
            constantsResponse.setGroupIdValue(constantsDao.completeFbUrl());
            return ResponseEntity.ok().body(constantsResponse);
        } catch (ConstantsDaoException e) {
            log.error(e.getMessage(), e);
        }
        return ResponseEntity.notFound().build();
    }
}
