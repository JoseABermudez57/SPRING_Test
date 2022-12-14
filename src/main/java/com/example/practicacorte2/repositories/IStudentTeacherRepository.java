package com.example.practicacorte2.repositories;

import com.example.practicacorte2.entities.pivots.StudentTeacher;
import com.example.practicacorte2.entities.projections.StudentProjection;
import com.example.practicacorte2.entities.projections.TeacherProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentTeacherRepository extends JpaRepository<StudentTeacher, Long> {
    @Query(value = "select students.* from students_teachers " +
            "inner join students on students_teachers.student_id = students.id " +
            "where students_teachers.teacher_id = :teacherID", nativeQuery = true)
    List<StudentProjection> listAllStudentsByTeacherId(Long teacherID);


    @Query(value = "select teachers.* from students_teachers " +
            "inner join teachers on students_teachers.teacher_id = teachers.id " +
            "where students_teachers.student_id = :studentId", nativeQuery = true)
    List<TeacherProjection> listAllTeachersByStudentId(Long studentId);
}
