package hu.kukutyin.dummy.service.app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ActiveProfiles("web-mock")
class DummySpringbootAppWebMockTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(
                        get("/greeting"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World!")));
    }

    @Test
    @Disabled("Sample disable unit test.")
    public void disableTest() throws Exception {
        this.mockMvc.perform(
                        get("/greeting"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World!")));
    }
}
