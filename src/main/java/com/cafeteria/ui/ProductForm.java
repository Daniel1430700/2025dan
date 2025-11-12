package com.cafeteria.ui;

import com.cafeteria.dao.ProductDAO;
import com.cafeteria.model.Product;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProductForm {
    public static void showForm(Product p, Runnable onSaved) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));
        TextField tfCode = new TextField(); tfCode.setPromptText("Código");
        TextField tfName = new TextField(); tfName.setPromptText("Nombre");
        TextField tfCategory = new TextField(); tfCategory.setPromptText("Categoría");
        TextField tfPrice = new TextField(); tfPrice.setPromptText("Precio");
        TextField tfStock = new TextField(); tfStock.setPromptText("Stock");
        TextArea taDesc = new TextArea(); taDesc.setPromptText("Descripción");
        Button btnSave = new Button("Guardar");
        box.getChildren().addAll(tfCode, tfName, tfCategory, tfPrice, tfStock, taDesc, btnSave);
        if (p != null) {
            tfCode.setText(p.getCode()); tfName.setText(p.getName()); tfCategory.setText(p.getCategory());
            tfPrice.setText(String.valueOf(p.getPrice())); tfStock.setText(String.valueOf(p.getStock()));
            taDesc.setText(p.getDescription());
        }
        btnSave.setOnAction(e -> {
            try {
                Product prod = (p==null) ? new Product() : p;
                prod.setCode(tfCode.getText().trim()); prod.setName(tfName.getText().trim());
                prod.setCategory(tfCategory.getText().trim());
                prod.setPrice(Double.parseDouble(tfPrice.getText().trim()));
                prod.setStock(Integer.parseInt(tfStock.getText().trim()));
                prod.setDescription(taDesc.getText().trim());
                ProductDAO.save(prod);
                onSaved.run();
                dialog.close();
            } catch (Exception ex) { ex.printStackTrace(); }
        });
        Scene sc = new Scene(box, 400, 450);
        dialog.setScene(sc);
        dialog.setTitle(p==null?"Nuevo Producto":"Editar Producto");
        dialog.showAndWait();
    }
}
