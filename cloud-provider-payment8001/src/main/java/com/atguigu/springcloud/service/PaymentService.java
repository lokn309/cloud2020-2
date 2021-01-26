package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lokn
 * @date: 2020/11/14 21:06
 */
public interface PaymentService {

    Payment getPaymentById(Long id);

    int insertPayment(Payment payment);

}
