package com.item.eureka;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 功能描述：
 *
 * @auth：zhangxiaokang
 * @Date：2021-09-04
 */

@Slf4j
@EnableEurekaServer
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServiceApplication {
    /**
     * main
     *
     * @param args args
     */
    public static void main(String[] args) {
        log.info("eureka application is start run...,params:[{}]", ArrayUtils.toString(args));
        SpringApplication app = new SpringApplication(EurekaServiceApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        log.info("eureka application start complete.");
    }
}
