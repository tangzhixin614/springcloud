package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("application-service")
public interface ClientService extends ServiceApi{
}
