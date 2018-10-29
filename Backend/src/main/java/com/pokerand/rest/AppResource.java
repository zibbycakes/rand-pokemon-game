package com.pokerand.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppResource {

    @RequestMapping("/")
    public String index()
    {
        return "Hello from Spring Boot! You've made it to the index.";
    }
}
