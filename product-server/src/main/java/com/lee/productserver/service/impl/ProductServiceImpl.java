package com.lee.productserver.service.impl;

import com.lee.productserver.model.Product;
import com.lee.productserver.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Value("${server.port}")
    private int port;
    private static Map<Integer,Product> products=new HashMap<>();

    static {
        products.put(1,new Product(1,"书包",20,10));
        products.put(2,new Product(2,"电视",2000,100));
        products.put(3,new Product(3,"冰箱",8000,100));
        products.put(4,new Product(4,"矿泉水",2,200));
        products.put(5,new Product(5,"空调",5000,600));
    }

    @Override
    public List<Product> findAllProduct() {
        Collection<Product> values = products.values();
        return new ArrayList<>(values);
    }

    @Override
    public Product findById(Integer id) {
        Product product = products.get(id);
        product.setName(product.getName()+port);
        return product;
    }
}
