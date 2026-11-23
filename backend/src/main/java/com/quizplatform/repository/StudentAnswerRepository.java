package com.quizplatform.repository;
import com.quizplatform.entity.StudentAnswer; import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer,Long> { }
