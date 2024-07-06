/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.kt.hibernate;

import com.kt.repository.impl.CategoryRepositoryImpl;
import com.kt.repository.impl.ProductReposityImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class Hibernate {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCates().forEach(c ->System.out.println(c.getName())); 
          Map<String, String> params = new HashMap<>();
//          params.put("q","Iphone");
          params.put("page","1");
          ProductReposityImpl s = new ProductReposityImpl();
          s.getProducts(params).forEach(p -> System.out.printf("%s - %.1f\n", p.getName() , p.getPrice()));
    }
}
