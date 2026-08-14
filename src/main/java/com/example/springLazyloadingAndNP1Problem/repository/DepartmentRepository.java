package com.example.springLazyloadingAndNP1Problem.repository;

import com.example.springLazyloadingAndNP1Problem.entity.Department;
import com.example.springLazyloadingAndNP1Problem.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;




    //create
    public  void  saveDepartment(Department department){




        entityManager.persist(department);
    }

    //get
    public  Department  getDepartmentById(Long id){
        return  entityManager.find(Department.class , id);
    }

    //getAll
    public List<Department> getAllDepartment(){
        return entityManager.createQuery("FROM Department" , Department.class).getResultList();
    }


    //delete
    public  void  deleteDepartment( Department department){
        entityManager.remove(department);
    }

}
