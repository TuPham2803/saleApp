/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kt.hibernate;

import com.kt.pojo.Category;
import com.kt.pojo.Comment;
import com.kt.pojo.OrderDetail;
import com.kt.pojo.ProdTag;
import com.kt.pojo.Product;
import com.kt.pojo.SaleOrder;
import com.kt.pojo.Tag;
import com.kt.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernatUtils {

    /**
     * @return the factory
     */
    public static SessionFactory getFactory() {
        return factory;
    }

    private static final SessionFactory factory;

    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT,
                "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER,
                "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL,
                "jdbc:mysql://localhost:3306/saledb");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "Admin@123");
        conf.setProperties(props);

        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(Tag.class);
         conf.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        factory = conf.buildSessionFactory(serviceRegistry);

    }

}
