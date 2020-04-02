package com.kgisl.raja.model;

import java.util.List;

public interface StudentDAO {
    public Student getStudent(Integer id);
    public List<Student> getAllStudents();
    public boolean addStudent(Student aStudent);
    public boolean deleteStudent(Integer id);
    public boolean deleteAllStudent();
}