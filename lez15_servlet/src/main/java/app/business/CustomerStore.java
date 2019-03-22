/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.business;

import app.models.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author tss
 */
// dentro nome posso dare parametri
// serve solo per le JSP, non si mette in questo posto
@Named("db")
// si fa diventara un EJB (Enterprise Java Bean)
// per classi che fanno le query al 99% risolvono i problemi
// dichiararle come Staless e vengono gestite dal Web Application Server (Payara)
@Stateless
public class CustomerStore {

    public List<Customer> searchCustomer(String search) {
        // gestione di connesione la fa DSManager
        try (Connection cn = DSManager.connection();) {
            
            // prepara lista vuota
            List<Customer> result = new ArrayList<>();

            // try con resources
            try (Statement cmd = cn.createStatement();
                    ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                            + " from customers "
                            + " where customerName like '" + search + "%' order by customerName")) {
                // per ogni record creo oggetto Customer
                // alla fine abbiamo una lista di oggetti
                while (query.next()) {
                    result.add(new Customer(query.getInt("customerNumber"),
                            query.getString("customerName")));
                }
            }
            
            return result;
        // gestione eccezione 
        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManager error");
        }
    }

    // fa all'incirca la stessa cosa del metodo searchCustomer, solo che non hai il "where" nella query, per selezionare tutti i customer (clienti)
    public List<Customer> findAll() {
        // gestione di connesione la fa DSManager
        try(Connection cn = DSManager.connection();) {
            
            // prepara lista vuota
            List<Customer> result = new ArrayList<>();

            // try con resources
            try (Statement cmd = cn.createStatement();
                    ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                            + " from customers order by customerName")) {
                // per ogni record creo oggetto Customer
                // alla fine abbiamo una lista di oggetti
                while (query.next()) {
                    result.add(new Customer(query.getInt("customerNumber"),
                            query.getString("customerName")));
                }
            }
            
            return result;
        // gestione eccezione 
        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManager error");
        }
        
    }

    public Customer find(int id) {
        // gestione di connesione la fa DSManager
        try(Connection cn = DSManager.connection();) {
            // prepara lista vuota
            Customer result=null;

            // try con resources
            try (Statement cmd = cn.createStatement();
                    ResultSet query = cmd.executeQuery("select customerNumber,customerName"
                            + " from customers "
                            + " where customerNumber = " + id )) {
                // per ogni record creo oggetto Customer
                // alla fine abbiamo una lista di oggetti
                if (query.next()) {
                    result=new Customer(query.getInt("customerNumber"),
                            query.getString("customerName"));
                }
            }
            
            return result;
        // gestione eccezione 
        } catch (SQLException ex) {
            Logger.getLogger(CustomerStore.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("DbManager error");
        }
    }
}
