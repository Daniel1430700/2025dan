package com.example.org.cafeteria;


import javafx.application.Application;
import javafx.stage.Stage;
//import org.cafeteria.ui.LoginView;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        new com.example.org.cafeteria.LoginView().mostrar(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
