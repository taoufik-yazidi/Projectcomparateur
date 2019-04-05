package com.kofti.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoleKofti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idRole ;
    private  String nameRole ;

    public RoleKofti(Integer idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    public RoleKofti(String nameRole) {
        this.nameRole = nameRole;
    }

    public RoleKofti() {
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
