package com.example.firstapp;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class DataBase_Courses {

    private List<Course> courses = new ArrayList<Course>();

    public DataBase_Courses() {
        courses.add(new Course("Data Science", Arrays.asList("Ch1: Pandas","Ch2: Numpy","Ch3: Data Cleaning","Ch4: Misses Value")));
    }

    public List<Course> getInitialCourses() {
        List<Course> res = new ArrayList<>();
        for(Course c : courses)
                res.add(c);

        return res;
    }

    public String[] getCourses(){
        //assume we are reading data from database
        String[] courseName = {"Data Science"};
        return courseName;

    }
}
