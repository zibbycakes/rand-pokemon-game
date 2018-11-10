package com.pokerand.service.Impl;

import com.pokerand.model.PokemonConvert;
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
        PokemonConvert pokemonConvert = new PokemonConvert();
        Map<Integer, List<String>> queryResults = new HashMap<Integer, List<String>>();
        String app = "";
        try
        {
            queryResults = pokemonDAO.getDetails(con, pkmnId, env);
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Problem in query");

        }
        /*for(int k : queryResults.keySet())
        {
            app+= k + " : { \n";
            for(String val: queryResults.get(k))
            {
                app+= "\t" +val+"\n";
            }
            app +="\n";

        }*/
        app = pokemonConvert.conversion(queryResults);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(app,responseHeaders, HttpStatus.OK);
    }
}
