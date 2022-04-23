package com.example.hw17servlet.secondPartOfServlet.repository;

import com.example.hw17servlet.secondPartOfServlet.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private SessionFactorySingleton() {}

    private static class Holder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();


            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Person.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }

    public static SessionFactory getInstance() {
        return Holder.INSTANCE;
    }
}
