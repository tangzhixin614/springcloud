package com.example.controller;

import com.example.pojo.Student;
import com.example.service.ServiceApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceController implements ServiceApi {

    @Override
    public List<String> testFeign() {
        return null;
    }

    @Override
    public Student getMultiParams(Integer age, String name) {
        System.out.println("执行了getMultiParams........."+age+"...."+name);
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }

    @Override
    public Student postMultiParams(Integer age, String name) {
        return null;
    }

    @Override
    public Student postObjectParam(Student pojo) {
        return null;
    }

    @Override
    public String getString() {
        String str = "来自java高级开发工程师汤星星的问候！！！！！";
        return str;
    }

    /**
     * 测试Fallback
     * @return
     */
    @Override
    public String getInfo() {
        System.out.println("进入getInfo的方法");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "测试Fallback。。。。。。服务提供者";
    }

//    @Override
//    public Student getStudent(int age,String name) {
//        System.out.println("执行此方法，参数为："+age+"岁，"+name);
//        Student student = new Student();
//        student.setAge(age);
//        student.setName(name);
//        return student;
//    }
}
