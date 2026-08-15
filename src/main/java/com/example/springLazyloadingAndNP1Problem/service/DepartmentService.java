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
    public  void  saveDepartment (Department departmentRequest , String studentName ){

       Student student=new Student();
       student.setName(studentName );
       student.setDepartment(departmentRequest);



       Student student1=new Student();
       student1.setName("ppppp");
       student1.setDepartment(departmentRequest);

        Student student2=new Student();
        student2.setName("rrr");
        student2.setDepartment(departmentRequest);


//
//       List<Student > studentList = departmentRequest.getStudentList();
//        studentList.add(student );
//        studentList.add(student1);
//        studentList.add(student2);



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
