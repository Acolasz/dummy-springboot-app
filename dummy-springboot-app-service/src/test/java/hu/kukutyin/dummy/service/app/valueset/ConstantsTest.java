package hu.kukutyin.dummy.service.app.valueset;

public class ConstantsTest {
    private ConstantsTest() {
        // Helper
    }

    public static final Long ID_1_ENTITY_ID = 1L;
    public static final String ID_1_GROUP_ID = "callback";
    public static final String ID_1_GROUP_ID_KEY = "verify_token";
    public static final String ID_1_GROUP_ID_VALUE = "09f21538-cedf-4bde-aa72-effe3ea2e72c";
    public static final String ID_1_GROUP_ID_DESCRIPTION = "Ezzel azonositjuk a hozzánk érkező kéréseket.";
    public static final Long ID_2_ENTITY_ID = 2L;
    public static final String ID_2_GROUP_ID = "send";
    public static final String ID_2_GROUP_ID_KEY = "fb_url";
    public static final String ID_2_GROUP_ID_VALUE = "https://graph.facebook.com/v13.0";
    public static final String ID_2_GROUP_ID_DESCRIPTION = "Facebook v13 graph URL.";
    public static final Long ID_3_ENTITY_ID = 3L;
    public static final String ID_3_GROUP_ID = "send";
    public static final String ID_3_GROUP_ID_KEY = "path_messages_me";
    public static final String ID_3_GROUP_ID_VALUE = "/me/messages";
    public static final String ID_3_GROUP_ID_DESCRIPTION = "Facebook v13 graph URL path.";
    public static final Long ID_4_ENTITY_ID = 4L;
    public static final String ID_4_GROUP_ID = "send";
    public static final String ID_4_GROUP_ID_KEY = "query_key_access_token";
    public static final String ID_4_GROUP_ID_VALUE = "?access_token=";
    public static final String ID_4_GROUP_ID_DESCRIPTION = "Facebook v13 graph URL query key.";
    public static final Long ID_5_ENTITY_ID = 5L;
    public static final String ID_5_GROUP_ID = "send";
    public static final String ID_5_GROUP_ID_KEY = "query_value_access_token";
    public static final String ID_5_GROUP_ID_VALUE = "EAAKyEpSTiY4wZDZD";
    public static final String ID_5_GROUP_ID_DESCRIPTION = "Access to Facebook v13 graph URL.";
    public static final String CACHE_KEY_GET_ROW = "ConstantsDaoImpl_getVerifyToken_";
    public static final String CACHE_KEY_VERIFY_TOKEN = "ConstantsDaoImpl_getVerifyToken_";
    public static final String CACHE_KEY_FB_URL = "ConstantsDaoImpl_completeFbUrl_";
}
