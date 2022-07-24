package com.nowcoder.community.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")  // Spring管理的Bean，默认是单例的（singleton），如果需要多例，则填写prototype
public class AlphaService {

    public AlphaService() {  // 构造方法
        System.out.println("实例化AlphaService");
    }

    @PostConstruct  // 在构造之后执行
    public void init() {
        System.out.println("初始化AlphaService");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁AlphaService");
    }
}
