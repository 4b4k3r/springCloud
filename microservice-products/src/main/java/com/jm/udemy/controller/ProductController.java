package com.jm.udemy.controller;

import com.jm.udemy.dao.entity.Product;
import com.jm.udemy.dao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping()
    public List<Product> productList()
    {
        return productService.findAll().stream().peek(product -> product.setPort(port)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id)
    {
        Product product = productService.findById(id);
        product.setPort(port);
        return product;
    }
}
