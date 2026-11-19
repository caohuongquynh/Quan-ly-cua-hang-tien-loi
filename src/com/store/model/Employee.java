package com.store.model;

public class Employee {
    private int id;
    private String username;
    private String password;
    private String role;      // ADMIN hoặc STAFF
    private String fullName;

    public Employee() {}
    public Employee(int id, String username, String password, String role, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getFullName() { return fullName; }
}