/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course;

import java.util.List;

/**
 *
 * @author vy
 */
public interface CourseServices {
    public List<Course> listAllCourse();
    public void addCourse(String CourseName);
    public void editCourse(Integer CourseID, String newCourseName);
    public void deleteCourse(Integer CourseID);
    public int findCourseID(String CourseName);
}
