/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

// Strumenti per implementare Web Services REST FULL
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author tss
 */
// specifichiamo il path iniziale per accedere alle risorse
// La classe tendenzialmente si lascia vuota
@ApplicationPath("/api")
public class JAXRSConfiguration  extends Application{
    
}
