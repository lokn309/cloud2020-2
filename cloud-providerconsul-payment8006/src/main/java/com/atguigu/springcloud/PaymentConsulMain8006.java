package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: lokn
 * @date: 2020/12/13 16:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8006.class, args);
    }

}
