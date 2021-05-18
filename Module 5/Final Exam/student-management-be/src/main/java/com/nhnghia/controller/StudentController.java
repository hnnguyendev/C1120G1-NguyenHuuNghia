package com.nhnghia.controller;

import com.nhnghia.entity.Student;
import com.nhnghia.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping("")
    public ResponseEntity<Page<Student>> getAll(@PageableDefault(size = 2) Pageable pageable) {
        Page<Student> studentList = studentService.findAll(pageable);
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

//    @GetMapping("")
//    public ResponseEntity<List<Student>> getAll(@RequestParam Optional<String> txtSearch) {
//        List<Student> studentList;
//        if (txtSearch.isPresent()) {
//            studentList = studentService.findByContaining(txtSearch.get());
//        } else {
//            studentList = studentService.findAll();
//        }
//        if (studentList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(studentList, HttpStatus.OK);
//    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getOne(@PathVariable("id") Long id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        studentService.save(student);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> delete(@PathVariable("id") Long id) {
        studentService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
