package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lokn
 * @date: 2020/12/27 20:50
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level getFeignLogger() {
        return Logger.Level.FULL;
    }

}
