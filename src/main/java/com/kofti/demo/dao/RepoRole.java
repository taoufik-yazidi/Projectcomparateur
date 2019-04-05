package com.kofti.demo.dao;

import com.kofti.demo.model.RoleKofti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRole extends JpaRepository <RoleKofti , Integer> {

    public  RoleKofti findByNameRole(String roleName);
}
