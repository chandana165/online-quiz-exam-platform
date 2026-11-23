package com.quizplatform.repository;
import com.quizplatform.entity.StudentProfile; import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentProfileRepository extends JpaRepository<StudentProfile,Long> { }
