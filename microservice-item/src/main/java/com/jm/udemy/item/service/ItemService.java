package com.jm.udemy.item.service;

import com.jm.udemy.item.client.ProductClientRest;
import com.jm.udemy.item.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemService
{
    @Autowired
    private ProductClientRest productClientRest;

    public List<Item> findAll()
    {
        return productClientRest.findAll().stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
    }

    public Item findById(Long id, Integer quantity)
    {
        return new Item(productClientRest.findById(id), quantity);
    }
}
