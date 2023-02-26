package hu.kukutyin.dummy.service.app.api;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hu.kukutyin.dummy.service.api.HealthCheckServiceApi;
import hu.kukutyin.dummy.service.api.HealthCheckServiceApiDelegate;

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
    @Override
    public ResponseEntity<Void> healthCheck() {
        log.info("healthCheck: {}", this.getClass());
        return ResponseEntity.ok().build();
    }
}
