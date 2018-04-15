/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTableGA;

/**
 *
 * @author Jay
 */
public class Course {
    private final int courseID;
    private final String courseCode;
    private final String courseName;
    private final int professorIDs[];
    
    public Course(int courseID,String courseCode,String courseName,int professorIDs[]){
    this.courseCode = courseCode;
    this.courseID = courseID;
    this.courseName =courseName;
    this.professorIDs = professorIDs;
    }
    public int getRandomProfessorId(){
        int professorId = professorIDs[(int) (professorIDs.length * Math.random())];
        return professorId;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
    
    
    
    
    
}
