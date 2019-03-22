/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nostalciac.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nostalciac.entity.Tag;

/**
 *
 * @author tss
 */
@Stateless
public class TagStore {
    // Se abbiamo più di un DB dobbiamo ini darglielo,
    @PersistenceContext()
    EntityManager em;
    
    /***
     * Restituisce tutti i tag
     * @return 
     */
    public List<Tag> all(){
        // Dammi tutti 
        return em.createQuery ("select e FROM Tag e ORDER BY e.tag ", Tag.class)
                .getResultList();
    }
    
    // per salvare nuovo record su DB
    public Tag create(Tag tag){
        return em.merge(tag);
    }
    
    /***
     * Insert o Update su DB
     * @param tag
     * @return 
     */
    public Tag save(Tag tag){
        return em.merge(tag);
    }
    
    /**
     * Ritorna il tag con ID passato
     * @param id
     * @return 
     */
    public Tag find(int id){
        return em.find(Tag.class, id);
    }
    
    /**
     * Cancella il record passando l'ID
     * @param id 
     */
    public void remove(int id){
        // prima si cerca per ID e poi si cancella
        Tag toremove=em.find(Tag.class, id);
        em.remove(toremove);
    }
}
