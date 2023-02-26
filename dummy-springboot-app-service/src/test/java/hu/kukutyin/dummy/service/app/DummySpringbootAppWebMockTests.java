package hu.kukutyin.dummy.service.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import hu.kukutyin.dummy.service.app.dao.ConstantsDao;

import static hu.kukutyin.dummy.service.app.valueset.ConstantsServiceTest.CONSTANTS_REQUEST_PARAM_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsServiceTest.CONSTANTS_REQUEST_PARAM_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsServiceTest.CONSTANTS_URI;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @see "https://www.baeldung.com/java-openapi-generator-server"
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@ActiveProfiles("web-mock")
class DummySpringbootAppWebMockTests {

    private static final String DUMMY_RESPONSE = "https://graph.facebook.com/v13.0/me/messages?access_token=EAAKyEpSTiY4wZDZD";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConstantsDao constantsDao;

    @BeforeEach
    public void setUp() {
    }

    @Test
//    @Disabled("not working!")
    void healthcheckShouldReturn200Status() throws Exception {
        this.mockMvc.perform(
                        get("/healthcheck"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
//    @Disabled("not working!")
    void dummyShouldReturn200StatusAndMessage() throws Exception {
        when(constantsDao.completeFbUrl()).thenReturn(DUMMY_RESPONSE);
        this.mockMvc
                .perform(get(CONSTANTS_URI)
                        .param(CONSTANTS_REQUEST_PARAM_GROUP_ID, "fakeGroupId")
                        .param(CONSTANTS_REQUEST_PARAM_GROUP_ID_KEY, "fakeGroupIdKey"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(DUMMY_RESPONSE)));
    }
}
