package com.example.org.cafeteria;

public class LoginService {
    private com.example.org.cafeteria.UsuarioDAO dao = new com.example.org.cafeteria.UsuarioDAOImpl();

    public com.example.org.cafeteria.UsuarioDAOImpl login(String username, String password) throws Exception {
        com.example.org.cafeteria.Usuario user = dao.validar(username, password);
        if (user == null)
            throw new Exception("Usuario o contraseña incorrectos");
        return user;
    }
}
