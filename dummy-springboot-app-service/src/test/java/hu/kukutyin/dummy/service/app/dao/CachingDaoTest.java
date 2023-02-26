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

import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_ENTITY_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_DESCRIPTION;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_KEY;
import static hu.kukutyin.dummy.service.app.valueset.ConstantsTest.ID_1_GROUP_ID_VALUE;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.GET_ROW;
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

    private ConstantsDto constantsDto;

    @BeforeEach
    void setUp() throws Exception {
        constantsDto = new ConstantsDto();
        constantsDto.setId(ID_1_ENTITY_ID);
        constantsDto.setGroupId(ID_1_GROUP_ID);
        constantsDto.setGroupIdKey(ID_1_GROUP_ID_KEY);
        constantsDto.setGroupIdValue(ID_1_GROUP_ID_VALUE);
        constantsDto.setDescription(ID_1_GROUP_ID_DESCRIPTION);
    }

    @Test
    void givenCacheManagerIsConfigured_whenGetRow() throws Exception {
        Cache beforeCache = cacheManager.getCache(GET_ROW);
        beforeCache.clear();
        isNull(beforeCache.get(GET_ROW), "Evicted cache");

        when(constantsMapper.getRow(ID_1_GROUP_ID, ID_1_GROUP_ID_KEY)).thenReturn(constantsDto);
        constantsDao.getRow(ID_1_GROUP_ID, ID_1_GROUP_ID_KEY);

        Cache afterCache = cacheManager.getCache(GET_ROW);
        notNull(afterCache.get(ID_1_GROUP_ID_KEY).get(), "Put cache");
    }
}
