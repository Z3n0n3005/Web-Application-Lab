/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vy
 */
public class CourseDao implements CourseServices{
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public CourseDao(Connection con) {
        this.con = con;
    }
    
    @Override
    public List<Course> listAllCourse(){
        List<Course> listAllCourse = new ArrayList<>();
        try {
            Course course = null;
            query = "select * from course";
            pst = this.con.prepareStatement(query);
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
    public void addCourse(String CourseName) {
        try {
            query = "insert into course (CourseName) values (?)";
            pst = this.con.prepareStatement(query);
            pst.setString( 1, CourseName);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editCourse(Integer CourseID, String newCourseName) {
        try {
            query = "update course set CourseName = ? where CourseID = ?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, newCourseName);
            pst.setInt( 2, CourseID);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteCourse(Integer CourseID) {
        try {
            query = "delete from course where CourseID = ?";
            pst = this.con.prepareStatement(query);
            pst.setInt( 1, CourseID);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int findCourseID(String CourseName) {
        Integer CourseID = null;
        try {
            
            query = "select CourseID from course where CourseName = ?";
            pst = this.con.prepareStatement(query);
            pst.setString(1,CourseName);
            rs = pst.executeQuery();
            if(rs.next()){
                CourseID = rs.getInt("CourseID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CourseID;
    }
    
}
