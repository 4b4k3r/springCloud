package com.jm.udemy.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//No requerida con eureka
//@RibbonClient(name = "products-service")
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.jm.udemy.item"})
@EnableEurekaClient
@EnableCircuitBreaker
@EntityScan({"com.jm.udemy.commons.service.model.entity"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class MicroserviceItemApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MicroserviceItemApplication.class, args);
    }

}
