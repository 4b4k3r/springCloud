package com.jm.udemy.dao.service;

import com.jm.udemy.dao.entity.Product;
import com.jm.udemy.dao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService
{
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> findAll()
    {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }
}
