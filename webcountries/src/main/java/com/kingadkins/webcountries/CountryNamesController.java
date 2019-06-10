package com.kingadkins.webcountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNamesController
{
    // names/all localhost:2019/names/all
    @RequestMapping(value = "/all",
                    produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        WebcountriesApplication.list.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(WebcountriesApplication.list.countryList, HttpStatus.OK);
    }

    // names/start/{letter} localhost:2019/names/start/{letter}
    @GetMapping(value = "/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter) {
        ArrayList<Country> rtnCountries = WebcountriesApplication.list.findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);

    }

    // names/size/{number}
    @RequestMapping(value = "/size/{length}",
                    produces = {"application/json"})
    public ResponseEntity<?> getCountriesNameWithEqualOrLonger(@PathVariable int length) {
        ArrayList<Country> countries = WebcountriesApplication.list.findCountries(c -> (c.getName().length() > length));
        countries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(countries, HttpStatus.OK);

    }
}
