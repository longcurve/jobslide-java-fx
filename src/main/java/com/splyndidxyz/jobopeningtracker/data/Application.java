package com.splyndidxyz.jobopeningtracker.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.scene.*;

import java.lang.reflect.Array;
import java.util.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {
    private static SessionFactory factory;

    private Long id;
    private Date Date;
    private String Position;
    private String Company;
    private String Location;
    private String ContactName;
    private String ContactPhone;
    private Array Interviews;
    private Array Calls;

    public Application()
    {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            Alert alert = new Alert(AlertType.ERROR, ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    /* Methods for getting Application data */

    public void setDate(Date date)
    {
        this.Date = date;
    }

    public void setPosition(String position)
    {
        this.Position = position;
    }

    public void setCompany(String company)
    {
        this.Company = company;
    }

    public void setLocation(String location)
    {
        this.Location = location;
    }

    public void setContactName(String contactname)
    {
        this.ContactName = contactname;
    }

    public void setContactPhone(String contactphone)
    {
        this.ContactPhone = contactphone;
    }

    public void setInterviews(Array interviews)
    {
        this.Interviews = interviews;
    }

    public void setCalls(Array calls)
    {
        this.Calls = calls;
    }

    /* Methods for setting Application data */

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return this.Date;
    }

    public String getPosition()
    {
        return this.Position;
    }

    public String getCompany()
    {
        return this.Company;
    }

    public String getLocation()
    {
        return this.Location;
    }

    public String getContactName()
    {
        return this.ContactName;
    }

    public String getContactPhone()
    {
        return this.ContactPhone;
    }

    // The following two methods may need to convert from Array to observableArrayList before returning
    // their value.
    public Array getInterviews()
    {
        return this.Interviews;
    }

    public Array getCalls()
    {
        return this.Calls;
    }
}
