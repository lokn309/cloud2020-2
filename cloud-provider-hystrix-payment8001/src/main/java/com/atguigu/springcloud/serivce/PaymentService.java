package com.atguigu.springcloud.serivce;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.rmi.CORBA.Tie;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: lokn
 * @date: 2020/12/27 23:19
 */
@Service
public class PaymentService {

    public String paymentInfoOk(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentInfoOk, id: " + id;
    }

    // ------------服务降级

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeoutNum = 1;
//        try {
////            TimeUnit.SECONDS.sleep(timeoutNum);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfoTimeout, id: " + id
                + " 超时时间（秒）：" + timeoutNum;
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " 系统繁忙，请稍后再试, id: " + id
                + " 😭";
    }

    // -------------服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("不能为负数");
        }
        return "线程池： " + Thread.currentThread().getName() + " paymentInfoTimeout, id: " + id
                + " 超时时间（秒）：" + IdUtil.randomUUID();
    }

    public String paymentCircuitBreakerHandler(Integer id) {
        return Thread.currentThread().getName() + " 熔断啦:(";
    }

}
