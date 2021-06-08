package com.example.springboot.repository;

import com.example.springboot.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    public List<Student> findByStudentName(String name);
    public List<Student> findByStudentNameAndStudentAddress(String name, String address);

    @Query("select s from Student s")
    public List<Student> getAllStudent();

    @Query("select s from Student s where s.studentName =:n")
    public List<Student> getStudentByName(@Param("n") String name);

    //Native Query
    @Query(value = "select * from student", nativeQuery = true)
    public List<Student> getStudentByNQuery();
}
