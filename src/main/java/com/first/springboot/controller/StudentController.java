package com.first.springboot.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.first.springboot.bean.Student;

@RestController
public class StudentController {

    //normal way 
    // http://localhost:8080/student
    // @GetMapping("/student")
    // public Student getStudent(){
    //     Student student = new Student(1, "Anurag", "Kumar");
    //     return student;
    // }

    // by ResponseEntity-- same thing
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Anurag","Kumar");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "Anurag").body(student);
    }

    // http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Aurag","kumar"));
        students.add(new Student(2,"Sanya","Doda"));
        students.add(new Student(3,"Sunli","Kumar"));
        students.add(new Student(4,"Pratima","Singh"));
        return students;
    }


    // Spring boot rest Api wiht PathVariable
    // {id} - URI template variable
    // http://localhost:8080/student/1
    @GetMapping("/student/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId, "Ramesh","Kumar");
    }


    // SpringBoot rest Api with RequestParam
    // http://localhost:8080/students/query?id=1
    @GetMapping("/students/query")
    public Student studentQueryParam(@RequestParam int id){
        return new Student(id, "Anurag", "Roxx");
    }


    // method to handle POST request
    // usage - @PostMapping and @RequestBody
    // http://localhost:8080/students/create
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


    // method to handle update the existing resourse
    //usage - @PutMapping, @RequestBody 
    // http://localhost:8080/students/1/update
    @PutMapping("/students/{id}/update") 
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // method to handle delete request in spring boot
    // usage - @DeleteMapping, @PathVariable
    // http://localhost:8080/students/1/delete
    @DeleteMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "deleted student";
    }
}
