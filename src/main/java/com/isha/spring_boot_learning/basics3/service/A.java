package com.isha.spring_boot_learning.basics3.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
NOTE:

Spring supports circular dependency only for field and setter injection using early references,
but it does not support it for constructor injection because dependencies must be fully initialized
at creation time.
 */
@Component
public class A {
    public A()
    {
        System.out.println("A bean created");
    }

    // circular dependency
    @Autowired
    // @Lazy delays the creation of the dependency until it is actually used.
    @Lazy
    private B b;
}
