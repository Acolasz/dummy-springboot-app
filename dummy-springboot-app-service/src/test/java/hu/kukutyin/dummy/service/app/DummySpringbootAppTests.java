package hu.kukutyin.dummy.service.app;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import hu.kukutyin.dummy.service.app.api.GreetingService;
import hu.kukutyin.dummy.service.app.api.HealthCheckService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "/application/default/application-default.yaml")
class DummySpringbootAppTests {

    @Autowired
    private HealthCheckService healthCheckService;

    @Autowired
    private GreetingService greetingService;

    @Test
    void contextLoads() {
        assertThat(healthCheckService).isNotNull();
        assertThat(greetingService).isNotNull();
    }
}
