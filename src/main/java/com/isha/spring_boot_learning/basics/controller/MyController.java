package com.isha.spring_boot_learning.basics.controller;
import com.isha.spring_boot_learning.basics.service.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//example of Greeting interface and its implementation MyGreetings
// @Controller → returns view (HTML)
//@RestController → returns data (String/JSON)
@RestController
public class MyController
{
    // object for this
    @Autowired
    private Greetings greeting;


    // mapping
    @GetMapping("greet")
    public String message() // note: @RequestParam ==> It takes input from URL
                            // http://localhost:8080/greet?name=Isha
    {
        return greeting.message("Isha");
    }
}
