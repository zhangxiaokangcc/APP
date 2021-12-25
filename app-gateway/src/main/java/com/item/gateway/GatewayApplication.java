package com.item.gateway;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-07
 */

@Slf4j
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        log.info("gateway application is start run...,params:[{}]", ArrayUtils.toString(args));
        SpringApplication app = new SpringApplication(GatewayApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        long endMillis = System.currentTimeMillis();
        log.info("gateway application start complete. use {} ms.", endMillis - startMillis);
    }
}
