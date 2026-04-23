package com.isha.spring_boot_learning.basics2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("dog")
public class Dog extends Animal
{
    public Dog()
    {
        System.out.println("Dog bean created!");
    }
}
