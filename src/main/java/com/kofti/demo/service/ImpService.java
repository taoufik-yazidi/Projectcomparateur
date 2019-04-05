package com.kofti.demo.service;

import com.kofti.demo.dao.RepoRole;
import com.kofti.demo.dao.RepoUser;
import com.kofti.demo.model.RoleKofti;
import com.kofti.demo.model.UserKofti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ImpService implements Iservice {
            @Autowired
    RepoUser repoUser ;
            @Autowired
            RepoRole repoRole ;

    @Bean
    public BCryptPasswordEncoder password() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override

    public UserKofti addUser(String userName, String password, String email) {

                  UserKofti userKofti = repoUser.findByNameUser(userName);
                  if (userKofti != null) {throw  new RuntimeException("user exist deja");}

                      UserKofti user = new UserKofti(userName ,email,password().encode(password));
                       repoUser.save(user);
                       this.addRoleToUser("USER",userName);
                       return user ;

    }

    @Override
    public RoleKofti addRole(RoleKofti roleKofti) {
        return repoRole.save(roleKofti);
    }

    @Override
    public UserKofti loadUserByUserName(String userName) {
        return repoUser.findByNameUser(userName);
    }

    @Override
    public void addRoleToUser(String nameRole, String userName) {

        UserKofti userKofti = repoUser.findByNameUser(userName);
        RoleKofti roleKofti = repoRole.findByNameRole(nameRole);
        userKofti.getRoleKoftis().add(roleKofti);

    }
}
