package com.jt.backend.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	public static Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/RestriccionVehicular";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }
	
}


/*
 * Base de datos alojada en docker
 * 
 * nombre:picoplaca_mysql_db
 * crear:
 * docker run -p 3306 --name picoplaca_mysql_db -e MYSQL_ROOT_PASSWORD=root
 * abrir el bash del docker:
 * docker exec -it picoplaca_mysql_db bash
 * 
 * 
 *
 * */
 