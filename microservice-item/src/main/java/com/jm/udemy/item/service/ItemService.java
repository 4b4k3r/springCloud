package com.jm.udemy.item.service;

import com.jm.udemy.item.model.Item;
import com.jm.udemy.item.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemService
{
    @Autowired
    private RestTemplate restTemplate;

    public List<Item> findAll()
    {
        List<Product> productList = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject("http://localhost:8000/product", Product[].class)));
        return productList.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    public Item findById(Long id, Integer quantity)
    {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Product product = restTemplate.getForObject("http://localhost:8000/product/{id}", Product.class, pathVariables);
        return new Item(product, quantity);
    }
}
