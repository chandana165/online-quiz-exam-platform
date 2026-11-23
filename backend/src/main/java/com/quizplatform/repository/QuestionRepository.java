package com.quizplatform.repository;
import com.quizplatform.entity.Question; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface QuestionRepository extends JpaRepository<Question,Long> { List<Question> findByExamIdOrderByDisplayOrderAscIdAsc(Long examId); long countByExamId(Long examId); }
