package com.jm.udemy.dao.repository;

import com.jm.udemy.dao.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>
{
}
