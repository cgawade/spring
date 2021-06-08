package com.example.springboot.controller;

import com.example.springboot.entities.Student;
import com.example.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("getAll") // we can use @GetMapping annotation too here
    public Iterable<Student> getStudents(){
        return studentRepository.findAll();
    }

    @RequestMapping("get/{id}")
    public Student getById(@PathVariable int id){
        return studentRepository.findById(id).get();
    }

    @RequestMapping("/delete/{id}")
    public void deletById(@PathVariable int id){
         studentRepository.deleteById(id);
    }


    @RequestMapping("save")
    public Student saveStudent(){
        Student student = new Student();

        student.setStudentId(4);
        student.setStudentName("Smita");
        student.setStudentAddress("Pune");

        return studentRepository.save(student);
    }

    @PostMapping("save/v1/")
    public Student saveStudentV1(@RequestBody Student student){
        return studentRepository.save(student);
    }


    @RequestMapping("update/{id}")
    public void update(@PathVariable int id){
        Optional<Student> studentOp = studentRepository.findById(id);
        Student student = studentOp.get();
        student.setStudentName("raman");
        studentRepository.save(student);

    }

    @GetMapping("bindByName/{name}")
    public List<Student> findByName(@PathVariable String name){
        return studentRepository.findByStudentName(name);
    }

    @GetMapping("bindByNameAndCity/{name}/{city}")
    public List<Student> findByName(@PathVariable String name, @PathVariable String city){
        return studentRepository.findByStudentNameAndStudentAddress(name, city);
    }

    @GetMapping("getAllUsingQuery")
    public List<Student> getAll(){
        return studentRepository.getAllStudent();
    }


    @GetMapping("getByName/{name}")
    public List<Student> getByName(@PathVariable String name){
        return studentRepository.getStudentByName(name);
    }
}
