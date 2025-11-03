package com.example.ventascafeteria.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NuevoController {

    @FXML
    private TextField txtDato;

    @FXML
    public void guardarDato() {
        System.out.println("cambio de ruta guardar");
        System.out.println("Dato guardado: " + txtDato.getText());
    }
}