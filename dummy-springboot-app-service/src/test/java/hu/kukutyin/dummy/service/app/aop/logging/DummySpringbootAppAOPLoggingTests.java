package hu.kukutyin.dummy.service.app.aop.logging;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import hu.kukutyin.dummy.service.app.dao.ConstantsDao;
import hu.kukutyin.dummy.service.app.dao.ConstantsDaoImpl;
import hu.kukutyin.dummy.service.app.dao.dto.ConstantsDto;
import hu.kukutyin.dummy.service.app.dao.mapper.ConstantsMapper;
import hu.kukutyin.dummy.service.app.utils.ServiceProxyProvider;

import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_ENTITY_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_DESCRIPTION;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * Try coding this, but do not work:
 * <a>https://github.com/qos-ch/slf4j/blob/cff3312e43e7a9bd6ae664ad2f71c0457822f672/jul-to-slf4j/src/main/java/org/slf4j/bridge/SLF4JBridgeHandler.java#L304</a>
 * <a>https://github.com/eugenp/tutorials/blob/master/spring-aop/src/test/java/com/baeldung/joinpoint/JoinPointBeforeAspectIntegrationTest.java</a>
 * <a>https://github.com/eugenp/tutorials/blob/master/spring-aop/src/main/java/com/baeldung/joinpoint/JoinPointBeforeAspect.java</a>
 *
 * @see <a>https://stackoverflow.com/questions/16971819/aspectj-advice-not-being-executed-through-unit-test</a>
 */
@SpringBootTest
@ActiveProfiles("aop-logging")
public class DummySpringbootAppAOPLoggingTests {
    @MockBean
    private ConstantsMapper constantsMapper;

    @Autowired
    LoggingAspect loggingAspect;

    @Autowired
    private ConstantsDao constantsDaoProxy;
        @Autowired

    private ConstantsDao constantsDao;

    private ConstantsDto mockConstantsDtoVerifyToken;

    private final List<String> messages = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        mockConstantsDtoVerifyToken = new ConstantsDto();
        mockConstantsDtoVerifyToken.setId(ID_1_ENTITY_ID);
        mockConstantsDtoVerifyToken.setGroupId(ID_1_GROUP_ID);
        mockConstantsDtoVerifyToken.setGroupIdKey(ID_1_GROUP_ID_KEY);
        mockConstantsDtoVerifyToken.setGroupIdValue(ID_1_GROUP_ID_VALUE);
        mockConstantsDtoVerifyToken.setDescription(ID_1_GROUP_ID_DESCRIPTION);
        constantsDaoProxy = (ConstantsDao) ServiceProxyProvider.getServiceProxy(new ConstantsDaoImpl(constantsMapper));
    }

    @Test
    void proceedingJoinPoint() throws Exception {
        when(constantsMapper.getRow(ID_1_GROUP_ID, ID_1_GROUP_ID_KEY)).thenReturn(mockConstantsDtoVerifyToken);

        assertTrue("Expected a proxy", constantsDaoProxy instanceof Advised);
//        assertThat(constantsDao.greet(name)).isEqualTo(expectedGreeting);

    }

//    @Test
    void logging() throws Exception {
        when(constantsMapper.getRow(ID_1_GROUP_ID, ID_1_GROUP_ID_KEY)).thenReturn(mockConstantsDtoVerifyToken);
        constantsDao.getVerifyToken();
        assertThat(loggingAspect.getMessage()).contains("ConstantsDaoImpl.getVerifyToken()");
        constantsDao.completeFbUrl();
        assertThat(loggingAspect.getMessage()).contains("ConstantsDaoImpl.completeFbUrl()");
    }
}
