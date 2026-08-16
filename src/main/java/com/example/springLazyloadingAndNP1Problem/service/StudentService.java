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
     private  StudentRepository studentRepository;


    @Autowired
    private  DepartmentRepository departmentRepository;






    @Transactional
    public  void  saveStudent(Student student , Long deptId ){
        Department department=departmentRepository.getDepartmentById(deptId);


        student.setDepartment(department);
        department.getStudentList().add(student);


        studentRepository.saveStudent(student);
    }


    @Transactional
    public  void  saveStudentWithDepartment(Student student ,String departmentName  ){//with

        Department department=new Department();
        department.setName(departmentName);
        department.getStudentList().add(student);
        departmentRepository.saveDepartment(department);



        student.setDepartment(department);

        studentRepository.saveStudent(student);

    }



    @Transactional
    public  void  deleteStudent(Long id){
        Student student=studentRepository.getStudentById(id);

        studentRepository.deleteStudent(student);
    }



    @Transactional
    public  Student getStudentById(Long id){
        return  studentRepository.getStudentById(id);
    }


    @Transactional
    public  List<Student> studentList(){
        return  studentRepository.getAllStudent();
    }


    @Transactional
    public void  updateStudent(Student studentRequest , Long id){
        Student student =studentRepository.getStudentById(id);

         student.setName(studentRequest.getName());
         student.setDepartment(studentRequest.getDepartment());

    }



}
