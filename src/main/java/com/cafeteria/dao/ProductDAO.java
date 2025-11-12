package com.cafeteria.dao;

import com.cafeteria.model.Product;
import com.cafeteria.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static List<Product> listAll() {
        List<Product> list = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT * FROM products")) {
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id")); p.setCode(rs.getString("code"));
                p.setName(rs.getString("name")); p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price")); p.setStock(rs.getInt("stock"));
                p.setDescription(rs.getString("description"));
                list.add(p);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public static void save(Product p) throws SQLException {
        try (Connection c = DBUtil.getConnection()) {
            if (p.getId() > 0) {
                PreparedStatement ps = c.prepareStatement(
                    "UPDATE products SET code=?,name=?,category=?,price=?,stock=?,description=? WHERE id=?");
                ps.setString(1,p.getCode()); ps.setString(2,p.getName()); ps.setString(3,p.getCategory());
                ps.setDouble(4,p.getPrice()); ps.setInt(5,p.getStock()); ps.setString(6,p.getDescription());
                ps.setInt(7,p.getId());
                ps.executeUpdate();
            } else {
                PreparedStatement ps = c.prepareStatement(
                    "INSERT INTO products(code,name,category,price,stock,description) VALUES(?,?,?,?,?,?)");
                ps.setString(1,p.getCode()); ps.setString(2,p.getName()); ps.setString(3,p.getCategory());
                ps.setDouble(4,p.getPrice()); ps.setInt(5,p.getStock()); ps.setString(6,p.getDescription());
                ps.executeUpdate();
            }
        }
    }

    public static void delete(int id) throws SQLException {
        try (Connection c = DBUtil.getConnection()) {
            PreparedStatement ps = c.prepareStatement("DELETE FROM products WHERE id=?");
            ps.setInt(1,id); ps.executeUpdate();
        }
    }
}
