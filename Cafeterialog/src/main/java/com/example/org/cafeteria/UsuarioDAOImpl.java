package com.example.org.cafeteria;


import java.sql.*;

public class UsuarioDAOImpl implements UsuarioDAO {
    @Override
    public com.example.org.cafeteria.Usuario validar(String username, String password) throws Exception {
        String sql = "SELECT * FROM usuarios WHERE username=? AND password=?";
        try (Connection conn = com.example.org.cafeteria.DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                com.example.org.cafeteria.Usuario u = new com.example.org.cafeteria.Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRol(com.example.org.cafeteria.Usuario.Rol.valueOf(rs.getString("rol")));
                return u;
            }
        }
        return null;
    }
}
