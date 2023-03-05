package hu.kukutyin.dummy.service.app.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ActiveProfiles;

import hu.kukutyin.dummy.service.app.dao.dto.ConstantsDto;
import hu.kukutyin.dummy.service.app.dao.mapper.ConstantsMapper;

import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.CACHE_KEY_FB_URL;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.CACHE_KEY_VERIFY_TOKEN;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_ENTITY_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_DESCRIPTION;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_VALUE;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_2_ENTITY_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_2_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_2_GROUP_ID_DESCRIPTION;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_2_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_2_GROUP_ID_VALUE;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_3_ENTITY_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_3_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_3_GROUP_ID_DESCRIPTION;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_3_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_3_GROUP_ID_VALUE;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_4_ENTITY_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_4_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_4_GROUP_ID_DESCRIPTION;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_4_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_4_GROUP_ID_VALUE;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_5_ENTITY_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_5_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_5_GROUP_ID_DESCRIPTION;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_5_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_5_GROUP_ID_VALUE;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.FB_URL;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.GROUP_ID_SEND;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.SEND_PATH_MESSAGE_ME;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.SEND_QUERY_KEY_ACCESS_TOKEN;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.SEND_QUERY_VALUE_ACCESS_TOKEN;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.VERIFY_TOKEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.util.Assert.isNull;
import static org.springframework.util.Assert.notNull;

@SpringBootTest
@ActiveProfiles("caching-dao")
public class CachingDaoTest {

    @Autowired
    private CacheManager cacheManager;

    @MockBean
    private ConstantsMapper constantsMapper;

    @Autowired
    private ConstantsDao constantsDao;

    private ConstantsDto mockConstantsDtoGetRow;
    private ConstantsDto mockConstantsDtoVerifyToken;
    private ConstantsDto mockConstantsDtoFbUrl1;
    private ConstantsDto mockConstantsDtoFbUrl2;
    private ConstantsDto mockConstantsDtoFbUrl3;
    private ConstantsDto mockConstantsDtoFbUrl4;

    @BeforeEach
    void setUp() throws Exception {
        mockConstantsDtoGetRow = new ConstantsDto();
        mockConstantsDtoGetRow.setId(ID_1_ENTITY_ID);
        mockConstantsDtoGetRow.setGroupId(ID_1_GROUP_ID);
        mockConstantsDtoGetRow.setGroupIdKey(ID_1_GROUP_ID_KEY);
        mockConstantsDtoGetRow.setGroupIdValue(ID_1_GROUP_ID_VALUE);
        mockConstantsDtoGetRow.setDescription(ID_1_GROUP_ID_DESCRIPTION);
        mockConstantsDtoVerifyToken = new ConstantsDto();
        mockConstantsDtoVerifyToken.setId(ID_1_ENTITY_ID);
        mockConstantsDtoVerifyToken.setGroupId(ID_1_GROUP_ID);
        mockConstantsDtoVerifyToken.setGroupIdKey(ID_1_GROUP_ID_KEY);
        mockConstantsDtoVerifyToken.setGroupIdValue(ID_1_GROUP_ID_VALUE);
        mockConstantsDtoVerifyToken.setDescription(ID_1_GROUP_ID_DESCRIPTION);
        mockConstantsDtoFbUrl1 = new ConstantsDto();
        mockConstantsDtoFbUrl1.setId(ID_2_ENTITY_ID);
        mockConstantsDtoFbUrl1.setGroupId(ID_2_GROUP_ID);
        mockConstantsDtoFbUrl1.setGroupIdKey(ID_2_GROUP_ID_KEY);
        mockConstantsDtoFbUrl1.setGroupIdValue(ID_2_GROUP_ID_VALUE);
        mockConstantsDtoFbUrl1.setDescription(ID_2_GROUP_ID_DESCRIPTION);
        mockConstantsDtoFbUrl2 = new ConstantsDto();
        mockConstantsDtoFbUrl2.setId(ID_3_ENTITY_ID);
        mockConstantsDtoFbUrl2.setGroupId(ID_3_GROUP_ID);
        mockConstantsDtoFbUrl2.setGroupIdKey(ID_3_GROUP_ID_KEY);
        mockConstantsDtoFbUrl2.setGroupIdValue(ID_3_GROUP_ID_VALUE);
        mockConstantsDtoFbUrl2.setDescription(ID_3_GROUP_ID_DESCRIPTION);
        mockConstantsDtoFbUrl3 = new ConstantsDto();
        mockConstantsDtoFbUrl3.setId(ID_4_ENTITY_ID);
        mockConstantsDtoFbUrl3.setGroupId(ID_4_GROUP_ID);
        mockConstantsDtoFbUrl3.setGroupIdKey(ID_4_GROUP_ID_KEY);
        mockConstantsDtoFbUrl3.setGroupIdValue(ID_4_GROUP_ID_VALUE);
        mockConstantsDtoFbUrl3.setDescription(ID_4_GROUP_ID_DESCRIPTION);
        mockConstantsDtoFbUrl4 = new ConstantsDto();
        mockConstantsDtoFbUrl4.setId(ID_5_ENTITY_ID);
        mockConstantsDtoFbUrl4.setGroupId(ID_5_GROUP_ID);
        mockConstantsDtoFbUrl4.setGroupIdKey(ID_5_GROUP_ID_KEY);
        mockConstantsDtoFbUrl4.setGroupIdValue(ID_5_GROUP_ID_VALUE);
        mockConstantsDtoFbUrl4.setDescription(ID_5_GROUP_ID_DESCRIPTION);
    }

    @Test
    void givenCacheManagerIsConfigured_whenGetVerifyToken() throws Exception {
        Cache beforeCache = cacheManager.getCache(VERIFY_TOKEN);
        beforeCache.clear();
        isNull(beforeCache.get(VERIFY_TOKEN), "Evicted cache");

        when(constantsMapper.getRow(ID_1_GROUP_ID, ID_1_GROUP_ID_KEY)).thenReturn(mockConstantsDtoVerifyToken);
        constantsDao.getVerifyToken();

        Cache afterCache = cacheManager.getCache(VERIFY_TOKEN);
        notNull(afterCache.get(CACHE_KEY_VERIFY_TOKEN).get(), "Put cache");
        assertThat(afterCache.get(CACHE_KEY_VERIFY_TOKEN).get()).isEqualTo(ID_1_GROUP_ID_VALUE);
    }

    @Test
    void givenCacheManagerIsConfigured_whenCompleteFbUrl() throws Exception {
        Cache beforeCache = cacheManager.getCache(FB_URL);
        beforeCache.clear();
        isNull(beforeCache.get(FB_URL), "Evicted cache");

        when(constantsMapper.getRow(GROUP_ID_SEND, FB_URL)).thenReturn(mockConstantsDtoFbUrl1);
        when(constantsMapper.getRow(GROUP_ID_SEND, SEND_PATH_MESSAGE_ME)).thenReturn(mockConstantsDtoFbUrl2);
        when(constantsMapper.getRow(GROUP_ID_SEND, SEND_QUERY_KEY_ACCESS_TOKEN)).thenReturn(mockConstantsDtoFbUrl3);
        when(constantsMapper.getRow(GROUP_ID_SEND, SEND_QUERY_VALUE_ACCESS_TOKEN)).thenReturn(mockConstantsDtoFbUrl4);
        constantsDao.completeFbUrl();

        Cache afterCache = cacheManager.getCache(FB_URL);
        notNull(afterCache.get(CACHE_KEY_FB_URL).get(), "Put cache");
        assertThat(afterCache.get(CACHE_KEY_FB_URL).get())
                .isEqualTo(mockConstantsDtoFbUrl1.getGroupIdValue()
                        + mockConstantsDtoFbUrl2.getGroupIdValue()
                        + mockConstantsDtoFbUrl3.getGroupIdValue()
                        + mockConstantsDtoFbUrl4.getGroupIdValue()
                );
    }
}
