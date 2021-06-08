package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String insertQuery = "insert into student(id, name, address) values(?,?,?)";
        return jdbcTemplate.update(insertQuery, student.getId(), student.getName(), student.getAddress());
    }

    @Override
    public int change(Student student) {
        String updateQuery = "update student set name=?, address=? where id = ?";
        return jdbcTemplate.update(updateQuery,student.getName(), student.getAddress(), student.getId());
    }

    @Override
    public int remove(Student student) {
        String deleteQuery="delete from student where id=?";
        return jdbcTemplate.update(deleteQuery, student.getId());
    }

    @Override
    public Student getStudent(int studentId) {
        String selectQuery="select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        return jdbcTemplate.queryForObject(selectQuery, rowMapper, studentId);
    }

    @Override
    public List<Student> getStudents() {
        String selectQuery = "select * from student";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> result = jdbcTemplate.query(selectQuery, rowMapper);
        return result;
    }
}

