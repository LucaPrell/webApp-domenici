/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author tss
 */
public class DSManager {

    public static Connection connection() {
        
        try {
            // Chiediamo connessione a PAYARA
            InitialContext ctx = new InitialContext();

            DataSource ds = (DataSource) ctx.lookup("jdbc/classicmodelsDS");

            return ds.getConnection();

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(DSManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Problemi nel recuperare la connessione a db");
        }
    }
}