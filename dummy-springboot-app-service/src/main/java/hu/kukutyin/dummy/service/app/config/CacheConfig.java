package hu.kukutyin.dummy.service.app.config;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.FB_URL;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.GET_ROW;
import static hu.kukutyin.dummy.service.app.valueset.GeneralConstants.VERIFY_TOKEN;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(
                Arrays.asList(
                        new ConcurrentMapCache(FB_URL),
                        new ConcurrentMapCache(VERIFY_TOKEN),
                        new ConcurrentMapCache(GET_ROW)
                )
        );
        return cacheManager;
    }
}
