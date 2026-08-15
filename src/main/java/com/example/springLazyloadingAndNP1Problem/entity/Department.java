package com.example.springLazyloadingAndNP1Problem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long dept_id;

    @Column(unique = true)
    private  String name;

    @OneToMany(cascade = CascadeType.REMOVE , mappedBy = "department")
    private List<Student > studentList;


    public Department(Long dept_id, String name, List<Student> studentList) {
        this.dept_id = dept_id;
        this.name = name;
        this.studentList = studentList;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
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
