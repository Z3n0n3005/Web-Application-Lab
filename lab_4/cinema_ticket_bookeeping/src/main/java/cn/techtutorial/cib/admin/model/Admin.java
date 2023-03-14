/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cn.techtutorial.cib.admin.model;

/**
 *
 * @author vy
 */
public class Admin extends Person{
    private int id;
    private String email;
    private String password;
    private String role;

    public Admin() {
    }

    public Admin(int id, String email, String password, String role, String name, String gender, String dob) {
        super(name, gender, dob);
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Admin(String email, String password, String role, String name, String gender, String dob) {
        super(name, gender, dob);
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + '}' + super.toString();
    }

    
    
    
}
