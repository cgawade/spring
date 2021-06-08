package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public Student getStudent(int id) {
        return hibernateTemplate.get(Student.class, id);
    }

    @Override
    public List<Student> getStudents() {
        return hibernateTemplate.loadAll(Student.class);
    }

    @Override
    public void update(Student student) {
        hibernateTemplate.update(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = hibernateTemplate.get(Student.class, id);
        hibernateTemplate.delete(student);
    }

    @Override
    @Transactional
    public int insert(Student student) {
        return (int)hibernateTemplate.save(student);
    }
}
