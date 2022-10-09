package com.example.practicacorte2.services;

import com.example.practicacorte2.controllers.dtos.responses.BaseResponse;
import com.example.practicacorte2.controllers.dtos.responses.StudenResponse;
import com.example.practicacorte2.controllers.dtos.responses.TeacherResponse;
import com.example.practicacorte2.entities.projections.StudentProjection;
import com.example.practicacorte2.entities.projections.TeacherProjection;
import com.example.practicacorte2.repositories.IStudentTeacherRepository;
import com.example.practicacorte2.services.interfaces.IStudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentTeacherServiceImpl implements IStudentTeacherService {

    @Autowired
    private IStudentTeacherRepository repository;

    @Override
    public BaseResponse listAllStudentsByTeacherId(Long teacherId) {
        /* por toda la lista de estudiantes y luego por cada estudiante crea un StudentResponse
           Y posterior a eso, cada response que se crea lo guarda nuevamente en una lista
           En este caso de StudenResponse
         */
        List<StudentProjection> students = repository.listAllStudentsByTeacherId(teacherId);

        List<StudenResponse> response = students.stream()
                .map(this::from)
                .collect(Collectors.toList());
        return BaseResponse.builder()
                .data(response) // En response se encuentra la lista de respuesta de los datos encontrados
                .message("Student list by teacher id")
                .success(Boolean.TRUE)
                .httStatus(HttpStatus.OK).build();
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
