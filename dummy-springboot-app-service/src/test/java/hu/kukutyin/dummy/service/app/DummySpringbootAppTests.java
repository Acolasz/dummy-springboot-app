package hu.kukutyin.dummy.service.app;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import hu.kukutyin.dummy.service.app.api.GreetingService;
import hu.kukutyin.dummy.service.app.api.HealthCheckService;
import hu.kukutyin.dummy.service.app.dao.ConstantsDao;
import hu.kukutyin.dummy.service.app.dao.mapper.ConstantsMapper;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DummySpringbootAppTests {

    @Autowired
    private HealthCheckService healthCheckService;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private ConstantsDao constantsDao;

    @Autowired
    private ConstantsMapper constantsMapper;

    @Test
    void apiContextLoads() {
        assertThat(healthCheckService).isNotNull();
        assertThat(greetingService).isNotNull();
    }

    @Test
    void daoContextLoads() {
        assertThat(constantsDao).isNotNull();
        assertThat(constantsMapper).isNotNull();
    }
}
