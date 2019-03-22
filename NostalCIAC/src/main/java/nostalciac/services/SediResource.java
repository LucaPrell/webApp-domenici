/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nostalciac.services;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import nostalciac.business.SedeStore;
import nostalciac.entity.Sede;

/**
 *
 * @author tss
 */

@Path("sedi")
public class SediResource {
    
    // Tramite Pajara istanzio l'oggetto
    @Inject
    SedeStore store;
    
    // Espongo il metodo di ricerca GET 
    // che restituisce tutti i record
    @GET
    public List<Sede> findAll(){
        return store.all();
    }
    
    // Espongo il metodo di ricerca GET 
    // che restituisce per SEDE e CITTA'
    @GET
    @Path("search")
    public List<Sede> search(
            @QueryParam("nome") String searchSede,
            @QueryParam("citta") String searchCitta){
        return store.search(searchSede, searchCitta);
    }
    
    // Espongo il metodo di ricerca GET 
    // per ID
    @GET
    @Path("{id}")
    public Sede find(@PathParam("id") int id){
        return store.find(id);
    }

    // Espongo il metodo di salvataggio POST 
    // carica su DB il record
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Sede sede) {
         store.create(sede);
    }
    
    // Espongo il metodo di update PUT 
    // aggiorna su DB il record indicato con id
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void update(@PathParam("id") int id,Sede sede){
        // se id esiste nel DB faccio un aggiornamento
        // altrimenti lo creo nuovo
        sede.setId(id);
        store.save(sede);
    }
    
    // Espongo il metodo di update DELETE
    // cancello il record indicato con id
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id){
        store.remove(id);
    }
    
    
    
    
            
    
}
