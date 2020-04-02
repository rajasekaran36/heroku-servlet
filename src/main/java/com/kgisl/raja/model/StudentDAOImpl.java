package com.kgisl.raja.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    List<Student> allStudents = new ArrayList<Student>();
    public Student getStudent(Integer id) {
        Student aStudent = null;
        for(Student xStudent:allStudents){
            if(xStudent.getId() == id){
                aStudent = xStudent;
            }
        }
        return aStudent;
    }

    public List<Student> getAllStudents() {
        
        return allStudents;
    }

    public boolean addStudent(Student aStudent) {
        return allStudents.add(aStudent);
    }

    public boolean deleteStudent(Integer id) {
        Student aStudent = null;
        for(Student xStudent:allStudents){
            if(xStudent.getId() == id){
                return allStudents.remove(xStudent);
            }
        }
        
        return false;
    }

    public boolean deleteAllStudent() {
        
        return allStudents.removeAll(allStudents);
    }

}