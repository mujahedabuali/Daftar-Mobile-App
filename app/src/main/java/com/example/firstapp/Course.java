package com.example.firstapp;
import java.util.List;
public class Course {

    private String courseName;
    private List<String> subjects;

    public Course(String courseName, List<String> subjects) {
        this.courseName = courseName;
        this.subjects = subjects;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        String msg = getCourseName() ;
        return msg;
    }

}
