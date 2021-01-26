package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: lokn
 * @date: 2020/12/12 16:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8005 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8005.class, args);
    }

}
