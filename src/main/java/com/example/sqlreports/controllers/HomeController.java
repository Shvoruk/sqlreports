package com.example.sqlreports.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/api/countries")
    public String home(){
        return "test controller";
    }
}
