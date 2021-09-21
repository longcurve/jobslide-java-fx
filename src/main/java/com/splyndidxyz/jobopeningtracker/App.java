package com.splyndidxyz.jobopeningtracker;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;

import com.splyndidxyz.jobopeningtracker.data.*;
/**
 * The Application source for Job Opening Tracker. Implementing ApplicationView,
 * New Application, and Login Scenes. 
 */
public class App extends Application {
	
	Data data = new Data();
    @Override
    public void start(Stage stage) throws IOException {
        createNewApplicationView(stage);
    }
    
    public void createNewApplicationView(Stage stage)
    {
    	Group root = new Group();
        Scene scene = new Scene(root, 320, 600);
        GridPane newAppPane = new GridPane();
        ScrollPane scrollPane = new ScrollPane();
        
        Button btnSave = new Button("Save");
        Label lblDate = new Label("Date:");
        Label lblPosition = new Label("Position");
        Label lblCompany = new Label("Company");
        Label lblContactName = new Label("Contact Name:");
        Label lblContactPhone = new Label("Contact Phone:");
        Label lblInterviews = new Label("Interviews:");
        Label lblCalls = new Label("Calls:");
        Label lblStatus = new Label("Status:");
        Label lblMethod = new Label("Method:");
        TextField txtDate = new TextField();
        TextField txtPosition = new TextField();
        TextField txtCompany = new TextField();
        TextField txtContactName = new TextField();
        TextField txtContactPhone = new TextField();
        ListView<String> lstInterviews = new ListView<String>();
        ListView<String> lstCalls = new ListView<String>();

        lstInterviews.setItems(data.getInterviews());
        lstCalls.setItems(data.getCalls());
        
        newAppPane.add(lblDate, 0, 0);
        newAppPane.add(txtDate, 0, 1);
        newAppPane.add(lblPosition,  0, 2);
        newAppPane.add(txtPosition, 0, 3);
        newAppPane.add(lblCompany,  0,  4);
        newAppPane.add(txtCompany,  0,  5);
        newAppPane.add(lblContactName,  0,  6);
        newAppPane.add(txtContactName,  0,  7);
        newAppPane.add(lblContactPhone,  0,  8);
        newAppPane.add(txtContactPhone,  0, 9);
        newAppPane.add(lblInterviews,  0, 10);
        newAppPane.add(lstInterviews,  0,  11);
        newAppPane.add(lblCalls,  0,  12);
        newAppPane.add(lstCalls,  0,  13);
        newAppPane.add(btnSave,  0,  14);
        
        
        scrollPane.setContent(newAppPane);
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
        root.getChildren().add(scrollPane);
        stage.setTitle("Job Opening Tracker - Add New Application");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void createApplicationsView(Stage stage)
    {
    	Group root = new Group();
        Scene scene = new Scene(root, 640, 480);
        GridPane newAppsViewPane = new GridPane();
        
        
    }
    
    public void Login(Stage stage){
        Group root = new Group();
        Scene scene = new Scene(root, 640, 480);
        GridPane gridPane = new GridPane();
        
        Label lblUsername = new Label("Username:");
        Label lblUserpass = new Label("Password:");
        TextField txtUsername = new TextField();
        TextField txtPassword = new TextField();
        
        gridPane.add(lblUsername, 0, 0);
        gridPane.add(lblUserpass, 1, 0);
        
        root.getChildren().add(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    /*static void setRoot(String fxml) throws IOException {
        //scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }*/

    public static void main(String[] args) {
        launch();
    }

}
