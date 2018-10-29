package com.pokerand.service.Impl;

import com.pokerand.service.DAO.PokemonDAO;
import com.pokerand.service.api.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PokemonServiceImpl implements PokemonService {
    @Autowired
    private PokemonDAO pokemonDAO;

    @Override
    public ResponseEntity<String> getDetails(Connection con, int pkmnId, Environment env)
    {
        Map<Integer, List<String>> queryResults = new HashMap<Integer, List<String>>();
        try
        {
            queryResults = pokemonDAO.getDetails(con, pkmnId, env);
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Problem in query");

        }
        System.out.println(queryResults.keySet().toString());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>("test",responseHeaders, HttpStatus.OK);
    }
}
