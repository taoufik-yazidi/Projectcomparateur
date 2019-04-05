package com.kofti.demo.dao;

import com.kofti.demo.model.UserKofti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUser extends JpaRepository<UserKofti , Integer> {
    public  UserKofti findByNameUser(String userName);
}
