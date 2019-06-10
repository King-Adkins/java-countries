package com.kingadkins.webcountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/population")
public class CountryPopController
{
    // population/size/{people}
    @RequestMapping(value = "/size/{people}",
                    produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopGiven(@PathVariable int people) {
        ArrayList<Country> countries = WebcountriesApplication.list.findCountries(c -> (c.getPopulation() >= people));

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }


    // population/min
    @RequestMapping(value = "/min",
                    produces = {"application/json"})
    public ResponseEntity<?> getSmallestCountryByPop()
    {
        WebcountriesApplication.list.countryList.sort(Comparator.comparingInt(Country::getPopulation));
        return new ResponseEntity<>(WebcountriesApplication.list.countryList.get(0), HttpStatus.OK);

    }
    // population/max
    @RequestMapping(value = "/max",
                    produces = {"application/json"})
    public ResponseEntity<?> getMaxPopCountry()
        {
        WebcountriesApplication.list.countryList.sort(Comparator.comparingInt(Country::getPopulation));
        return new ResponseEntity<>(WebcountriesApplication.list.countryList.get(WebcountriesApplication.list.countryList.size() - 1), HttpStatus.OK);
    }
}
