/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {

    protected Connection connection;
    protected Statement stmt;

    public Koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pendaftaran_bimbel", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver error: " + ex.getMessage());
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Statement createStatement() throws SQLException {
        return stmt = connection.createStatement();
    }

    public Connection getConnection() {
        return connection;
    }

}
