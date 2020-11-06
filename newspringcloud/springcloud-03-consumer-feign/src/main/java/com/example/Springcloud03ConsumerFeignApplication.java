package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class Springcloud03ConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloud03ConsumerFeignApplication.class, args);
    }

}
