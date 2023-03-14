/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cn.techtutorial.cib.admin.dao;

import cn.techtutorial.cib.admin.model.Admin;
import cn.techtutorial.cib.admin.services.AdminService;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vy
 */
public class AdminDao implements AdminService{
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public AdminDao(Connection con) {
        this.con = con;
    }
    
    @Override
    public Admin logAdmin(String email, String password){
        Admin admin = null;
        try {
            query = "select * from admin where email = ? and password = ?";
            pst = this.con.prepareStatement(query);
            pst.setString( 1, email);
            pst.setString (2, password);
            rs = pst.executeQuery();
            if(rs.next()){
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setDob(rs.getString("dob"));
                admin.setRole(rs.getString("role"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return admin;
        
    }
}
