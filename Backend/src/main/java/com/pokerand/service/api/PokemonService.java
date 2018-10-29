package com.pokerand.service.api;


import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;

public interface PokemonService {
    public ResponseEntity<String> getDetails(Connection con, int pkmnId, Environment env);
}
