package javaguides.springboot.controller;


import javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Nizar",
                "Fazari"
        );

        // return new ResponseEntity<>(student, HttpStatus.OK);
        return  ResponseEntity.ok(student);
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Nizar", "Fazari"));
        students.add(new Student(2,"Iqbar", "Rizqullah"));
        students.add(new Student(3,"Agus", "Surachman"));
        students.add(new Student(4,"Yeni", "Hendrayani"));

        return  ResponseEntity.ok(students);
    }


    //Spring Boot REST API with Path Variable
    @GetMapping("/students/{id}")
    // id -> URL template variable
    // @PathVariable -> method argument to bind it to the value of url template variable like {id}
    public  Student studentPathVariable(@PathVariable("id")  int studentId){
        return new Student(studentId, "Nizar", "Fazari");
    }

    //Spring Boot REST API with Request Param
    // http://localhost:8080/students/query?id=2
    @GetMapping("/students/query")
    public Student studentRequestParams(@RequestParam int  id){
        return new Student(id, "Nizar" , "Fazari");
    }

    //Spring Boot REST API that handle POST
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getFirstName());

        return student;
    }

    //Spring Boot REST API that handle PUT Request - updating existing resource
    @PutMapping("/students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getFirstName());
        return  student;
    }

    //Spring Boot REST API that handle PUT Request - updating existing resource
    @DeleteMapping("/students/{id}/update")
    public String  deleteStudent( @PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student deleted succesfully";
    }
}
