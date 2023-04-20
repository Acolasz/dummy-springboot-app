package hu.kukutyin.dummy.service.app.api;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hu.kukutyin.dummy.service.app.aop.annotation.Log;

@Slf4j
@Service
public class HealthCheckServiceApiDelegateImpl implements HealthCheckServiceApiDelegate {

    /**
     * GET /healthcheck
     * Health Check
     *
     * @return Success (status code 200)
     * @see HealthCheckServiceApi#healthCheck()
     */
    @Log
    @Override
    public ResponseEntity<Void> healthCheck() {
        return ResponseEntity.ok().build();
    }
}
