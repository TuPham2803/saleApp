/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kt.repository.impl;

import com.kt.hibernate.HibernatUtils;
import com.kt.pojo.User;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class UserRepositoryImpl {
    public User getUserByUserName( String username) {
        try (Session s = HibernatUtils.getFactory().openSession()){
            Query q = s.createNamedQuery("User.findByUserName");
            q.setParameter(("username"), username);
            
            return (User) q.getSingleResult();
        }
    }
}
