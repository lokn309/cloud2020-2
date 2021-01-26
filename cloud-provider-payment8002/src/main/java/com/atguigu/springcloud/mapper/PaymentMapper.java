package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entity.Payment;
import io.micrometer.core.instrument.Meter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: lokn
 * @date: 2020/11/22 13:57
 */
@Mapper
public interface PaymentMapper {

    /**
     * 根据id查询payment信息
     * @param id
     * @return
     */
    Payment getPaymentById(@PathVariable("id") Long id);

    /**
     * 插入payment信息
     * @param payment
     * @return
     */
    int insertPayment(Payment payment);

}
