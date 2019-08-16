package com.lenovo.feignclient.servcie.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author: songjn1
 * @create: 2019-08-16
 * @desc: 测试Hystrix缓存
 **/
//public class CacheCommand extends HystrixCommand<String> {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    private int uid;
//
//
//    @Override
//    protected String run() throws Exception {
//        return null;
//    }
//}
