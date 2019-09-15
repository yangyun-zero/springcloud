package com.yangyun.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MySelfRule
 * @Description:
 * @Author yangyun
 * @Date 2019/9/7 0007 10:49
 * @Version 1.0
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule mySfRule (){

        return new RandomRule();
    }
}
