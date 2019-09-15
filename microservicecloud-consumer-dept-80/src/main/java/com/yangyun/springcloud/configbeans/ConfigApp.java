package com.yangyun.springcloud.configbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConfigApp
 * @Description:
 * @Author yangyun
 * @Date 2019/9/3 0003 10:24
 * @Version 1.0
 **/
@Configuration
public class ConfigApp {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate (){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

//    @Bean
//    public IRule myIRule (){
//        IRule iRule = new RandomRule();
////        iRule.
//
//        return iRule;
//
//    }
}
