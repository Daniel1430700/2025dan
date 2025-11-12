
package com.cafeteria.db;

import com.cafeteria.model.Product;
import com.cafeteria.model.Sale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    private static final String DB_FILE = "cafeteria.db";
    private Connection conn;

    public void init() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE);
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, price REAL NOT NULL);");
            st.execute("CREATE TABLE IF NOT EXISTS sales (id INTEGER PRIMARY KEY AUTOINCREMENT, product_id INTEGER, qty INTEGER, total REAL, client TEXT, date TEXT);");
            // insert sample products if empty
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS c FROM products;");
            if (rs.next() && rs.getInt("c") == 0) {
                PreparedStatement p = conn.prepareStatement("INSERT INTO products(name,price) VALUES(?,?)");
                p.setString(1, "Café Americano"); p.setDouble(2, 4.50); p.execute();
                p.setString(1, "Café con Leche"); p.setDouble(2, 6.00); p.execute();
                p.setString(1, "Capuccino"); p.setDouble(2, 8.00); p.execute();
                p.close();
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Products
    public List<Product> getAllProducts() {
        List<Product> out = new ArrayList<>();
        try {
            PreparedStatement p = conn.prepareStatement("SELECT id,name,price FROM products ORDER BY id");
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                out.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
            rs.close(); p.close();
        } catch (Exception e) { e.printStackTrace(); }
        return out;
    }

    public void insertProduct(String name, double price) {
        try {
            PreparedStatement p = conn.prepareStatement("INSERT INTO products(name,price) VALUES(?,?)");
            p.setString(1, name); p.setDouble(2, price); p.execute();
            p.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void updateProduct(int id, String name, double price) {
        try {
            PreparedStatement p = conn.prepareStatement("UPDATE products SET name=?, price=? WHERE id=?");
            p.setString(1, name); p.setDouble(2, price); p.setInt(3, id); p.execute();
            p.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void deleteProduct(int id) {
        try {
            PreparedStatement p = conn.prepareStatement("DELETE FROM products WHERE id=?");
            p.setInt(1, id); p.execute();
            p.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // Sales
    public void insertSale(int productId, int qty, double total, String client, String date) {
        try {
            PreparedStatement p = conn.prepareStatement("INSERT INTO sales(product_id,qty,total,client,date) VALUES(?,?,?,?,?)");
            p.setInt(1, productId); p.setInt(2, qty); p.setDouble(3, total); p.setString(4, client); p.setString(5, date); p.execute();
            p.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public double getTotalSalesForDate(String date) {
        double total = 0.0;
        try {
            PreparedStatement p = conn.prepareStatement("SELECT SUM(total) AS s FROM sales WHERE date = ?");
            p.setString(1, date);
            ResultSet rs = p.executeQuery();
            if (rs.next()) total = rs.getDouble("s");
            rs.close(); p.close();
        } catch (Exception e) { e.printStackTrace(); }
        return total;
    }
}
