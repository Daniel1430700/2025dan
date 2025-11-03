package com.example.org.cafeteria;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private Rol rol;

    public enum Rol { ADMIN, CAJERO }

    public Usuario() {}

    public Usuario(String username, String password, Rol rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    // Encapsulamiento
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    // Polimorfismo
    public String generarSaludo() {
        return (rol == Rol.ADMIN)
                ? "Bienvenido administrador " + username
                : "Bienvenido cajero " + username;
    }
}
