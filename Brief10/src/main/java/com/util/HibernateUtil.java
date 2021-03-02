package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.model.Client;
import com.model.FAQ;
import com.model.RDV;
import com.model.Vet;

 

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {

        if(sessionFactory == null)
        {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/Vet");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "m1e2r3y4");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                 configuration.setProperties(settings);
                 configuration.addAnnotatedClass(Client.class);
                 configuration.addAnnotatedClass(Vet.class);
                 configuration.addAnnotatedClass(RDV.class);
                 configuration.addAnnotatedClass(FAQ.class);

             ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            	catch(Exception e)
            {
                e.printStackTrace();

            }



        }
        return sessionFactory;
    }




}