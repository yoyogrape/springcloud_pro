package com.lenovo.userclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${server.port}")
    int port;

    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id) {
        if (id == 1) {
            return "图灵...port:" + port;
        } else if (id == 2) {
            return "霍金...port:" + port;
        } else {
            return "songjn...port:" + port;
        }
    }
}