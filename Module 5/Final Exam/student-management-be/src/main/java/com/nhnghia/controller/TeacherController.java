package com.nhnghia.controller;

import com.nhnghia.entity.Teacher;
import com.nhnghia.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {

    @Autowired
    ITeacherService teacherService;

    @GetMapping("")
    public ResponseEntity<List<Teacher>> getAll() {
        List<Teacher> teacherList = teacherService.findAll();
        if (teacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }
}
