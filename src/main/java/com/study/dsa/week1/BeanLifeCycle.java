package com.study.dsa.week1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanLifeCycle implements BeanNameAware {

    private String beanName = "fahhhh";


    BeanLifeCycle() {
        System.out.println("Constructor called. Bean name: " + beanName);
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean is being initialized. Bean name: " + beanName);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("Bean name set to: " + beanName);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean is being destroyed. Bean name: " + beanName);
    }

}
