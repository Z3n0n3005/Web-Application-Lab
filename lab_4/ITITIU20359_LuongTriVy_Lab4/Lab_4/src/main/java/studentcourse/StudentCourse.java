/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentcourse;

/**
 *
 * @author vy
 */
public class StudentCourse {
    private int StudentID;
    private int CourseID;

    public StudentCourse() {
    }

    public StudentCourse(int StudentID, int CourseID) {
        this.StudentID = StudentID;
        this.CourseID = CourseID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    @Override
    public String toString() {
        return "StudentCourse{" + "StudentID=" + StudentID + ", CourseID=" + CourseID + '}';
    }
    
    
}
