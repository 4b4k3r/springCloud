package com.jm.udemy.item.controller;

import com.jm.udemy.item.model.Item;
import com.jm.udemy.item.model.Product;
import com.jm.udemy.item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController
{
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> findAll()
    {
        return itemService.findAll();
    }

    @HystrixCommand(fallbackMethod = "metodoAlternativo")
    @GetMapping("/{id}/quantity/{quantity}")
    public Item findAll(@PathVariable Long id, @PathVariable Integer quantity)
    {
        return itemService.findById(id, quantity);
    }

    private Item metodoAlternativo(Long id, Integer quantity)
    {
        Item item = new Item();
        Product product = Product.builder().id(id).name("noname").price(0d).createdAt(new Date()).port(0).build();
        item.setProduct(product);
        item.setQuantity(quantity);
        return item;
    }
}
