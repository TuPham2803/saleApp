/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kt.repository.impl;

import com.kt.hibernate.HibernatUtils;
import com.kt.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductReposityImpl  {
    private static final int PAGE_SIZE = 4;
    public List<Product> getProducts(Map<String, String> params) {
        try (Session s = HibernatUtils.getFactory().openSession()){
            
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            if(params != null )
            {
                List<Predicate> predicates = new ArrayList<> ();
                String kw = params.get("q");
                if(kw != null && !kw.isEmpty()){
                    Predicate p1 = b.like(root.get("name"), String.format("%%s%%", kw));
                    predicates.add(p1);
                }
                
                String fromPrice = params.get("fromPrice");
                if(kw != null && !kw.isEmpty()){
                    Predicate p2 = b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice));
                    predicates.add(p2);
                }
                
                String toPrice = params.get("toPrice");
                if(toPrice != null && !toPrice.isEmpty()){
                    Predicate p3 = b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice));
                    predicates.add(p3);
                }
                
                String cateId = params.get("cateId");
                if(toPrice != null && !toPrice.isEmpty()){
                    Predicate p4 = b.equal(root.get("category"), Integer.parseInt(cateId));
                    predicates.add(p4);
                }
                
                q.where(predicates.toArray(Predicate[]::new));
            }
            Query query = s.createQuery(q);
            
            if (params != null) {
                String page = params.get("page");
                if(page != null && !page.isEmpty()){
                    int p = Integer.parseInt(page);
                    int start = (p - 1) * PAGE_SIZE;
                    
                    query.setFirstResult(start);
                    query.setMaxResults(PAGE_SIZE);
                }
           
        }
            
            
            
            return query.getResultList();
            
        }
    }
}
