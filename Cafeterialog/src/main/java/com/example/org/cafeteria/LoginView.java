package com.example.org.cafeteria;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LoginView {
    public void mostrar(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label title = new Label("🍵 Iniciar sesión - Cafetería");
        TextField userField = new TextField();
        userField.setPromptText("Usuario");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Contraseña");

        Button loginBtn = new Button("Ingresar");

        loginBtn.setOnAction(e -> {
            try {
                com.example.org.cafeteria.Usuario user = new com.example.org.cafeteria.LoginService().login(userField.getText(), passField.getText());
                Alert ok = new Alert(Alert.AlertType.INFORMATION, user.generarSaludo());
                ok.showAndWait();
                new MainMenu(user).mostrar(stage);
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
            }
        });

        root.getChildren().addAll(title, userField, passField, loginBtn);
        stage.setScene(new Scene(root, 350, 250));
        stage.setTitle("Login Cafetería");
        stage.show();
    }
}
