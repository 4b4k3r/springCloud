package com.jm.udemy.controller;

import com.jm.udemy.commons.service.model.entity.Product;
import com.jm.udemy.dao.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
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
    public Product findProductById(@PathVariable Long id) throws Exception
    {
        Product product = productService.findById(id);
        product.setPort(port);
        //Para generar error de timeout
        //Thread.sleep(2000L);
        return product;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product)
    {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product edit(@RequestBody Product product, @PathVariable Long id)
    {
        Product productFound = productService.findById(id);
        productFound.setName(product.getName());
        productFound.setPrice(product.getPrice());
        return productService.save(productFound);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id)
    {
        productService.deleteById(id);
    }
}
