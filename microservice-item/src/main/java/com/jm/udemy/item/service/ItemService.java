package com.jm.udemy.item.service;

import com.jm.udemy.commons.service.model.entity.Product;
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

    public Product save(Product product)
    {
        return productClientRest.save(product);
    }

    public Product update(Product product, Long id)
    {
        return productClientRest.update(product, id);
    }

    public void delete(Long id)
    {
        productClientRest.deleteById(id);
    }
}
