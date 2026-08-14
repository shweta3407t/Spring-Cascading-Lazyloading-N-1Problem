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
    private DepartmentRepository departmentRepository;

    @Autowired
    private  StudentRepository studentRepository;




//    //save
//    @Transactional
//    public  void  saveStudent (Department department ){
//        departmentRepository.saveDepartment(department);
//    }

    //save for one to many
    @Transactional
    public  void  saveStudent (Department departmentRequest , String studentName ){

       Student student=new Student();

        student.setName(studentName );

        departmentRequest.getStudentList().add(student);

        departmentRepository.saveDepartment(departmentRequest );
    }


    //get
    @Transactional
    public   Department   getDepartmentById(Long id){
        return departmentRepository.getDepartmentById(id);
    }


    @Transactional
    public List<Department> getAllDepartment(){
        return  departmentRepository.getAllDepartment();
    }


    //update
    @Transactional
    public  void  updateDepartment(Department departmentRequest , Long id){
        Department department=getDepartmentById(id);

        department.setName(departmentRequest.getName());


    }

    //delete
    @Transactional
    public  void   deleteDepartment(Long id){
        Department  department =departmentRepository.getDepartmentById(id);

        departmentRepository.deleteDepartment(department);
    }
}
