package com.example.sqlreports.populationReport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/population")
public class PopulationController {

    private final PopulationService populationService;

    public PopulationController(PopulationService populationService) {
        this.populationService = populationService;
    }

    @GetMapping("/continent/filtered")
    public List<Continent> getPopulationInContinentFiltered(){
        return populationService.getContinentsFiltered();
    }

    @GetMapping("/region/filtered")
    public List<Region> getPopulationInRegionFiltered(){
        return populationService.getRegionsFiltered();
    }

    @GetMapping("/country/filtered")
    public List<Country> getPopulationInCountryFiltered(){
        return populationService.getCountriesFiltered();
    }

    @GetMapping("/world")
    public List<PopulationEntity> getPopulationInWorld(){
        return populationService.getPopulationInWorld();
    }

    @GetMapping("/continent")
    public List<PopulationEntity> getPopulationInPopulationInContinent(@RequestParam String continent){
        return populationService.getPopulationInContinent(continent);
    }

    @GetMapping("/region")
    public List<PopulationEntity> getPopulationInPopulationInRegion(@RequestParam String region){
        return populationService.getPopulationInRegion(region);
    }

    @GetMapping("/country")
    public List<PopulationEntity> getPopulationInPopulationInCountry(@RequestParam String country){
        return populationService.getPopulationInCountry(country);
    }

    @GetMapping("/city")
    public List<PopulationEntity> getPopulationInPopulationInCity(@RequestParam String city){
        return populationService.getPopulationInCity(city);
    }

    @GetMapping("/district")
    public List<PopulationEntity> getPopulationInDistrict(@RequestParam String district){
        return populationService.getPopulationInDistrict(district);
    }

}



