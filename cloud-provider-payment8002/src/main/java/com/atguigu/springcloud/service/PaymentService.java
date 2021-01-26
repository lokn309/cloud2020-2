package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;

/**
 * @description:
 * @author: lokn
 * @date: 2020/11/22 13:57
 */
public interface PaymentService {

    Payment getPaymentById(Long id);

    int insertPayment(Payment payment);

}
