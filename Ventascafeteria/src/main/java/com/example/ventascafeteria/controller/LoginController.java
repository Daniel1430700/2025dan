package com.example.ventascafeteria.controller;


import com.example.ventascafeteria.components.Toast;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import com.example.ventascafeteria.components.StageManager;
import com.example.ventascafeteria.components.Toast;
import com.example.ventascafeteria.dto.SessionManager;
import com.example.ventascafeteria.model.Usuario;
import com.example.ventascafeteria.service.IUsuarioService;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Controller
public class LoginController {

    @Autowired
    private ApplicationContext context;
    @Autowired
    IUsuarioService us;
    @FXML
    TextField txtUsuario;
    @FXML
    PasswordField txtClave;
    @FXML
    Button btnIngresar;

    @FXML
    public void cerrar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Platform.exit();
        System.exit(0);
    }
//codigo moderno
    @FXML
    public void login(ActionEvent event) throws IOException {
        try {
            String ruta = "/view/main_producto.fxml";
            URL url = getClass().getResource(ruta);
            System.out.println("FXML encontrado correctamente en: " + url);

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);

            stage.setTitle("Cafetería Ventas SysCenterLife");
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();

            System.out.println("Cambio de ventana exitoso.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al intentar cargar la nueva vista: " + e.getMessage());
        }
    }


}
