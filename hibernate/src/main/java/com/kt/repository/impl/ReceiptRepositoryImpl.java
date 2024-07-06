/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kt.repository.impl;

import com.kt.hibernate.HibernatUtils;
import com.kt.pojo.Cart;
import com.kt.pojo.OrderDetail;
import com.kt.pojo.SaleOrder;
import static com.kt.pojo.User_.username;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ReceiptRepositoryImpl {
    private static final UserRepositoryImpl u = new UserRepositoryImpl();
    private static final ProductReposityImpl pr = new ProductReposityImpl();
    public void addReceipt(List<Cart> carts) {
        if(carts != null )
        {
            try (Session s = HibernatUtils.getFactory().openSession()){
               SaleOrder order = new SaleOrder();
               order.setUserId(u.getUserByUserName("dhthanh"));
               s.save(order);
               
               for (var c: carts){
                   OrderDetail d = new OrderDetail();
                   d.setUnitPrice(c.getUnitPrice());
                   d.setProductId(pr.ProductById(c.getId()));
                   d.setOrderId(order);
                  
                   s.save(d);
               }
               
            
            
            
        }
        }
    }
    
}
