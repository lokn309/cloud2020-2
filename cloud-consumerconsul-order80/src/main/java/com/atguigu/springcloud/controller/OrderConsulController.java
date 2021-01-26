package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lokn
 * @date: 2020/12/13 20:39
 */
@RestController
public class OrderConsulController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("payment/consul")
    public String orderConsul() {
        String forObject = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return forObject;
    }


}
