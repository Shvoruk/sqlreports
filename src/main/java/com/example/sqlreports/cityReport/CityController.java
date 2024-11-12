package com.example.sqlreports.cityReport;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/world")
    public List<CityEntity> getCitiesInWorld() {
        return cityService.getAllCountriesInWorld();
    }

    @GetMapping("/continent")
    public List<CityEntity> getCitiesInContinent(@RequestParam String continent) {
        return cityService.getAllCountriesInContinent(continent);
    }

    @GetMapping("/region")
    public List<CityEntity> getCitiesInRegion(@RequestParam String region) {
        return cityService.getAllCountriesInRegion(region);
    }

    @GetMapping("/country")
    public List<CityEntity> getCitiesInCountry(@RequestParam String country) {
        return cityService.getAllCountriesInCountry(country);
    }

    @GetMapping("/district")
    public List<CityEntity> getCitiesInDistrict(@RequestParam String district) {
        return cityService.getAllCountriesInDistrict(district);
    }
}
