package com.Dao.model;

public class Employee {
    private String username;
    private String email;
    private int id;

    public Employee(){
    }

    public Employee(String username,String email){
        this.username=username;
        this.email = email;
    }
    
    public Employee(String username, String email, int id) {
        this.username = username;
        this.email = email;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
