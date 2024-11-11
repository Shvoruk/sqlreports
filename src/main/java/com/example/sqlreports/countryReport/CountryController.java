package com.example.sqlreports.countryReport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
         this.countryService = countryService;
    }

    @GetMapping("/world")
    public List<CountryEntity> getCountriesInTheWorld() {
        return countryService.getAllCountriesLargestToSmallest();
    }
}
