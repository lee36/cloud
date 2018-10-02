package com.lee.productserver.service;

import com.lee.productserver.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProduct();
    public Product findById(Integer id);
}
