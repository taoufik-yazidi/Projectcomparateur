package com.kofti.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class UserKofti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idUserKofti ;
    private  String nameUser ;
    private  String mailUser ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String  password ;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleKofti>roleKoftis = new ArrayList<>();

    public UserKofti(Integer idUserKofti, String nameUser, String mailUser) {
        this.idUserKofti = idUserKofti;
        this.nameUser = nameUser;
        this.mailUser = mailUser;

    }

    public UserKofti(String nameUser, String mailUser, String password) {
        this.nameUser = nameUser;
        this.mailUser = mailUser;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserKofti(String nameUser, String mailUser) {
        this.nameUser = nameUser;
        this.mailUser = mailUser;
    }

    public UserKofti() {
    }

    public Integer getIdUserKofti() {
        return idUserKofti;
    }

    public void setIdUserKofti(Integer idUserKofti) {
        this.idUserKofti = idUserKofti;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public Collection<RoleKofti> getRoleKoftis() {
        return roleKoftis;
    }

    public void setRoleKoftis(Collection<RoleKofti> roleKoftis) {
        this.roleKoftis = roleKoftis;
    }
}
