package com.example.sqlreports.countryReport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CountryController {

    @GetMapping
    public List<CountryEntity> getCountries() {
        return CountryRepository.findALlCountriesLargestToSmallest();
    }
}
