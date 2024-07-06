/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kt.repository.impl;

import com.kt.hibernate.HibernatUtils;
import com.kt.pojo.Category;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class CategoryRepositoryImpl {
    public List<Category> getCates(){
        try (Session s = HibernatUtils.getFactory().openSession()){
            Query q = s.createQuery("From Category");
            return q.getResultList();
            
        }
    }
    
}
