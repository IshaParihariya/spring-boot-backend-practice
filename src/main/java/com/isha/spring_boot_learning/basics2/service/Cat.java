package com.isha.spring_boot_learning.basics2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("cat")
public class Cat extends Animal
{
    public Cat()
    {
        System.out.println("Cat bean created!");
    }
}

