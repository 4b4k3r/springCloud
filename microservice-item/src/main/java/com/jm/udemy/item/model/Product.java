package com.jm.udemy.item.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable
{
    private static final long serialVersionUID = -7898502103257184491L;

    private Long id;
    private String name;
    private Double price;
    private Integer port;
    private Date createdAt;
}
