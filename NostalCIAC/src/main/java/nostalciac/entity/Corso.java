/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nostalciac.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_corsi")
public class Corso implements Serializable{
    @Id
    @Column(name = "id_corso")
    private int id;
    
    @Column(name = "nome_corso")
    private String nome;
    
    @Column(name = "edizione")
    private String edizione;
    
    @Column(name = "data_inizio")
    private LocalDate inizio;
    
    @Column(name = "data_fine")
    private LocalDate fine;
    
    @Column(name = "note_corso")
    private String note;
    
    // per aggiungere un field con foreign keys
    //          siccome abbiamo un oggetto che ha il field mappato
    // possiamo usare l'oggetto Sede (già definito)
    @ManyToOne()
    @JoinColumn(name="id_sede", referencedColumnName = "id_sede")
    private Sede sede;
    
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
    

    public Corso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEdizione() {
        return edizione;
    }

    public void setEdizione(String edizione) {
        this.edizione = edizione;
    }

    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Corso other = (Corso) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Corso{" + "id=" + id + ", nome=" + nome + ", edizione=" + edizione + ", inizio=" + inizio + ", fine=" + fine + ", note=" + note + '}';
    }
    
    
    
}
