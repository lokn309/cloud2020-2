package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @description: 服务降级公共处理方法
 * @author: lokn
 * @date: 2021/01/06 23:33
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "---服务降级处理方法，paymentInfoOk-----";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "---服务降级处理方法，paymentInfoTimeout----";
    }
}
