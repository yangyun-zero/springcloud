package com.yangyun.springcloud.controller;

import com.yangyun.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName DeptConsumerController
 * @Description:
 * @Author yangyun
 * @Date 2019/9/3 0003 10:25
 * @Version 1.0
 **/
@RestController
public class DeptConsumerController {

//    private static final String REST_URL_PREFIX = "http://192.168.5.86:8001/";
    private static final String REST_URL_PREFIX = "http://microservicecloud-dept";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value="/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @GetMapping(value="/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    @GetMapping(value="/consumer/dept/list")
    public List<Dept> list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
}
