package com.spring.orm.dao;

import com.spring.orm.entities.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public Student getStudent(int id);
    public List<Student> getStudents();
    public void delete(int id);
    public void update(Student student);
}
