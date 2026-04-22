package com.isha.spring_boot_learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service ==> Spring cannot create a bean from an interface
public interface Greetings
{
     String message(String name);
}

