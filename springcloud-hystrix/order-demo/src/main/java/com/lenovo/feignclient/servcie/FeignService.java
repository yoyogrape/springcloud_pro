package com.lenovo.feignclient.servcie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: songjn1
 * @create: 2019-08-16
 * @desc: feign调用user-demo模块服务
 **/
@FeignClient(value = "yidiankt-user", fallback = MyFallback.class)
public interface FeignService {
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    String getUser(@PathVariable("id") int id);
}