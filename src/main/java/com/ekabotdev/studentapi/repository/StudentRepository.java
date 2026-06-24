package com.ekabotdev.studentapi.repository;

import com.ekabotdev.studentapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
