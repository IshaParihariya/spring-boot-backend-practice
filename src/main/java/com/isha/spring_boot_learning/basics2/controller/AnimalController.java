package com.isha.spring_boot_learning.basics2.controller;

import com.isha.spring_boot_learning.basics2.service.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class AnimalController
{
    /*
    # for dependency injection :
   1. priority type match
    @Autowired
    private Animal animal; ==> INHERITANCE , POLYMORPHISM all valid
    i.e., if animal parent class then cat and dog will also be called if Animal type as both are child classes
     */

    // 2. Qualifier
    // 3. primary
    // 4. name match
    // 5. ERROR
    @Autowired
    @Qualifier("cat")
    private Animal animal;

}
