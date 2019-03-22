/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.Objects;

/**
 *
 * @author tss
 */
public class Employee {
    // field employeeNumber
    private int idEmp;
    
    // field lastName
    private String lastName;
    
    // field firstName
    private String firstName;
    
    // field officeCode
    private String idOffice;

    public Employee(int idEmp, String lastName, String firstName, String idOffice) {
        this.idEmp = idEmp;
        this.lastName = lastName;
        this.firstName = firstName;
        this.idOffice = idOffice;
    }

    public Employee() {
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIdOffice() {
        return idOffice;
    }

    public void setIdOffice(String idOffice) {
        this.idOffice = idOffice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idEmp;
        hash = 67 * hash + Objects.hashCode(this.lastName);
        hash = 67 * hash + Objects.hashCode(this.firstName);
        hash = 67 * hash + Objects.hashCode(this.idOffice);
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
        final Employee other = (Employee) obj;
        if (this.idEmp != other.idEmp) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        return Objects.equals(this.idOffice, other.idOffice);
    }
    
    
}
