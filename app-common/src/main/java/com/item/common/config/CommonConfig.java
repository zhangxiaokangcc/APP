package com.item.common.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-12
 */

@Configurable
public class CommonConfig {
    @Value("dbcenter.basic.name:DBCENTER-BASIC")
    private String dbcenterBasic;

    @Value("user.basic.name:USER-BASIC")
    private String userBasic;

    private static CommonConfig instance;

    @PostConstruct
    void init() {
        instance = this;
    }

    /**
     * 对外提供的获取实例的方法
     *
     * @return CommonConfig
     */
    public static CommonConfig getInstance() {
        return instance;
    }
}
