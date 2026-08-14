package com.example.springLazyloadingAndNP1Problem.controller;

import com.example.springLazyloadingAndNP1Problem.entity.Department;
import com.example.springLazyloadingAndNP1Problem.entity.Student;
import com.example.springLazyloadingAndNP1Problem.service.DepartmentService;
import com.example.springLazyloadingAndNP1Problem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    //save
//    @PostMapping
//    public ResponseEntity<String> saveDepartment(@RequestBody Department department){
//        departmentService.saveStudent(department);
//
//        return  ResponseEntity.ok("DONE");
//    }


    //save
    @PostMapping
    public ResponseEntity<String> saveDepartment(@RequestBody Department department , @RequestParam String studentName){
        departmentService.saveStudent(department ,   studentName);

        return  ResponseEntity.ok("DONE");
    }

    //get
    @GetMapping("/{id}")
    public  ResponseEntity<Department> getStudentById(@PathVariable Long id){

        Department department= departmentService.getDepartmentById(id);

        return  ResponseEntity.ok(department);
    }

    @GetMapping
    public  ResponseEntity<List<Department>> getAllDepartment( ){

        List<Department> departments=  departmentService.getAllDepartment();

        return  ResponseEntity.ok(departments);
    }

    //update
    @PutMapping("/{id}")
    public  ResponseEntity<String> updateStudent(@RequestBody Department  department , @PathVariable Long id){

        departmentService.updateDepartment(department, id); ;

        return  ResponseEntity.ok("DONE");
    }



    //delete
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteStudent(@PathVariable Long id ){

        departmentService.deleteDepartment(id);

        return  ResponseEntity.ok("DONE");
    }

}
