package com.kofti.demo.Web;

import com.kofti.demo.model.UserKofti;
import com.kofti.demo.service.Iservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControleurUser {


    @Autowired
       Iservice iservice ;

    @PostMapping ("/register")
    public UserKofti register(@RequestBody UserKofti userKofti){

        return  iservice.addUser(userKofti.getNameUser() , userKofti.getPassword(),userKofti.getMailUser()) ;
    }

}
