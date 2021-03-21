package com.jm.udemy.dao.repository;


import com.jm.udemy.commons.service.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends CrudRepository<Product, Long>
{
}
