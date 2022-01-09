package com.item.common.threadpool.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-14
 */

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "thread.pool", ignoreInvalidFields = true)
public class ThreadPoolConfig {
    private static ThreadPoolConfig threadPoolConfig;

    @PostConstruct
    void init() {
        threadPoolConfig = this;
    }

    /**
     * 线程池配置 key：线程池名称 value：线程池参数配置
     */
    private Map<String, ThreadPoolProperties> configs;

    /**
     *
     * @return Map
     */
    public static Map<String, ThreadPoolProperties> getConfigs() {
        return threadPoolConfig.configs;
    }
}
