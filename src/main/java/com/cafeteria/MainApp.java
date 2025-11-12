package com.cafeteria;

import com.cafeteria.util.DBUtil;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import com.cafeteria.ui.LoginView;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize DB (creates file and sample data if needed)
        DBUtil.initDatabase();

        LoginView login = new LoginView(primaryStage);
        Scene scene = new Scene(login.getView(), 900, 600);
        primaryStage.setTitle("Cafetería - Sistema de Ventas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
