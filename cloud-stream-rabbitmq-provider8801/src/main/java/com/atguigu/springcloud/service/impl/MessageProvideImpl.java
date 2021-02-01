package com.atguigu.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.atguigu.springcloud.service.IMessageProvide;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @description: 定义消息推送的管道
 * @author: lokn
 * @date: 2021/01/26 22:56
 */
@EnableBinding(Source.class)
public class MessageProvideImpl implements IMessageProvide {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.fastUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("======>>>>>>serial = " + serial);
        return serial;
    }

}
