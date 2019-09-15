package com.yangyun.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientRest
 * @Description:
 * @Author yangyun
 * @Date 2019/9/12 0012 15:36
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api")
public class ConfigClientRest {


    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String getConfig (){
        String str = "applicationName: " + applicationName + "\teurekaServers: " + eurekaServers + "\tport: " + port;
        System.out.println(str);
        return str;
    }
}
