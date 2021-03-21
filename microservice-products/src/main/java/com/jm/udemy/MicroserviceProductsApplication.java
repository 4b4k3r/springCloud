package com.jm.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({"com.jm.udemy.commons.service.model.entity"})
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.jm.udemy.controller", "com.jm.udemy.dao"})
public class MicroserviceProductsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MicroserviceProductsApplication.class, args);
    }
}
