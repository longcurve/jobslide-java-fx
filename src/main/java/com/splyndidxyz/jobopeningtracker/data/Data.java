/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.splyndidxyz.jobopeningtracker.data;

import com.splyndidxyz.jobopeningtracker.App;
import java.sql.*;
import java.util.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.control.Alert.AlertType;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author jubale
 */
public class Data {

    static final Logger logger = Logger.getLogger(App.class.getName());

    static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private String framework = "embedded";
    static private String protocol = "jdbc:derby:";
    static private String dbName = "job-opening-tracker";
    static Connection connection = null;
    static Alert alrtInformUser = new Alert(AlertType.INFORMATION);

    private static ArrayList<Statement> statements = new ArrayList<Statement>(); // list of Statements, PreparedStatements

    private static ObservableList interviews = FXCollections.observableArrayList();
    private static ObservableList calls = FXCollections.observableArrayList();

    public Data()
    {
        // Currently the constructor does nothing
    }

    public static ObservableList getInterviews() {
        return interviews;
    }

    public static ObservableList getCalls() {
        return calls;
    }

    public static Connection getDBConnection() throws SQLException {

    }

    public void getEntries() {

        PreparedStatement psEntries;
        ResultSet rs = null;


        try {
            String sql = "SELECT * FROM applications WHERE NOT NULL";
            psEntries = connection.prepareStatement(sql);

            try (ResultSet resultSet = psEntries.executeQuery()) {
                while (resultSet.next()) {

                }
            }



            System.out.println("Get all applications");
        } catch(Exception ex) {
            
        }
        
    }
}
