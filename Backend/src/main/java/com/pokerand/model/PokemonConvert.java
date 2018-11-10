package com.pokerand.model;

import java.util.List;
import java.util.Map;

public class PokemonConvert {

    public String conversion(Map<Integer, List<String>> data)
    {
        String result = "{\n";
        //just one pokemon
        if(data.keySet().size()==1)
        {
            //should only run once
            for(int k : data.keySet())
            {
                result += "\t\"" + k + "\": {\n";
                for(String item : data.get(k))
                {
                    String[] temp = item.split("_");
                    String info_name = temp[0];
                    String info_value = temp[1];
                    result += "\t\t\"" + info_name + "\": \"" +info_value + "\",\n";
                }
                result = result.substring(0,result.length()-1) + "\n\t}\n";
            }
        }
        result += "}";
        return result;
    }
}
