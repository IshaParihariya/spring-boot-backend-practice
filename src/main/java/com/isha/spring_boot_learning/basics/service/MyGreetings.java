package com.isha.spring_boot_learning.basics.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class MyGreetings implements Greetings
{
    MyGreetings()
    {
        System.out.println("bean of MyGreetings created!!!!!");
    }
    private int hour= LocalTime.now().getHour();

    @Override
    public String message(String name)
    {
         if(hour<12)
             return "Good Morning " +name;
         else if(hour<16)
             return "Good Afternoon " +name;
        else if(hour<20)
            return "Good Evening " +name;
       else if(hour<24)
            return "Good Night " +name;

       return "HAVE A NICE DAY!!";
    }
}
