package com.ekabotdev.studentapi.service;


import com.ekabotdev.studentapi.customexception.EmailAlreadyExistsException;
import com.ekabotdev.studentapi.customexception.StudentNotFoundException;
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
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(
                        "Student with id " + id + " not found"));
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
