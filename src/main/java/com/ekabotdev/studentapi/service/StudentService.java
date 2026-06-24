package com.ekabotdev.studentapi.service;


import com.ekabotdev.studentapi.entity.Student;
import com.ekabotdev.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student creatStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElse(null);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
