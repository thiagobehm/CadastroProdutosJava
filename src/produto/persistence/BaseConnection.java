/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thiago
 */
public class BaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306" ;
    private static final String USER = "root";
    private static final String PASSWORD = "221191";
    
    public BaseConnection(){}
   
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conexao = null;

        try {
            BaseConnection.loadDriver();
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (Exception e) {
            System.out.print("Exception: " + e.getMessage());
        }
        
        return conexao;
    }
    
    private static void loadDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }
    
}
