package com.ekabotdev.studentapi.service;


import com.ekabotdev.studentapi.customexception.EmailAlreadyExistsException;
import com.ekabotdev.studentapi.customexception.StudentNotFoundException;
import com.ekabotdev.studentapi.dto.CreateStudentRequest;
import com.ekabotdev.studentapi.dto.StudentResponse;
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
    public StudentResponse creatStudent(CreateStudentRequest request) {
        if (studentRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        Student student = new Student();
        student.setEmail(request.getEmail());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());

        Student savedStudent = studentRepository.save(student);
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(savedStudent.getId());
        studentResponse.setEmail(savedStudent.getEmail());
        studentResponse.setFirstName(savedStudent.getFirstName());
        studentResponse.setLastName(savedStudent.getLastName());
        return studentResponse;
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
