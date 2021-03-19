package com.jm.udemy.item.client;

import com.jm.udemy.item.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("products-service")
public interface ProductClientRest
{
    @GetMapping("/product")
    List<Product> findAll();

    @GetMapping("/product/{id}")
    Product findById(@PathVariable Long id);
}
