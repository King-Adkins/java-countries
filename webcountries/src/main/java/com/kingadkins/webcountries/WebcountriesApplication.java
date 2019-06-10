package com.kingadkins.webcountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebcountriesApplication
{
    static CountriesList list;
    public static void main(String[] args)
    {
        list = new CountriesList();
        SpringApplication.run(WebcountriesApplication.class, args);
    }

}
