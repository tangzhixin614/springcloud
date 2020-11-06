package com.example.controller;

import com.example.pojo.Student;
import com.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;


    @GetMapping(value = "/getStudent")
    public Student getStudent(){
        Student student = new Student();
        student=clientService.getMultiParams(23,"汤星星");
        return student;
    }

    @GetMapping(value = "getString")
    public String getString(){
        return clientService.getString();
    }

    /**
     * 测试fallback
     * @return
     */
    @GetMapping(value = "/getInfo")
    public String getInfo(){
        return clientService.getInfo();
    }
}
