package com.example.springLazyloadingAndNP1Problem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;


    @OneToMany(mappedBy = "department" , cascade = CascadeType.ALL)
    private  List<Student> studentList = new ArrayList<>();




    public  Department(){}
    public Department(  String name, List<Student> studentList) {

        this.name = name;
        this.studentList = studentList  != null ? studentList : new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
