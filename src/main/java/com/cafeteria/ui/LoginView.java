package com.cafeteria.ui;

import com.cafeteria.dao.UserDAO;
import com.cafeteria.model.User;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import com.cafeteria.ui.AdminView;
import com.cafeteria.ui.VendorView;

public class LoginView {
    private BorderPane view;
    private Stage primary;

    public LoginView(Stage primary) {
        this.primary = primary;
        view = new BorderPane();
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));
        Label title = new Label("Iniciar Sesión");
        TextField userField = new TextField();
        userField.setPromptText("Usuario");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Contraseña");
        Button btnLogin = new Button("Login");
        Label msg = new Label();
        box.getChildren().addAll(title, userField, passField, btnLogin, msg);
        view.setCenter(box);
        btnLogin.setOnAction(ev -> {
            String user = userField.getText().trim();
            String pass = passField.getText().trim();
            try {
                User u = UserDAO.findByUsername(user);
                if (u != null && u.getPassword().equals(pass)) {
                    if ("ADMIN".equalsIgnoreCase(u.getRole())) {
                        AdminView av = new AdminView(primary, u);
                        primary.getScene().setRoot(av.getView());
                    } else {
                        VendorView vv = new VendorView(primary, u);
                        primary.getScene().setRoot(vv.getView());
                    }
                } else {
                    msg.setText("Credenciales incorrectas");
                }
            } catch (Exception e) {
                e.printStackTrace();
                msg.setText("Error al autenticar");
            }
        });
    }

    public Parent getView() { return view; }
}
