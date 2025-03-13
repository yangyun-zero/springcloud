package com.yangyun.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yangyun.springcloud.entities.Dept;
import com.yangyun.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName DeptController
 * @Description:
 * @Author yangyun
 * @Date 2019/9/3 0003 10:19
 * @Version 1.0
 **/
@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "aa")
    public Dept get(@PathVariable("id") Long id)
    {
        Dept dept = service.get(id);

        if (dept == null){
            throw new RuntimeException("查询" + id + ": 没有数据");
        } else {
            System.out.println(dept.toString());
        }

        return dept;
    }

    public Dept aa (@PathVariable("id") Long id){
        System.out.println("fallbackMethod...");
        return null;
    }

    @GetMapping("/dept/list")
    public List<Dept> list()
    {
        return service.list();
    }


    /*用于发现服务*/
    @Autowired
    private DiscoveryClient client;

    public DiscoveryClient getClient (){
        List<String> services = client.getServices();
        return client;
    }

}
