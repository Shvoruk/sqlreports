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
    public List<CityEntity> getCitiesInWorld( @RequestParam(required = false) Integer limit) {
        if(limit != null){
            return cityService.getAllCitiesInWorldLimited(limit);
        }
        return cityService.getAllCitiesInWorld();
    }

    @GetMapping("/continent")
    public List<CityEntity> getCitiesInContinent(@RequestParam String continent,  @RequestParam(required = false) Integer limit) {
        if(limit != null){
            return cityService.getAllCitiesInContinentLimited(continent, limit);
        }
        return cityService.getAllCitiesInContinent(continent);
    }

    @GetMapping("/region")
    public List<CityEntity> getCitiesInRegion(@RequestParam String region,  @RequestParam(required = false) Integer limit) {
        if(limit != null){
            return cityService.getAllCitiesInRegionLimited(region, limit);
        }
        return cityService.getAllCitiesInRegion(region);
    }

    @GetMapping("/country")
    public List<CityEntity> getCitiesInCountry(@RequestParam String country,  @RequestParam(required = false) Integer limit) {
        if(limit != null){
            return cityService.getAllCitiesInCountryLimited(country, limit);
        }
        return cityService.getAllCitiesInCountry(country);
    }

    @GetMapping("/district")
    public List<CityEntity> getCitiesInDistrict(@RequestParam String district,  @RequestParam(required = false) Integer limit) {
        if(limit != null){
            return cityService.getAllCitiesInDistrictLimited(district, limit);
        }
        return cityService.getAllCitiesInDistrict(district);
    }
}
