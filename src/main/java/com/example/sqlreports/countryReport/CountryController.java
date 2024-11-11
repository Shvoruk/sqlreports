package com.example.sqlreports.countryReport;

import org.springframework.web.bind.annotation.*;

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
        return countryService.getAllCountriesInWorld();
    }

    @GetMapping("/continent{continent}")
    public List<CountryEntity> getCountriesInTheContinent(@PathVariable String continent) {
        return countryService.getAllCountriesInContinent(continent);
    }

    @GetMapping("/region/{region}")
    public List<CountryEntity> getCountriesInTheRegion(@PathVariable String region) {
        return countryService.getAllCountriesInRegion(region);
    }
}
