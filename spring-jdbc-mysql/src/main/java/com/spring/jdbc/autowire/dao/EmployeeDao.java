package com.spring.jdbc.autowire.dao;

import com.spring.jdbc.autowire.entities.Employee;
import com.spring.jdbc.entities.Student;

import java.util.List;

public interface EmployeeDao {
    public int insert(Employee student);
    public int change(Employee student);
    public int remove(Employee student);
    public Employee getEmployee(int  studentId);
    public List<Employee> getEmployees();
}
