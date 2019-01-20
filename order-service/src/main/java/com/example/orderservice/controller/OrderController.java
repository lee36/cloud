package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @RequestMapping("/save")
    @HystrixCommand(fallbackMethod = "saveFail")
    public Object save(int userId, int productId) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", orderService.save(userId, productId));
        return map;
    }

    public Object saveFail(int userId, int productId) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("msg", "凉了");
        return map;
    }
}
