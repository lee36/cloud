package com.example.orderservice.service;

import com.example.orderservice.mode.Order;

public interface OrderService {
    public Order save(int userId, int productId);
}
