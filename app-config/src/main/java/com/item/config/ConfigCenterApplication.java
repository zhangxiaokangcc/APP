package com.item.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-04
 */

@Slf4j
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigCenterApplication {
    public static void main(String[] args) {
        log.info("config center application is start run...,params:[{}]", ArrayUtils.toString(args));
        SpringApplication app = new SpringApplication(ConfigCenterApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        log.info("config center application start complete.");
    }
}
