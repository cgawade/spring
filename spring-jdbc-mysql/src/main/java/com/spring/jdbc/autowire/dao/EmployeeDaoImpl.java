package com.spring.jdbc.autowire.dao;

import com.spring.jdbc.autowire.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Employee employee) {
        String insertQuery = "insert into student(id, name, address) values(?,?,?)";
        return jdbcTemplate.update(insertQuery, employee.getId(), employee.getName(), employee.getAddress());
    }

    @Override
    public int change(Employee employee) {
        String updateQuery = "update student set name=?, address=? where id = ?";
        return jdbcTemplate.update(updateQuery, employee.getName(), employee.getAddress(), employee.getId());
    }

    @Override
    public int remove(Employee employee) {
        String deleteQuery="delete from student where id=?";
        return jdbcTemplate.update(deleteQuery, employee.getId());
    }

    @Override
    public Employee getEmployee(int studentId) {
        String selectQuery="select * from student where id=?";
        RowMapper<Employee> rowMapper = new RowMapperImpl();
        return jdbcTemplate.queryForObject(selectQuery, rowMapper, studentId);
    }

    @Override
    public List<Employee> getEmployees() {
        String selectQuery = "select * from student";
        RowMapper<Employee> rowMapper = new RowMapperImpl();
        List<Employee> result = jdbcTemplate.query(selectQuery, rowMapper);
        return result;
    }
}

