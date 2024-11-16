package com.example.sqlreports.capitalCityReport;

import com.example.sqlreports.cityReport.CityEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cities/capital")
public class CapitalCityController {

    private final CapitalCityService capitalCityService;

    public CapitalCityController(CapitalCityService capitalCityService) {
        this.capitalCityService = capitalCityService;
    }

    @GetMapping("/world")
    public List<CapitalCityEntity> getCitiesInWorld(@RequestParam(required = false) Integer limit) {
        if(limit != null){
            return capitalCityService.getAllCapitalCitiesInWorldLimited(limit);
        }
        return capitalCityService.getAllCapitalCitiesInWorld();
    }

    @GetMapping("/continent")
    public List<CapitalCityEntity> getCitiesInContinent(@RequestParam String continent, @RequestParam(required = false) Integer limit) {
        if(limit != null){
            return capitalCityService.getAllCapitalCitiesInContinentLimited(continent, limit);
        }
        return capitalCityService.getAllCapitalCitiesInContinent(continent);
    }

    @GetMapping("/region")
    public List<CapitalCityEntity> getCitiesInRegion(@RequestParam String region, @RequestParam(required = false) Integer limit) {
        if(limit != null){
            return capitalCityService.getAllCapitalCitiesInRegionLimited(region, limit);
        }
        return capitalCityService.getAllCapitalCitiesInRegion(region);
    }
}