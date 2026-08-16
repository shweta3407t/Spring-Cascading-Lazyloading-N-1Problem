package com.example.springLazyloadingAndNP1Problem.controller;


import com.example.springLazyloadingAndNP1Problem.entity.Student;
import com.example.springLazyloadingAndNP1Problem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private  StudentService studentService;


    //create Student with existing department
    @PostMapping("/{departmentId}")
    public ResponseEntity<String > createStudent(@RequestBody Student student , @PathVariable Long departmentId ){
        studentService.saveStudent(student , departmentId);
        return ResponseEntity.ok("DONE");
    }


    //create student and department at a time
    @PostMapping
    public  ResponseEntity<String> saveStudentWithDepartment(@RequestBody Student student , @RequestParam String departmentName){
        studentService.saveStudentWithDepartment(student , departmentName);

        return ResponseEntity.ok("DONE");
    }









    //get
    @GetMapping("/{id}")
    public  ResponseEntity<Student> getStudentById(@PathVariable Long id){

         Student student=  studentService.getStudentById(id);

         return  ResponseEntity.ok(student);
    }

//    @GetMapping
//    public  ResponseEntity<List<Student>> getStudentById( ){
//
//        List<Student> student=  studentService.getAllStudent();
//
//        return  ResponseEntity.ok(student);
//    }

    //update
    @PutMapping("/{id}")
    public  ResponseEntity<String> updateStudent(@RequestBody Student student , @PathVariable Long id){

        studentService.updateStudent(student, id) ;

        return  ResponseEntity.ok("DONE");
    }



//delete
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteStudent(@PathVariable Long id ){

          studentService.deleteStudent(id);

        return  ResponseEntity.ok("DONE");
    }



}
