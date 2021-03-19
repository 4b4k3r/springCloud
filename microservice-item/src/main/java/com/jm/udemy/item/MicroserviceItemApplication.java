package com.jm.udemy.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "products-service")
@EnableFeignClients
@SpringBootApplication
public class MicroserviceItemApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MicroserviceItemApplication.class, args);
    }

}
