package com.example.practicacorte2.services.interfaces;

import com.example.practicacorte2.controllers.dtos.responses.StudenResponse;
import com.example.practicacorte2.controllers.dtos.responses.TeacherResponse;

import java.util.List;

public interface IStudentTeacherService {

    List<StudenResponse> listAllStudentsByTeacherId (Long teacherId);

    List<TeacherResponse>listAllTeachersByStudentId(Long studentId);

}

