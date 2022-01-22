package com.item.cache;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-12-2021/12/25
 */

@Slf4j
@EnableApolloConfig
@EnableDiscoveryClient
@SpringBootApplication
public class AppCacheApplication {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        log.info("cache application is start run...,params:[{}]", ArrayUtils.toString(args));
        SpringApplication app = new SpringApplication(AppCacheApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        long endMillis = System.currentTimeMillis();
        log.info("cache application start complete. use {} ms.", endMillis - startMillis);
    }
}
