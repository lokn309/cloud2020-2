package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.oracle.tools.packager.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: lokn
 * @date: 2020/11/14 21:08
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult insertPayment(@RequestBody Payment payment) {
       int result = paymentService.insertPayment(payment);
       if (result > 0) {
           return new CommonResult(200, "数据插入成功，serverPort=" + servicePort);
       }
       return new CommonResult(444, "数据插入失败，serverPort=" + servicePort);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询数据成功，serverPort=" + servicePort, payment);
        }
        return new CommonResult(444, "未查询到数据，serverPort=" + servicePort);
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String ele : services) {
            System.out.println("service = " + ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance ele : instances) {
            System.out.println(ele.getHost() + " " + ele.getInstanceId() + ele.getHost());
        }
        return discoveryClient;
    }

    @GetMapping("payment/lb")
    public String getPaymentLB() {
        return servicePort;
    }

    @GetMapping("payment/lb/timeout")
    public String getPaymentTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return servicePort;
    }

}
