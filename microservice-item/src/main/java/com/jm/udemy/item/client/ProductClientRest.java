package com.jm.udemy.item.client;

import com.jm.udemy.commons.service.model.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("products-service")
public interface ProductClientRest
{
    @GetMapping
    List<Product> findAll();

    @GetMapping("/{id}")
    Product findById(@PathVariable Long id);

    @PutMapping("/{id}")
    Product update(@RequestBody Product product, @PathVariable Long id);

    @PostMapping
    Product save(@RequestBody Product product);

    @DeleteMapping("/{id}")
    Product deleteById(@PathVariable Long id);
}
