package com.ekabotdev.studentapi.controller;

import com.ekabotdev.studentapi.dto.CreateStudentRequest;
import com.ekabotdev.studentapi.dto.StudentResponse;
import com.ekabotdev.studentapi.entity.Student;
import com.ekabotdev.studentapi.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public StudentResponse createStudent(@RequestBody CreateStudentRequest request) {
        return studentService.createStudent(request);
    }
    @GetMapping
    public List<StudentResponse> findAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public StudentResponse findStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
