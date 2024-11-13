package com.example.sqlreports.populationReport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/population")
public class PopulationController {

    private final PopulationRepository populationRepository;

    public PopulationController(PopulationRepository populationRepository) {
        this.populationRepository = populationRepository;
    }

    @GetMapping
    public List<Continent> getPopulationInContinent(){
        return populationRepository.findPopulationInContinent();
    }
}
