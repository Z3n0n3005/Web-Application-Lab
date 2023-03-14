/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cn.techtutorial.cib.admin.services;

import cn.techtutorial.cib.admin.model.Admin;

/**
 *
 * @author vy
 */
public interface AdminService {
    public Admin logAdmin(String email, String password);
}
