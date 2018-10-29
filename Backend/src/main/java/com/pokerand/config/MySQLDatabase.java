package com.pokerand.config;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Component
public class MySQLDatabase {
    /* provides connection to MySQL Database using properties config */
    public static Connection getConnection(Environment env) throws SQLException
    {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex)
        {
            System.err.println("Driver not found: " + ex.toString());
        }

        Properties props = new Properties();
        props.put("user", env.getProperty("database.user"));
        props.put("password", env.getProperty("database.password"));
        //props.put("database", env.getProperty("database.name");

        String connectStr = "jdbc:mysql://mysqlpokemondb.c4upghhstizl.us-east-2.rds.amazonaws.com:3306/" + env.getProperty("database.name");
        return DriverManager.getConnection(connectStr,props);

    }
}
