package com.example.practicacorte2.entities.pivots;

import com.example.practicacorte2.entities.Student;
import com.example.practicacorte2.entities.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students_teachers")
@Getter @Setter
public class StudentTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Teacher teacher;
}
