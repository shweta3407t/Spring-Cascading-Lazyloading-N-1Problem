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
public class DepartmentService {
    @Autowired
   private  DepartmentRepository departmentRepository;

    @Autowired
    private  StudentRepository studentRepository;


    @Transactional
    public  void  saveDepartment(Department department){
        Student student1=new Student();
        student1.setName("shweta");
        student1.setDepartment(department);


        department.getStudentList().add(student1);


        departmentRepository.saveDepartment(department);
//        studentRepository.saveStudent(student1);
    }

    @Transactional
    public  Department getDepartmentById(Long id){
        return  departmentRepository.getDepartmentById(id);
    }


    @Transactional
    public  List<Department> getAllDepartment(){
        return departmentRepository.getAllDepartment();
    }


    @Transactional
    public  void  updateDepartment(Department departmentRequest ,Long id){
        departmentRepository.getDepartmentById(id);

        Department department= getDepartmentById(id);

        department.setName(departmentRequest.getName());
        department.setStudentList(departmentRequest.getStudentList());



    }


    @Transactional
    public  void  deleteDepartment(Long id){
        Department department=departmentRepository.getDepartmentById(id);

        departmentRepository.deleteDepartment(department);
    }








}
