package com.kofti.demo;

import com.kofti.demo.model.RoleKofti;
import com.kofti.demo.service.Iservice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    CommandLineRunner Start (Iservice iservice){
        return  args -> {

            RoleKofti roleKofti = new RoleKofti("USER");
               //   iservice.addRole(roleKofti);
                //  iservice.addUser("toto8", "123","taoufik.yazidi@gmail.com");
        };
    }

}

