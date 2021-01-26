package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lokn
 * @date: 2020/11/22 13:56
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            return new CommonResult<>(444, "未获取到数据，serverPort=" + serverPort);
        }
        return new CommonResult(200, "查询数据成功，serverPort=" + serverPort, payment);
    }

    @PostMapping("payment/create")
    public  CommonResult insertPayment(@RequestBody Payment payment) {
        int result = paymentService.insertPayment(payment);
        if (result > 0) {
            return new CommonResult(200, "数据插入成功，serverPort=" + serverPort, result);
        }
        return new CommonResult(444, "数据插入失败，serverPort=" + serverPort);
    }

    @GetMapping("payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


}
