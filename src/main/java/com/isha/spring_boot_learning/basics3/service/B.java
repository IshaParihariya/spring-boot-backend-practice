package com.isha.spring_boot_learning.basics3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B
{
    public B()
    {
        System.out.println("B bean created");
    }

    // circular dependency
    @Autowired
    private A a;
}
