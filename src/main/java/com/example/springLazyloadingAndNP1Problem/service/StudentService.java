package com.example.springLazyloadingAndNP1Problem.service;


import com.example.springLazyloadingAndNP1Problem.entity.Department;
import com.example.springLazyloadingAndNP1Problem.entity.Student;
import com.example.springLazyloadingAndNP1Problem.repository.DepartmentRepository;
import com.example.springLazyloadingAndNP1Problem.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

//    //save
//    @Transactional
//    public  void  saveStudent(Student student){
//     studentRepository.saveStudent(student);
//    }

    //save many to one
    @Transactional
    public  void  saveStudent(Student studentRequest , Long dept_id){

        Department department=departmentRepository.getDepartmentById(dept_id);

        studentRequest.setDepartment(department);

        studentRepository.saveStudent(studentRequest);
    }


    //get
    @Transactional
    public   Student   getStudentById(Long id){
        return studentRepository.getStudentById(id);
    }


    @Transactional
    public List<Student> getAllStudent(){
        return  studentRepository.getAllStudent();
    }


    //update
    @Transactional
    public  void  updateStudent(Student studentRequest , Long id){
        Student student=getStudentById(id);

        student.setName(studentRequest.getName());

    }

    //delete
    @Transactional
    public  void   deleteStudent(Long id){
        Student student =studentRepository.getStudentById(id);

        studentRepository.deleteStudent(student);
    }


}
