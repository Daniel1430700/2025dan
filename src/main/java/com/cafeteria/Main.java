
package com.cafeteria;

import com.cafeteria.db.DB;
import com.cafeteria.model.Product;
import com.cafeteria.model.Sale;
import com.cafeteria.util.PrinterUtil;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class Main extends Application {
    private Stage primaryStage;
    private DB db;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        db = new DB();
        db.init(); // create tables

        stage.setTitle("Cafeteria POS");
        showLoginScene();
        stage.show();
    }

    private void showLoginScene() {
        Label userLbl = new Label("Usuario:");
        TextField userField = new TextField();
        Label passLbl = new Label("Contraseña:");
        PasswordField passField = new PasswordField();
        Button loginBtn = new Button("Iniciar sesión");

        VBox v = new VBox(8, userLbl, userField, passLbl, passField, loginBtn);
        v.setPadding(new Insets(20));
        v.setAlignment(Pos.CENTER);

        loginBtn.setOnAction(e -> {
            String u = userField.getText().trim();
            String p = passField.getText().trim();
            if (u.equals("admin") && p.equals("admin")) {
                showAdminScene();
            } else if (u.equals("vendedor") && p.equals("vendedor")) {
                showSellerScene();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Credenciales inválidas.\nAdmin: admin/admin\nVendedor: vendedor/vendedor");
                a.showAndWait();
            }
        });

        Scene s = new Scene(v, 350, 250);
        primaryStage.setScene(s);
    }

    // ---------------- Admin scene ----------------
    private void showAdminScene() {
        TableView<Product> table = new TableView<>();
        ObservableList<Product> products = FXCollections.observableArrayList(db.getAllProducts());
        table.setItems(products);

        TableColumn<Product, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        idCol.setPrefWidth(50);

        TableColumn<Product, String> nameCol = new TableColumn<>("Nombre");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(200);

        TableColumn<Product, Double> priceCol = new TableColumn<>("Precio");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setCellFactory(tc -> new TableCell<>() {
            @Override
            protected void updateItem(Double price, boolean empty) {
                super.updateItem(price, empty);
                setText(empty ? null : String.format("%.2f", price));
            }
        });
        priceCol.setPrefWidth(100);

        table.getColumns().addAll(idCol, nameCol, priceCol);

        Button addBtn = new Button("Agregar");
        Button editBtn = new Button("Editar");
        Button delBtn = new Button("Eliminar");
        Button logoutBtn = new Button("Cerrar sesión");

        HBox hb = new HBox(8, addBtn, editBtn, delBtn, logoutBtn);
        hb.setPadding(new Insets(10));

        VBox root = new VBox(10, table, hb);
        root.setPadding(new Insets(10));

        addBtn.setOnAction(e -> {
            Product p = showProductDialog(null);
            if (p != null) {
                db.insertProduct(p.getName(), p.getPrice());
                products.setAll(db.getAllProducts());
            }
        });

        editBtn.setOnAction(e -> {
            Product sel = table.getSelectionModel().getSelectedItem();
            if (sel == null) {
                showInfo("Seleccione un producto para editar.");
                return;
            }
            Product updated = showProductDialog(sel);
            if (updated != null) {
                db.updateProduct(sel.getId(), updated.getName(), updated.getPrice());
                products.setAll(db.getAllProducts());
            }
        });

        delBtn.setOnAction(e -> {
            Product sel = table.getSelectionModel().getSelectedItem();
            if (sel == null) {
                showInfo("Seleccione un producto para eliminar.");
                return;
            }
            Alert c = new Alert(Alert.AlertType.CONFIRMATION, "Eliminar producto " + sel.getName() + " ?");
            Optional<ButtonType> res = c.showAndWait();
            if (res.isPresent() && res.get() == ButtonType.OK) {
                db.deleteProduct(sel.getId());
                products.setAll(db.getAllProducts());
            }
        });

        logoutBtn.setOnAction(e -> showLoginScene());

        Scene sc = new Scene(root, 420, 400);
        primaryStage.setScene(sc);
    }

    private Product showProductDialog(Product existing) {
        Dialog<Product> d = new Dialog<>();
        d.setTitle(existing == null ? "Agregar producto" : "Editar producto");
        Label nameL = new Label("Nombre:");
        TextField nameF = new TextField();
        Label priceL = new Label("Precio:");
        TextField priceF = new TextField();
        if (existing != null) {
            nameF.setText(existing.getName());
            priceF.setText(String.valueOf(existing.getPrice()));
        }
        GridPane gp = new GridPane();
        gp.setVgap(8);
        gp.setHgap(8);
        gp.add(nameL,0,0); gp.add(nameF,1,0);
        gp.add(priceL,0,1); gp.add(priceF,1,1);
        d.getDialogPane().setContent(gp);
        d.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        d.setResultConverter(btn -> {
            if (btn == ButtonType.OK) {
                try {
                    String name = nameF.getText().trim();
                    double price = Double.parseDouble(priceF.getText().trim());
                    return new Product(existing == null ? 0 : existing.getId(), name, price);
                } catch (Exception ex) {
                    showInfo("Precio inválido.");
                    return null;
                }
            }
            return null;
        });
        Optional<Product> res = d.showAndWait();
        return res.orElse(null);
    }

    // ---------------- Seller scene ----------------
    private void showSellerScene() {
        // product combo
        ObservableList<Product> products = FXCollections.observableArrayList(db.getAllProducts());
        ComboBox<Product> cb = new ComboBox<>(products);
        cb.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Product p, boolean empty) {
                super.updateItem(p, empty);
                setText(empty || p == null ? null : p.getName() + " - " + String.format("%.2f", p.getPrice()));
            }
        });
        cb.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Product p, boolean empty) {
                super.updateItem(p, empty);
                setText(empty || p == null ? null : p.getName() + " - " + String.format("%.2f", p.getPrice()));
            }
        });

        TextField qtyF = new TextField("1");
        TextField clientF = new TextField();
        Button sellBtn = new Button("Generar boleta (imprimir)");
        Button reportBtn = new Button("Reporte ventas del día");
        Button logoutBtn = new Button("Cerrar sesión");

        HBox hbTop = new HBox(8, new Label("Producto:"), cb, new Label("Cantidad:"), qtyF);
        hbTop.setAlignment(Pos.CENTER_LEFT);

        HBox hbMid = new HBox(8, new Label("Cliente:"), clientF);
        hbMid.setAlignment(Pos.CENTER_LEFT);
        hbMid.setPadding(new Insets(6,0,6,0));

        VBox root = new VBox(10, hbTop, hbMid, new HBox(8, sellBtn, reportBtn, logoutBtn));
        root.setPadding(new Insets(12));

        sellBtn.setOnAction(e -> {
            Product p = cb.getValue();
            if (p == null) { showInfo("Seleccione un producto."); return; }
            int qty = 1;
            try { qty = Integer.parseInt(qtyF.getText().trim()); if (qty <= 0) throw new Exception(); }
            catch (Exception ex) { showInfo("Cantidad inválida."); return; }
            String client = clientF.getText().trim();
            if (client.isEmpty()) client = "Cliente";
            double total = p.getPrice() * qty;
            // save sale
            db.insertSale(p.getId(), qty, total, client, LocalDate.now().toString());
            // generate receipt text
            String receipt = PrinterUtil.buildReceipt("Cafeteria POS", p.getName(), qty, p.getPrice(), total, client);
            // try to print automatically
            boolean printed = PrinterUtil.printString(receipt);
            if (!printed) {
                showInfo("No se detectó impresora por defecto. La boleta se mostrará en pantalla.");
                // show receipt in dialog
                TextArea ta = new TextArea(receipt);
                ta.setEditable(false);
                ta.setWrapText(true);
                Dialog<Void> rd = new Dialog<>();
                rd.setTitle("Boleta");
                rd.getDialogPane().setContent(ta);
                rd.getDialogPane().getButtonTypes().add(ButtonType.OK);
                rd.showAndWait();
            } else {
                showInfo("Boleta enviada a la impresora por defecto.");
            }
            // clear fields
            qtyF.setText("1");
            clientF.setText("");
        });

        reportBtn.setOnAction(e2 -> {
            double dayTotal = db.getTotalSalesForDate(LocalDate.now().toString());
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Reporte - Ventas del día (" + LocalDate.now().toString() + "):\nTotal vendido: S/ " + String.format("%.2f", dayTotal));
            a.showAndWait();
        });

        logoutBtn.setOnAction(e -> showLoginScene());

        Scene sc = new Scene(root, 600, 200);
        primaryStage.setScene(sc);
    }

    private void showInfo(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
        a.showAndWait();
    }
}
