package com.kofti.demo.securite;

import com.kofti.demo.model.UserKofti;
import com.kofti.demo.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ImpUserDetailService implements UserDetailsService {

    @Autowired
      Iservice iservice;
    @Override
    public UserDetails loadUserByUsername(String userName ) throws UsernameNotFoundException {
           UserKofti userKofti = iservice.loadUserByUserName(userName);
           if (userKofti==null){throw  new UsernameNotFoundException("invalid User"); }
        Collection<GrantedAuthority>authorities = new ArrayList<>();
           userKofti.getRoleKoftis().forEach(roleKofti -> {
               authorities.add(new SimpleGrantedAuthority(roleKofti.getNameRole()));
           });

        return new User(userKofti.getNameUser(),userKofti.getPassword(),authorities);
    }
}
