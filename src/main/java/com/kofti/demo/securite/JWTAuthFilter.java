package com.kofti.demo.securite;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kofti.demo.model.UserKofti;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter {

    AuthenticationManager authenticationManager ;

    public JWTAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        try {
            UserKofti userKofti = new ObjectMapper().readValue(request.getInputStream(),UserKofti.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userKofti.getNameUser()
                    ,userKofti.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        User user = (User) authResult.getPrincipal();
        List<String>list = new ArrayList<String>();
        authResult.getAuthorities()
                .forEach(o -> {
                    list.add(o.getAuthority());
                });

        String jwt = JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withArrayClaim("role", list.toArray(new String[list.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis()+10*24*3600))
                .sign(Algorithm.HMAC256("zoro"));
        response.addHeader("auto",jwt);
    }
}
