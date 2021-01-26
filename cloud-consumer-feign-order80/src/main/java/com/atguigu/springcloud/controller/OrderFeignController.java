package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lokn
 * @date: 2020/12/21 23:21
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @RequestMapping("/consumer/payment/lb/timeout")
    public String getPaymentTimeout() {
        return paymentFeignService.getPaymentTimeout();
    }

}
