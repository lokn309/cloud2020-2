package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: lokn
 * @date: 2020/11/14 21:05
 */
@Mapper
public interface PaymentMapper {

    /**
     * 根据id查询payment信息
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);

    /**
     * 新增payment信息
     * @param payment
     * @return
     */
    int insertPayment(Payment payment);

}
