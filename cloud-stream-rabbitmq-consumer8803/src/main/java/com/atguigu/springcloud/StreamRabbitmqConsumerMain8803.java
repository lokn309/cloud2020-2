package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description:
 * @author: lokn
 * @date: 2021/01/30 16:42
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitmqConsumerMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqConsumerMain8803.class, args);
    }

}
