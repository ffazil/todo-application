package com.tracebucket.x.todo.config;

import com.gemstone.gemfire.cache.GemFireCache;
import com.tracebucket.x.todo.query.model.TaskEntry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

/**
 * @author ffazil
 * @since 26/07/15
 */
@Configuration
@EnableGemfireRepositories(basePackages = {"com.tracebucket.x.todo.query.repository"})
public class GemfireConfiguration {

    @Bean
    CacheFactoryBean cacheFactoryBean() {
        return new CacheFactoryBean();
    }

    @Bean
    LocalRegionFactoryBean<String, TaskEntry> localRegionFactory(final GemFireCache cache) {
        return new LocalRegionFactoryBean<String, TaskEntry>() {

            {
                setCache(cache);
                setName("hello");
                setClose(false);
            }
        };
    }

}
