package com.pokerand.service.DAO;

import org.springframework.core.env.Environment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PokemonDAO {
    Map<Integer, List<String>> getDetails(Connection con, int pkmnId, Environment env) throws SQLException;
}
