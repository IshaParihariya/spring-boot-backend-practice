package com.isha.spring_boot_learning.basics1.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Alien
{
    // static block
    static {
        System.out.println("Static block of Alien!");

    }

    // instance block
    {
        System.out.println("Instance block of Alien!");
    }

    // constructor
    public Alien()
    {
        System.out.println("Constructor of Alien");
    }

    //Runs AFTER bean is created and dependencies are injected
    @PostConstruct
    public void init()
    {
        System.out.println("PostConstruct call");
    }

    //Runs BEFORE bean is destroyed (application shutdown)
    @PreDestroy
    public void destroy()
    {
        System.out.println("PreDestroy call");
    }

}
