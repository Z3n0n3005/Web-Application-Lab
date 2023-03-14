/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.util.List;

/**
 *
 * @author vy
 */
public interface StudentServices {
    public List<Student> listAllStudent();
    public void addStudent(String StudentName);
    public void editStudent(Integer StudentID, String newStudentName);
    public void deleteStudent(Integer StudentID);
    public String findStudentName(Integer StudentID);
}
