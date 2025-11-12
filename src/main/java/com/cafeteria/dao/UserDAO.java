package com.cafeteria.dao;

import com.cafeteria.model.User;
import com.cafeteria.util.DBUtil;

import java.sql.*;

public class UserDAO {
    public static User findByUsername(String username) throws SQLException {
        try (Connection c = DBUtil.getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                return u;
            }
        }
        return null;
    }
}
