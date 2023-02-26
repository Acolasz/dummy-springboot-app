package hu.kukutyin.dummy.service.app.domain;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummySpringbootJsonTest {
    public static final String GROUP_ID_VALUE = "https://graph.facebook.com/v13.0/me/messages?access_token=EAAKyEpSTiY4wZDZD";

    private ConstantsResponse constantsResponse;

    @BeforeEach
    public void setUp() {
        constantsResponse = new ConstantsResponse().groupIdValue(GROUP_ID_VALUE);
    }

    @Test
    void constantsResponseTest() throws IOException {
        String constantsResponseStr = "{\"groupIdValue\": \"https://graph.facebook.com/v13.0/me/messages?access_token=EAAKyEpSTiY4wZDZD\"}";
        ConstantsResponse actual = new ObjectMapper().readValue(constantsResponseStr, ConstantsResponse.class);
        assertEquals(GROUP_ID_VALUE, constantsResponse.getGroupIdValue());
        assertEquals(GROUP_ID_VALUE, actual.getGroupIdValue());
    }
}
