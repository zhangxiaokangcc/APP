package com.item.common.threadpool.executor;

import com.item.common.threadpool.config.ThreadPoolConfig;
import com.item.common.threadpool.config.ThreadPoolProperties;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @Auth: zhangXiaoKang
 * @Date: 2021-09-14
 */

public class PaymentExecutors {
    private static HashMap<String, ExecutorService> executorMaps = new HashMap<>();

    @Autowired
    private BeanFactory beanFactory;

    @PostConstruct
    public void init() {
        ExecutorService defaultExecutor = new ThreadPoolExecutor(10, 50, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        executorMaps.put("default", new TraceableExecutorService(beanFactory, defaultExecutor));

        Map<String, ThreadPoolProperties> configs = ThreadPoolConfig.getConfigs();
        configs.forEach((k, v) -> {
            int corePoolSize = v.getCorePoolSize();
            if (corePoolSize < 1) {
                corePoolSize = 10;
            }

            int maximumPoolSize = v.getMaximumPoolSize();
            if (maximumPoolSize < corePoolSize) {
                maximumPoolSize = corePoolSize;
            }
            long keepAliveTime = v.getKeepAliveTime();
            if (keepAliveTime < 1) {
                keepAliveTime = 60;
            }

            /**
             *
             * 队列类型，默认是LinkedBlockingQueue
             * LinkedBlockingQueue：基于链表的无界阻塞队列
             * ArrayBlockingQueue：基于数组的有界阻塞队列
             * SynchronousQueue：不存储元素的阻塞队列
             */
            BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
            String queueType = v.getQueueType();
            if ("ArrayBlockingQueue".equals(queueType)) {
                int queueSize = v.getQueueSize();
                if (queueSize < 1) {
                    queueSize = corePoolSize;
                }
                workQueue = new ArrayBlockingQueue<Runnable>(queueSize);
            }

            if ("SynchronousQueue".equals(queueType)) {
                workQueue = new SynchronousQueue<Runnable>();
            }

            ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue,
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            executorMaps.put(k, new TraceableExecutorService(beanFactory, executorService));
        });
    }

    /**
     * 通过线程池名字或许线程池
     *
     * @param threadPoolName threadPoolName
     * @return ExecutorService
     */
    public ExecutorService getExecutorService(String threadPoolName) {
        return Optional.ofNullable(executorMaps.get(threadPoolName)).orElse(executorMaps.get("default"));
    }

    /**
     * 或许默认线程池
     *
     * @return ExecutorService
     */
    public ExecutorService getExecutorService() {
        return executorMaps.get("default");
    }
}
