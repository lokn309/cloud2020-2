package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: lokn
 * @date: 2021/01/26 20:33
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqProviderMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProviderMain8801.class, args);
    }

}
