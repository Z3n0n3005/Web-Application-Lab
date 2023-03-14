/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentcourse;

import course.Course;
import course.CourseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import student.Student;

/**
 *
 * @author vy
 */
public class StudentCourseDao implements StudentCourseServices{
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public StudentCourseDao(Connection con) {
        this.con = con;
    }

    @Override
    public List<Student> listAllStudent(Integer CourseID) {
        List<Student> listAllStudent = new ArrayList<>();
        try {
            Student student = null;
            query = "select s.StudentID, s.StudentName from studentcourse sc join course c on sc.CourseID = c.CourseID join student s on sc.StudentID = s.StudentID where sc.CourseID = ?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, CourseID);
            rs = pst.executeQuery();
            while(rs.next()){
                student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
                student.setStudentName(rs.getString("StudentName"));
                listAllStudent.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAllStudent;
    }

    @Override
    public List<Course> listAllCourse(Integer StudentID) {
        List<Course> listAllCourse = new ArrayList<>();
        try {
            Course course = null;
            query = "select c.CourseID, c.CourseName from studentcourse sc join course c on sc.CourseID = c.CourseID join student s on sc.StudentID = s.StudentID where sc.StudentID = ?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, StudentID);
            rs = pst.executeQuery();
            while(rs.next()){
                course = new Course();
                course.setCourseID(rs.getInt("CourseID"));
                course.setCourseName(rs.getString("CourseName"));
                listAllCourse.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAllCourse;
    }

    @Override
    public void addStudentCourse(Integer StudentID, Integer CourseID) {
        try {
            query = "insert into studentcourse (StudentID, CourseID) values (?, ?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, StudentID);
            pst.setInt(2, CourseID);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeStudentCourse(Integer StudentID, Integer CourseID) {
        try {
            query = "delete from studentcourse where StudentID = ? and CourseID = ?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, StudentID);
            pst.setInt(2, CourseID);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    
}
