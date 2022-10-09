package com.example.practicacorte2.controllers;

import com.example.practicacorte2.controllers.dtos.responses.BaseResponse;
import com.example.practicacorte2.controllers.dtos.responses.StudenResponse;
import com.example.practicacorte2.controllers.dtos.responses.TeacherResponse;
import com.example.practicacorte2.services.interfaces.IStudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student-teacher")
public class StudenTeacherController {

    @Autowired
    private IStudentTeacherService service;

    // Tiene que se intuitivo
    @GetMapping("students/teacher/{teacherId}")
    public ResponseEntity<BaseResponse> listAllStudentsByTeacherId(@PathVariable Long teacherId){
        BaseResponse baseResponse = service.listAllStudentsByTeacherId(teacherId);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttStatus());
    }

    @GetMapping("teachers/student/{studentId}")
    public List<TeacherResponse> listAllTeachersByStudentId(@PathVariable Long studentId){
        return service.listAllTeachersByStudentId(studentId);
    }

}
