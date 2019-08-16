package com.lenovo.feignclient.servcie;

import org.springframework.stereotype.Component;

//降级处理方法1
@Component
public class MyFallback implements FeignService {
    @Override
    public String getUser(int id) {
        return "error getUser";
    }
}