package com.example.org.cafeteria;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import org.cafeteria.model.Usuario;

public class MainMenu {
    private com.example.org.cafeteria.Usuario usuario;

    public MainMenu(com.example.org.cafeteria.Usuario usuario) {
        this.usuario = usuario;
    }

    public void mostrar(Stage stage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        Button productos = new Button("☕ Gestión de Productos");
        Button clientes = new Button("👥 Gestión de Clientes");
        Button ventas = new Button("💰 Registrar Ventas");

        if (usuario.getRol() == com.example.org.cafeteria.Usuario.Rol.CAJERO)
            productos.setDisable(true);

        root.getChildren().addAll(productos, clientes, ventas);
        stage.setScene(new Scene(root, 400, 300));
        stage.setTitle("Menú Principal - " + usuario.getRol());
        stage.show();
    }
}
