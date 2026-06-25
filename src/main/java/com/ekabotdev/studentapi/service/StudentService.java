package com.ekabotdev.studentapi.service;


import com.ekabotdev.studentapi.customexception.EmailAlreadyExistsException;
import com.ekabotdev.studentapi.customexception.StudentNotFoundException;
import com.ekabotdev.studentapi.dto.CreateStudentRequest;
import com.ekabotdev.studentapi.dto.StudentResponse;
import com.ekabotdev.studentapi.entity.Student;
import com.ekabotdev.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public StudentResponse createStudent(CreateStudentRequest request) {
        if (studentRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        Student student = new Student();
        student.setEmail(request.getEmail());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());

        Student savedStudent = studentRepository.save(student);
        return mapToStudentResponse(savedStudent);
    }
    public List<StudentResponse> getAllStudents() {

        List<Student> students = studentRepository.findAll();
        List<StudentResponse> responses = new ArrayList<>();
        for (Student student : students) {
           responses.add(mapToStudentResponse(student));
        }
        return responses;
    }
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id " + id + " not found"));

         return mapToStudentResponse(student);

    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    private StudentResponse mapToStudentResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());

        return studentResponse;
    }
}
