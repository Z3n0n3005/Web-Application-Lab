/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

/**
 *
 * @author vy
 */
public class Student {
    private int StudentID;
    private String StudentName;

    public Student() {
    }

    public Student(int StudentID, String StudentName) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
    }

    public int getStudentID() {
        return StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    @Override
    public String toString() {
        return "Student{" + "StudentID=" + StudentID + ", StudentName=" + StudentName + '}';
    }
    
   
}
