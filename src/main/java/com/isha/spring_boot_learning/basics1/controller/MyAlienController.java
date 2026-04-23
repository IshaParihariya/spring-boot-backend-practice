package com.isha.spring_boot_learning.basics1.controller;

import com.isha.spring_boot_learning.basics1.service.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyAlienController
{
    @Autowired
    public Alien alien;
}
