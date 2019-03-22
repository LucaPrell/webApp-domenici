/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.business.EmployeeStore;
import app.models.Employee;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 *
 * @author tss
 */
// mapperà su un path ogni metodo pubblico http (.../api/customers)
//il path si aggiunge a quello di "entrata", nel nostro caso "/api"
@Path("/employees")
public class EmployeeResources {
    
    // su server non si fanno istanze ma si usa @Inject
    @Inject
    EmployeeStore manager;
    
    // dobbiamo dire dove  mappare il metodo
    @GET
    public List<Employee> all(){
        return manager.findAll();
        
    }
    
    @GET
    // vuol dire che aggiungo al path padre ("/employees") con un parametro
    @Path("{id}")
    public Employee find(@PathParam("id") int id){
        return manager.find(id);
    }
    
    @GET
    @Path("search")
    // sull'url dovrò scrivere "/search?name=''"
    public List<Employee> searchByName(@QueryParam("officeCode") String name){
        return manager.searchEmployee(name);
                
        
    }
}
