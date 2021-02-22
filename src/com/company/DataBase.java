package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

//This class handles the database
public class DataBase {
    public static Connection getConnection() {
        try {
            String username = "root";
            String password = "Branham11";
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/eaglesgroup.db";
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Connected");
        }
        return null;

    }
    public void getDataConnection() {
        getConnection();
    }
}
