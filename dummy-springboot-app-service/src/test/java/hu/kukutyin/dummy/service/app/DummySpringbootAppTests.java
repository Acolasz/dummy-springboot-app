package hu.kukutyin.dummy.service.app;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hu.kukutyin.dummy.service.app.api.ConstantsServiceApiDelegate;
import hu.kukutyin.dummy.service.app.api.HealthCheckServiceApiDelegate;
import hu.kukutyin.dummy.service.app.dao.ConstantsDao;
import hu.kukutyin.dummy.service.app.dao.mapper.ConstantsMapper;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DummySpringbootAppTests {

    @Autowired
    private HealthCheckServiceApiDelegate healthCheckServiceApiDelegate;

    @Autowired
    private ConstantsServiceApiDelegate constantsServiceApiDelegate;

    @Autowired
    private ConstantsDao constantsDao;

    @Autowired
    private ConstantsMapper constantsMapper;

    @Test
    void apiContextLoads() {
        assertThat(healthCheckServiceApiDelegate).isNotNull();
        assertThat(constantsServiceApiDelegate).isNotNull();
    }

    @Test
    void daoContextLoads() {
        assertThat(constantsDao).isNotNull();
        assertThat(constantsMapper).isNotNull();
    }
}
