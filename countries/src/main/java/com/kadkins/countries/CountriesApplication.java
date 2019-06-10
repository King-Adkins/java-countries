package com.kadkins.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication
{
    static CountriesList list;
    public static void main(String[] args)
    {
        SpringApplication.run(CountriesApplication.class, args);
    }

}
