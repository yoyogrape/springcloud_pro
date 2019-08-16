package com.lenovo.feignclient.servcie.hystrix;

import com.netflix.hystrix.*;

/**
 * @author: songjn1
 * @create: 2019-08-16
 * @desc: Hystrix 依赖隔离:每个服务启动一个线程池，当此线程池满了的时候，不影响其他服务的线程池，起到隔离作用
 **/
public class UserCommand extends  HystrixCommand<String>{
    private String value;

    public UserCommand(String value) {
        super(HystrixCommand.Setter.withGroupKey(
                //服务分组
                HystrixCommandGroupKey.Factory.asKey("UserGroup"))
                //线程分组
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("UserPool"))
                //线程池配置
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)
                        .withKeepAliveTimeMinutes(5)
                        .withMaxQueueSize(10)
                        .withQueueSizeRejectionThreshold(10000))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)));
        this.value = value;
    }
    /**
     * 实现调用业务逻辑的地方
     * @return
     * @throws Exception
     */
    @Override
    protected String run() throws Exception {
        String threadName = Thread.currentThread().getName();
        return threadName + " || " + value;
    }
}
