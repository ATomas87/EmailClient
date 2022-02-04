module EmailClient {
     requires javafx.fxml;
     requires javafx.controls;
     requires javafx.graphics;
     requires javafx.web;
     requires activation;
     requires java.mail;

     opens com.antonio;
     opens com.antonio.view;
     opens com.antonio.controller;

}