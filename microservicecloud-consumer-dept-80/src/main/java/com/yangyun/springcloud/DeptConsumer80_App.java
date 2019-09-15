package com.yangyun.springcloud;

import com.yangyun.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName DeptConsumer80_App
 * @Description:
 * @Author yangyun
 * @Date 2019/9/3 0003 10:27
 * @Version 1.0
 **/
@SpringBootApplication
// 使用 Ribbon 需要, Ribbon 客户端负载均衡
@EnableEurekaClient
// 使用自定义负载均衡算法 name:表示针对哪个微服务组 configuration: 自定义的算法
// 自定义算法类不能在 @ComponentScan 所扫描的包及其子包下面, 否则会对所有 ribbon 客户端共享
@RibbonClient(name = "microservicecloud-dept", configuration = MySelfRule.class)
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
