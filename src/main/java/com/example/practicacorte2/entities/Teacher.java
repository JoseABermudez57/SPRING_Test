package com.example.practicacorte2.entities;

import com.example.practicacorte2.entities.pivots.StudentTeacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
@Getter @Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    // El mappedby hace referencia a la variable en la entidad StudentTeacher
    @OneToMany(mappedBy = "teacher")
    private List<StudentTeacher> studentTeachers;

}
