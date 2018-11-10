package com.pokerand.service.DAO;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.pokerand.service.DAO.PokemonDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@Component
public class PokemonDAOImpl implements PokemonDAO {

    @Override
    public Map<Integer, List<String>> getDetails(Connection con, int pkmnId, Environment env)
    {
        Map<Integer, List<String>> endResults = new HashMap<Integer, List<String>>();
        Statement statement = null;
        String query = "select * from Pokemon where pkmn_no =" + pkmnId +";";
        System.out.println(query);

        try
        {
            statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                int pkmnno = resultSet.getInt("pkmn_no");
                String name = resultSet.getString("name");
                String generation = resultSet.getString("gen");
                String type1 = resultSet.getString("type1");
                String type2 = resultSet.getString("type2");
                String sprite = resultSet.getString("sprite");

                List<String> pkmnInfo = new ArrayList<String>();
                pkmnInfo.add("name_"+name);
                pkmnInfo.add("gen_"+generation);
                pkmnInfo.add("t1_"+type1);
                pkmnInfo.add("t2_"+type2);
                pkmnInfo.add("sprite_"+sprite);

                endResults.put(pkmnno, pkmnInfo);
            }

        } catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Could not query: " + ex.toString());
        }
        return endResults;
    }
}
