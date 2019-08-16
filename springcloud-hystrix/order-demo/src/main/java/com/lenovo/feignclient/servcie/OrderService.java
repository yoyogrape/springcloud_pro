package com.lenovo.feignclient.servcie;

import com.lenovo.feignclient.servcie.hystrix.OrderCommand;
import com.lenovo.feignclient.servcie.hystrix.UserCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: songjn1
 * @create: 2019-08-16
 * @desc: 降级处理方法2
 **/
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

    // 测试依赖隔离
    public String testPool() throws ExecutionException, InterruptedException {
        UserCommand userCommand = new UserCommand("库里");
        OrderCommand orderCommand1 = new OrderCommand("篮球");
        OrderCommand orderCommand2 = new OrderCommand("足球");
        // 同步调用
//        String val1 = userCommand.execute();
//        String val2 = orderCommand1.execute();
//        String val3 = orderCommand2.execute();
        // 异步调用
        Future<String> f1 = userCommand.queue();
        Future<String> f2 = orderCommand1.queue();
        Future<String> f3 = orderCommand2.queue();
//        return "val1=" + val1 + "val2=" + val2 + "val3=" + val3;
        return "f1=" + f1.get() + "f2=" + f2.get() + "f3=" + f3.get();
    }


}