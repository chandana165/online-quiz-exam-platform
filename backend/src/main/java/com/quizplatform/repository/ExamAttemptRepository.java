package com.quizplatform.repository;
import com.quizplatform.entity.ExamAttempt; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface ExamAttemptRepository extends JpaRepository<ExamAttempt,Long> { List<ExamAttempt> findByUserIdOrderBySubmittedAtDesc(Long userId); }
