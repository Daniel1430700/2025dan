package com.example.org.cafeteria;



public interface UsuarioDAO {
    Usuario validar(String username, String password) throws Exception;
}
