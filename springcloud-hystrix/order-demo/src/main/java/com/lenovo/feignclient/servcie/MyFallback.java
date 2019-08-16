package com.lenovo.feignclient.servcie;

import org.springframework.stereotype.Component;
/**
 * @author: songjn1
 * @create: 2019-08-16
 * @desc: 降级处理方法1
 **/
@Component
public class MyFallback implements FeignService {
    @Override
    public String getUser(int id) {
        return "error getUser";
    }
}