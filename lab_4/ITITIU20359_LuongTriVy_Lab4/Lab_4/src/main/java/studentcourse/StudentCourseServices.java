/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentcourse;

import course.Course;
import java.util.List;
import student.Student;

/**
 *
 * @author vy
 */
public interface StudentCourseServices {
    public List<Student> listAllStudent(Integer CourseID);
    public List<Course> listAllCourse(Integer StudentID);
    public void addStudentCourse(Integer StudentID, Integer CourseID);
    public void removeStudentCourse(Integer StudentID, Integer CourseID);
}
