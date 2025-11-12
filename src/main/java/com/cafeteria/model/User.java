package com.cafeteria.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String role; // ADMIN or VENDEDOR

    public User() {}
    public User(int id, String username, String password, String role) {
        this.id = id; this.username = username; this.password = password; this.role = role;
    }
    // getters and setters
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getUsername(){return username;} public void setUsername(String s){this.username=s;}
    public String getPassword(){return password;} public void setPassword(String p){this.password=p;}
    public String getRole(){return role;} public void setRole(String r){this.role=r;}
}
