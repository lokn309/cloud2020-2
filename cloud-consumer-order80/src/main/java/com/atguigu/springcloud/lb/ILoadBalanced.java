package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoadBalanced {

    /**
     *
     * @param instances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> instances);

}
