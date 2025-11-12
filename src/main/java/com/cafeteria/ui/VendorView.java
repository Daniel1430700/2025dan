package com.cafeteria.ui;

import com.cafeteria.dao.ProductDAO;
import com.cafeteria.dao.VentaDAO;
import com.cafeteria.model.Product;
import com.cafeteria.model.DetalleVenta;
import com.cafeteria.model.Venta;
import com.cafeteria.model.User;
import com.cafeteria.util.PrinterUtil;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.*;

public class VendorView {
    private BorderPane view;
    private User vendedor;
    private TableView<Product> table;
    private ObservableList<DetalleVenta> cart = FXCollections.observableArrayList();

    public VendorView(Stage primary, User vendedor) {
        this.vendedor = vendedor;
        view = new BorderPane();
        table = new TableView<>();
        TableColumn<Product,String> cName = new TableColumn<>("Producto");
        cName.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getName()));
        table.getColumns().add(cName);
        view.setCenter(table);

        Button btnAddToCart = new Button("Agregar al carrito");
        Button btnGen = new Button("Generar Boleta");
        HBox bottom = new HBox(10, btnAddToCart, btnGen);
        bottom.setPadding(new Insets(10));
        view.setBottom(bottom);

        refreshProducts();
        btnAddToCart.setOnAction(e -> {
            Product p = table.getSelectionModel().getSelectedItem();
            if (p != null) {
                TextInputDialog td = new TextInputDialog("1");
                td.setHeaderText("Cantidad");
                Optional<String> res = td.showAndWait();
                res.ifPresent(q -> {
                    try {
                        int qnt = Integer.parseInt(q);
                        DetalleVenta d = new DetalleVenta();
                        d.setProductId(p.getId()); d.setCantidad(qnt); d.setPrecioUnit(p.getPrice());
                        d.setSubtotal(qnt * p.getPrice());
                        cart.add(d);
                        Alert a = new Alert(Alert.AlertType.INFORMATION, "Producto agregado al carrito");
                        a.show();
                    } catch (Exception ex) { ex.printStackTrace(); }
                });
            }
        });

        btnGen.setOnAction(e -> {
            TextInputDialog td = new TextInputDialog("Cliente");
            td.setHeaderText("Nombre del Cliente");
            Optional<String> res = td.showAndWait();
            res.ifPresent(cliente -> {
                try {
                    Venta v = new Venta();
                    v.setCliente(cliente);
                    v.setFecha(LocalDateTime.now());
                    v.setVendedor(vendedor.getUsername());
                    double total = 0.0;
                    List<DetalleVenta> detalles = new ArrayList<>();
                    for (DetalleVenta d : cart) { total += d.getSubtotal(); detalles.add(d); }
                    v.setTotal(total);
                    v.setDetalles(detalles);
                    int id = VentaDAO.saveVenta(v);
                    v.setId(id);
                    // try printing
                    boolean printed = PrinterUtil.imprimirBoletaTexto(v, PrinterUtil.buscarImpresoras().stream().findFirst().orElse(null));
                    if (printed) v.setImpreso(true);
                    Alert a = new Alert(Alert.AlertType.INFORMATION, "Venta registrada. ID=" + id);
                    a.show();
                    cart.clear();
                } catch (Exception ex) { ex.printStackTrace(); new Alert(Alert.AlertType.ERROR, "Error al guardar venta").show(); }
            });
        });
    }

    private void refreshProducts() {
        List<Product> list = ProductDAO.listAll();
        ObservableList<Product> obs = FXCollections.observableArrayList(list);
        table.setItems(obs);
    }

    public Parent getView() { return view; }
}
