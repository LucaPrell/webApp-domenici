/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */
//Guarda dove è mappata, Payara, quando riceve una chiamata ad hello e crea un'istanza
// Servlet vanno benissimo per inteccettare richieste, un po' meno nel rispondere
@WebServlet("/hello")
public class Messages extends HttpServlet{

    @Override
    // ci passa due parametri req(informazioni della richiesta, es i dati del form utente)
    // il secondo parametro resp(risposta html dinamico)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //messaggio verrà stampato sulla console di Payara
        System.out.println("ho ricevuto una richiesta");
        
        System.out.println(req.getParameter("id"));
        
        
        PrintWriter wr =resp.getWriter();
        wr.println("<h1>Hello from servlet..</h1><h2>Java rules!!</h2>");
    }
    
    
    
}
