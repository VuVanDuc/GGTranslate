/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ggtranslate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author VuDuc
 */
public class DatabaseHelper {
    protected Connection connection;
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final String HOST = "jdbc:mysql://localhost:3306/ggtranslate?useUnicode=yes&characterEncoding=UTF-8";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public Connection openConnection() throws ClassNotFoundException, SQLException {
        try {
            if (connection == null) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return connection;
    }
    
    public void closeConnection() throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
}
