package com.item.common.threadpool.config;

import lombok.Getter;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-14
 */

@Getter
public class ThreadPoolProperties {
    /**
     * 核心池的大小（即线程池中的线程数目大于这个参数时，提交的任务会被放进任务缓存队列）
     * 默认10
     */
    private int corePoolSize;

    /**
     * 线程池最大能容忍的线程数
     */
    private int maximumPoolSize;

    /**
     * 线程存活时间
     */
    private long keepAliveTime;

    /**
     * 任务缓存队列的类型，用来存放等待执行的任务
     */
    private String queueType = "LinkedBlockingQueue";

    /**
     * 任务缓存队列的大小，用来存放等待执行的任务
     */
    private int queueSize;
}
