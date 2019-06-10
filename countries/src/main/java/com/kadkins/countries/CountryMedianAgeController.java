package com.kadkins.countries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/age")
public class CountryMedianAgeController
{
    // age/age/{age}
    @RequestMapping(value = "/age/{age}",
                    produces = {"application/json"})
    public ResponseEntity<?> getCountriesWithMedianAgeEqualOrGreaterThanGiven(@PathVariable
                                                                                      int age)
    {
        ArrayList<Country> countries = CountriesApplication.list.findCountries(c -> (c.getMedianAge() >= age));
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    // age/min
    @RequestMapping(value = "/min",
                    produces = {"application/json"})
    public ResponseEntity<?> getCountryWithLowestMedianAge() {
        CountriesApplication.list.countryList.sort(Comparator.comparingInt(Country::getMedianAge));
        return new ResponseEntity<>(CountriesApplication.list.countryList.get(0), HttpStatus.OK);
    }


    // age/max
    @RequestMapping(value = "/max",
                    produces = {"application/json"})
    public ResponseEntity<?> getCountryWithHighestMedianAge() {
        CountriesApplication.list.countryList.sort(Comparator.comparingInt(Country::getMedianAge));
        return new ResponseEntity<>(CountriesApplication.list.countryList.get(CountriesApplication.list.countryList.size() - 1), HttpStatus.OK);
    }
}
