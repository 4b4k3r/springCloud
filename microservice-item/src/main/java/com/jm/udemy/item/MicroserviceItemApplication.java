package com.jm.udemy.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//No requerida con eureka
//@RibbonClient(name = "products-service")
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MicroserviceItemApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MicroserviceItemApplication.class, args);
    }

}
