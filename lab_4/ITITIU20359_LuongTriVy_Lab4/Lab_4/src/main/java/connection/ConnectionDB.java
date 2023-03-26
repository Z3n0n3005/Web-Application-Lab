/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vy
 */
public class ConnectionDB {
    public static Connection getCon() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4", "root", "Eudaimonia+3119");
=======
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4", "root", "password");
>>>>>>> 45447baefa6dffbd8e708da9b1ea837656b10418
    }
}
