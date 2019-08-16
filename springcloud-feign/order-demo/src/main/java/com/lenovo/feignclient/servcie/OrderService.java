package com.lenovo.feignclient.servcie;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    RestTemplate restTemplate;

    //降级处理方法2
    @HystrixCommand(fallbackMethod = "userFallback")
    public String getUser(int id) {
        // 获取用户信息？？？
        String url = "http://yidiankt-user/user/{id}";
        String info = restTemplate.getForObject(url, String.class, id);
        return info;
    }

    // 添加服务器降级处理方法
    public String userFallback(int id) {
        return "error user fallback";
    }
}