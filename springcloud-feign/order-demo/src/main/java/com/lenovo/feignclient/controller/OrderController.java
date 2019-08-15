package com.lenovo.feignclient.controller;

import com.lenovo.feignclient.servcie.FeignService;
import com.lenovo.feignclient.servcie.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/order/{id}")
    public String addOrder(@PathVariable int id) {
        String name = orderService.getUser(id);
        // 调用用户，查询用户信息，
        return "生成订单：" + name;
    }

    @Autowired
    FeignService feignService;

    @GetMapping("/order2/{id}")
    public String addOrder2(@PathVariable int id) {
        // 调用用户，查询用户信息，
        String result = feignService.getUser(id);
        return  "生成订单：" + result;
    }
}