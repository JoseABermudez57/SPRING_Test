package com.example.practicacorte2.services;

import com.example.practicacorte2.controllers.dtos.responses.StudenResponse;
import com.example.practicacorte2.controllers.dtos.responses.TeacherResponse;
import com.example.practicacorte2.entities.projections.StudentProjection;
import com.example.practicacorte2.entities.projections.TeacherProjection;
import com.example.practicacorte2.repositories.IStudentTeacherRepository;
import com.example.practicacorte2.services.interfaces.IStudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentTeacherServiceImpl implements IStudentTeacherService {

    @Autowired
    private IStudentTeacherRepository repository;

    @Override
    public List<StudenResponse> listAllStudentsByTeacherId(Long teacherId) {
        /* por toda la lista de estudiantes y luego por cada estudiante crea un StudentResponse
           Y posterior a eso, cada response que se crea lo guarda nuevamente en una lista
           En este caso de StudenResponse
         */
        List<StudentProjection> students = repository.listAllStudentsByTeacherId(teacherId);
        return students.stream().map(this::from).collect(Collectors.toList());
    }

    @Override
    public List<TeacherResponse> listAllTeachersByStudentId(Long studentId) {
        List<TeacherProjection> teachers = repository.listAllTeachersByStudentId(studentId);
        return teachers.stream().map(this::from).collect(Collectors.toList());
    }


    private StudenResponse from(StudentProjection student){
        StudenResponse response = new StudenResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        return response;
    }

    private TeacherResponse from(TeacherProjection teacher){
        TeacherResponse response = new TeacherResponse();
        response.setId(teacher.getId());
        response.setName(teacher.getName());
        return response;
    }
}
