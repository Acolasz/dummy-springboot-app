package hu.kukutyin.dummy.service.app.config;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ActiveProfiles;

import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.FB_URL;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.GET_ROW;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.VERIFY_TOKEN;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
@ActiveProfiles("cache-config")
public class CacheConfigTest {

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void givenCacheManager() {
        assertThat(cacheManager.getCacheNames())
                .containsOnly(VERIFY_TOKEN, FB_URL);
    }
}
