package com.cafeteria.ui;

import com.cafeteria.dao.ProductDAO;
import com.cafeteria.model.Product;
import com.cafeteria.model.User;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class AdminView {
    private BorderPane view;
    private User admin;

    public AdminView(Stage primary, User admin) {
        this.admin = admin;
        view = new BorderPane();
        TableView<Product> table = new TableView<>();
        TableColumn<Product,Integer> cId = new TableColumn<>("ID");
        TableColumn<Product,String> cName = new TableColumn<>("Nombre");
        cId.setCellValueFactory(d -> new javafx.beans.property.SimpleObjectProperty<>(d.getValue().getId()));
        cName.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getName()));
        table.getColumns().addAll(cId, cName);
        Button btnNew = new Button("Nuevo Producto");
        Button btnEdit = new Button("Editar");
        Button btnDel = new Button("Eliminar");
        HBox actions = new HBox(10, btnNew, btnEdit, btnDel);
        actions.setPadding(new Insets(10));
        view.setTop(actions);
        view.setCenter(table);

        refresh(table);
        btnNew.setOnAction(e -> {
            ProductForm.showForm(null, () -> refresh(table));
        });
        btnEdit.setOnAction(e -> {
            Product p = table.getSelectionModel().getSelectedItem();
            if (p != null) ProductForm.showForm(p, () -> refresh(table));
        });
        btnDel.setOnAction(e -> {
            Product p = table.getSelectionModel().getSelectedItem();
            if (p != null) {
                try {
                    ProductDAO.delete(p.getId());
                    refresh(table);
                } catch (Exception ex) { ex.printStackTrace(); }
            }
        });
    }

    private void refresh(TableView<Product> table) {
        List<Product> list = ProductDAO.listAll();
        ObservableList<Product> obs = FXCollections.observableArrayList(list);
        table.setItems(obs);
    }

    public Parent getView() { return view; }
}
