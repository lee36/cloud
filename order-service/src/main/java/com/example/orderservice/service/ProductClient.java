package com.example.orderservice.service;

import com.example.orderservice.fallback.ProductClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-server", fallback = ProductClientFallBack.class)
public interface ProductClient {
    @RequestMapping("/product/get/{id}")
    public Object get(@PathVariable("id") Integer id);
}
