package com.example.springLazyloadingAndNP1Problem.repository;

import com.example.springLazyloadingAndNP1Problem.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;



    //create
    public  void  saveStudent(Student student){
        entityManager.persist(student);
    }

    //get
    public  Student getStudentById(Long id){
        return  entityManager.find(Student.class , id);
    }

    //getAll
    public List<Student> getAllStudent(){
        return entityManager.createQuery("FROM Student" , Student.class).getResultList();
    }


    //delete
    public  void  deleteStudent(Student student){
        entityManager.remove(student);
    }

}
