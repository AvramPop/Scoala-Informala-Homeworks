package com.paperpigeon;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@EnableAutoConfiguration
public class Application {

    @RequestMapping("/myAge")
    String myage() {
        Calendar today = new GregorianCalendar();
        java.util.Date now = new java.util.Date();
        today.setTime(now);
        Calendar bday = new GregorianCalendar();
        bday.set(1999, 12, 22);
        long age = (today.getTimeInMillis() - bday.getTimeInMillis());
        System.out.println(age);
        age = age / (1000*60*60*24);
        String ageString = Long.toString(age);
        return "<h1>My age in days is " + ageString + "!</h1>";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}