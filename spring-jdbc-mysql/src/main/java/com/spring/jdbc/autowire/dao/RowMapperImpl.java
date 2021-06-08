package com.spring.jdbc.autowire.dao;

import com.spring.jdbc.autowire.entities.Employee;
import com.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();

        employee.setId(rs.getInt(1));
        employee.setName(rs.getString(2));
        employee.setAddress(rs.getString(3));

        return employee;
    }

}
