package com.kofti.demo.service;

import com.kofti.demo.model.RoleKofti;
import com.kofti.demo.model.UserKofti;

public interface Iservice {

    public UserKofti addUser (String userName , String password , String email);
    public RoleKofti addRole (RoleKofti roleKofti);
    public UserKofti loadUserByUserName ( String userName);
    public  void  addRoleToUser(String nameRole , String userName);
}
