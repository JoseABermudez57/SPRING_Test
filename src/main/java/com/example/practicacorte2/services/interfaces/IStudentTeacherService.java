package com.example.practicacorte2.services.interfaces;

import com.example.practicacorte2.controllers.dtos.responses.BaseResponse;
import com.example.practicacorte2.controllers.dtos.responses.StudenResponse;
import com.example.practicacorte2.controllers.dtos.responses.TeacherResponse;

import java.util.List;

public interface IStudentTeacherService {

    BaseResponse listAllStudentsByTeacherId (Long teacherId);

    List<TeacherResponse>listAllTeachersByStudentId(Long studentId);

}

