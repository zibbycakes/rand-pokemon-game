package com.pokerand.rest;

import com.pokerand.config.MySQLDatabase;
import com.pokerand.service.api.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
public class AppResource {
    @Autowired
    private Environment env;

    @Autowired
    private PokemonService pokemonService;

    @RequestMapping("/")
    public String index()
    {
        return "Hello from Spring Boot! You've made it to the index.";
    }

    @RequestMapping("/{id}")
    public ResponseEntity<String> pokemon(@PathVariable String id)
    {
        Connection con = null;
        try
        {
            con = MySQLDatabase.getConnection(env);
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error in database connection.");
        }
        return pokemonService.getDetails(con, Integer.parseInt(id), env);
    }
}
