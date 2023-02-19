package hu.kukutyin.own.app;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hu.kukutyin.own.app.api.GreetingService;
import hu.kukutyin.own.app.api.HealthCheckService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OwnAppWithTestingApplicationTests {

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
