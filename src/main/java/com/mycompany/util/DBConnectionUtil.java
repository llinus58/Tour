/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Trieu
 */
public class DBConnectionUtil {
     private static final String URL = "jdbc:mysql://localhost:3306/tourfinal?useUnicode=yes&characterEncoding=UTF-8"; //"jdbc:mysql://localhost:3306/eitea","root",""
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }
    
    
}
