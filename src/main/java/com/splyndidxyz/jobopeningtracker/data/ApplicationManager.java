package com.splyndidxyz.jobopeningtracker.data;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;

public class ApplicationManager {

    // A SessionFactory is set up once for an application!
    SessionFactory factory;
    final StandardServiceRegistryBuilder reg_builder;
    StandardServiceRegistry reg;


    public ApplicationManager(){
            factory = new Configuration().configure().buildSessionFactory();
            reg_builder = new StandardServiceRegistryBuilder();
            reg_builder.applySettings(factory.getProperties());
            reg = reg_builder.build();

    }
    /* Method to CREATE an Application in the database */
    public Integer addApplication(String fname, String lname, int salary){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer ApplicationID = null;

        try {
            tx = session.beginTransaction();
            Application Application = new Application();
            ApplicationID = (Integer) session.save(Application);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ApplicationID;
    }

    /* Method to UPDATE salary for an Application */
    public void updateApplication(Integer ApplicationID, String[] newData ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Application Application = session.get(Application.class, ApplicationID);
            Application.setPosition(newData[1]);
            session.update(Application);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an Application from the records */
    public void deleteApplication(Integer ApplicationID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Application Application = (Application)session.get(Application.class, ApplicationID);
            session.delete(Application);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to  READ all the Applications */
    public void listApplications( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List applications = session.createQuery("FROM Application").list();
            for (Iterator iterator = applications.iterator(); iterator.hasNext();) {
                Application application = (Application) iterator.next();
                tx.commit();
            }
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
