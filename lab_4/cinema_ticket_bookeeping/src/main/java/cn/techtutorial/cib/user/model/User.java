/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cn.techtutorial.cib.user.model;

import cn.techtutorial.cib.admin.model.Person;

/**
 *
 * @author vy
 */
public class User extends Person{
    private int id;
    private String email;
    private String password;

    public User() {
    }

    public User(int id, String email, String password, String name, String gender, String dob) {
        super(name, gender, dob);
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String name, String gender, String dob) {
        super(name, gender, dob);
        this.email = email;
        this.password = password;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
