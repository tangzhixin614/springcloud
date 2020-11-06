package com.example.service.impl;

import com.example.pojo.Student;
import com.example.service.ClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public List<String> testFeign() {
        return null;
    }

    @Override
    public Student getMultiParams(Integer age, String name) {
        return null;
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
        return null;
    }

    /*** @HystrixCommand - 开启 Hystrix 容错处理的注解。
     * 代表当前方法如果出现服务 调用问题，使用 Hystrix 容错处理逻辑来处理
     * 属性 fallbackMethod - 如果当前方法调用服务，远程服务出现问题的时候，
     * 调 用本地的哪个方法得到托底数据。
     * */
    @HystrixCommand(fallbackMethod = "downgradeFallback")
    @Override
    public String getInfo() {
        ServiceInstance si = loadBalancerClient.choose("application-service");
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(si.getHost()) .append(":").append(si.getPort()).append("/");
        System.out.println("本次访问的 service 是： " + sb.toString());
        RestTemplate rt = new RestTemplate();
        ParameterizedTypeReference<String> type = new ParameterizedTypeReference<String>() { };
        ResponseEntity<String> response = rt.exchange(sb.toString(), HttpMethod.GET, null, type);
        String result = response.getBody();
        return result;
    }

    private String downgradeFallback(){
        return "服务降级返回托底数据.................";
    }
}
