package com.example.orderservice.service.impl;

import com.example.orderservice.mode.Order;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
@Service
public class OrderServiceImpl implements OrderService {
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private ProductClient productClient;

    @Override
    public Order save(int userId, int productId) {
       // Map map = restTemplate.getForObject("http://PRODUCT-SERVER/product/get/" + productId, Map.class);
        Object o = productClient.get(productId);
        System.out.println(o+"========");
        Order order = new Order();
//        order.setPrice((Integer) map.get("price"));
//        order.setCreateTime(new Date());
//        order.setTraNo(UUID.randomUUID().toString());
//        order.setProductName((String)map.get("name"));
//        order.setUserId(userId);
        return order;
    }
}
