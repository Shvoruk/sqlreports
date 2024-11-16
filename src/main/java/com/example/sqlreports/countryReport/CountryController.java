package com.example.sqlreports.countryReport;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

        public CountryController(CountryService countryService) {
            this.countryService = countryService;
        }

        @GetMapping("/world")
        public List<CountryEntity> getCountriesInTheWorld(@RequestParam(required = false) Integer limit) {

            if (limit != null) {
                return countryService.getAllCountriesInWorldLimited(limit);
            }
            return countryService.getAllCountriesInWorld();
        }

        @GetMapping("/continent")
        public List<CountryEntity> getCountriesInTheContinent(@RequestParam String continent, @RequestParam(required = false) Integer limit) {

            if (limit != null) {
                return countryService.getAllCountriesInContinentLimited(continent, limit);
            }
            return countryService.getAllCountriesInContinent(continent);
        }

        @GetMapping("/region")
        public List<CountryEntity> getCountriesInTheRegion(@RequestParam String region, @RequestParam(required = false) Integer limit) {

            if (limit != null) {
                return countryService.getAllCountriesInRegionLimited(region, limit);
            }
            return countryService.getAllCountriesInRegion(region);
        }
    }
