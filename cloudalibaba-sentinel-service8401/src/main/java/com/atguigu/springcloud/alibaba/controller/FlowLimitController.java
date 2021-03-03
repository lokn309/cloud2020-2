package com.atguigu.springcloud.alibaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lokn
 * @date: 2021/03/03 23:27
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "----> testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "----> testB";
    }

}
