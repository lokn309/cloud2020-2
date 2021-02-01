package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvide;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: lokn
 * @date: 2021/01/26 23:24
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvide iMessageProvide;

    @GetMapping("sendMessage")
    public String sendMessage() {
        return iMessageProvide.send();
    }

}
