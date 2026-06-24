package com.ekabotdev.studentapi.controller;

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
    public Student createStudent(@RequestBody Student student) {
        return studentService.creatStudent(student);
    }
    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
