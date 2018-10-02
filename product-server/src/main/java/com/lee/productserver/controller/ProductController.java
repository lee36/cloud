package com.lee.productserver.controller;

import com.lee.productserver.service.ProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/list")
    public Object list(){
        return productService.findAllProduct();
    }
    @RequestMapping("/get/{id}")
    public Object get(@PathVariable Integer id){
        return productService.findById(id);
    }
}
