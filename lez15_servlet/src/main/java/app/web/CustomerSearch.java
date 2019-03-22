/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.web;

import app.business.CustomerStore;
import app.models.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */
@WebServlet("/customer-search")
public class CustomerSearch extends HttpServlet {
    
    @Inject
    CustomerStore manager;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("start ricerca clienti...");
        
        // parametro inserito da utente
        String search = req.getParameter("search");

        System.out.println("ricerca di: " + search);

        PrintWriter wr = resp.getWriter();
        
//        CustomerStore manager = new CustomerStore();
        
        // ritorna una lista di customer in base ai criteri di ricerca
        List<Customer> customers = manager.searchCustomer(search);
        
        // crea la lista HTML di risposta
        wr.println("<h1>Risultato ricerca</h1>");
        
        wr.println("<ul>");
        
        customers.forEach(c -> wr.println("<li>" + c.getName() + "</li>"));
        
        wr.println("</ul>");
        
    }

}