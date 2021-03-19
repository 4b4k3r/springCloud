package com.jm.udemy.item.controller;

import com.jm.udemy.item.model.Item;
import com.jm.udemy.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}/quantity/{quantity}")
    public Item findAll(@PathVariable Long id, @PathVariable Integer quantity)
    {
        return itemService.findById(id, quantity);
    }
}
