package com.jm.udemy.item.controller;

import com.jm.udemy.commons.service.model.entity.Product;
import com.jm.udemy.item.model.Item;
import com.jm.udemy.item.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
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

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product)
    {
        return itemService.save(product);
    }

    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product, @PathVariable Long id)
    {
        return itemService.update(product, id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteById(@PathVariable Long id)
    {
        itemService.delete(id);
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
