package com.cafeteria.util;

import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.util.stream.Collectors;

public class DBUtil {
    private static final String DB_DIR = "database";
    private static final String DB_FILE = DB_DIR + "/cafeteria.db";
    private static final String INIT_SQL = "database/init.sql";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + DB_FILE;
        return DriverManager.getConnection(url);
    }

    public static void initDatabase() {
        try {
            Files.createDirectories(Paths.get(DB_DIR));
            File db = new File(DB_FILE);
            boolean exists = db.exists();
            if (!exists) {
                System.out.println("[DB] creando base de datos...");
            }
            // Ensure tables exist by executing init.sql
            try (Connection conn = getConnection()) {
                String sql = new String(Files.readAllBytes(Paths.get(INIT_SQL)));
                Statement st = conn.createStatement();
                st.executeUpdate("PRAGMA foreign_keys = ON;");
                for (String stmt : sql.split(";")) {
                    if (stmt.trim().isEmpty()) continue;
                    st.execute(stmt);
                }
                // Insert default users and sample products if not present
                PreparedStatement psUser = conn.prepareStatement(
                    "INSERT OR IGNORE INTO users(username,password,role) VALUES(?,?,?)");
                psUser.setString(1, "admin"); psUser.setString(2, "admin123"); psUser.setString(3, "ADMIN"); psUser.executeUpdate();
                psUser.setString(1, "vendedor"); psUser.setString(2, "vendedor123"); psUser.setString(3, "VENDEDOR"); psUser.executeUpdate();

                PreparedStatement psProd = conn.prepareStatement(
                    "INSERT OR IGNORE INTO products(code,name,category,price,stock,description) VALUES(?,?,?,?,?,?)");
                String[][] productos = {
                    {"C001","Café Americano","Bebida","1.50","100","Café negro"},
                    {"C002","Latte","Bebida","2.50","80","Con leche"},
                    {"C003","Capuccino","Bebida","2.75","60","Espumoso"},
                    {"P001","Croissant","Snack","1.20","50","Fresco"},
                    {"P002","Sándwich","Comida","3.00","40","Jamón y queso"},
                    {"P003","Muffin","Snack","1.00","70","Vainilla"}
                };
                for (String[] p : productos) {
                    psProd.setString(1, p[0]);
                    psProd.setString(2, p[1]);
                    psProd.setString(3, p[2]);
                    psProd.setDouble(4, Double.parseDouble(p[3]));
                    psProd.setInt(5, Integer.parseInt(p[4]));
                    psProd.setString(6, p[5]);
                    psProd.executeUpdate();
                }
                System.out.println("[DB] inicialización completada.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            try (PrintWriter pw = new PrintWriter(new FileWriter("logs/app.log", true))) {
                pw.println(java.time.LocalDateTime.now() + " - DB init error: " + ex.getMessage());
            } catch (Exception e) {}
        }
    }
}
