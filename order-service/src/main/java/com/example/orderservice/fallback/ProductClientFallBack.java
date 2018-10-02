package com.example.orderservice.fallback;

import com.example.orderservice.service.ProductClient;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFallBack implements ProductClient {
    @Override
    public Object get(Integer id) {
        System.out.println("feign 调用 异常");
        return null;
    }
}
