package com.quizplatform.dto;
import java.time.LocalDateTime;
import java.util.List;
public class QuizDtos {
 public record ExamSummary(Long id, String title, String subject, String description, Integer durationMinutes, Integer totalMarks, long questionCount) {}
 public record ExamDetail(Long id, String title, String subject, String description, Integer durationMinutes, Integer totalMarks, long questionCount, LocalDateTime startAt, LocalDateTime endAt) {}
 public record OptionView(Long id, String optionText) {}
 public record QuestionView(Long id, String questionText, Integer marks, List<OptionView> options) {}
 public record AnswerSubmission(Long questionId, Long optionId) {}
 public record SubmitRequest(List<AnswerSubmission> answers) {}
 public record SubmitResponse(Long attemptId, String status, LocalDateTime submittedAt) {}
 public record AttemptView(Long id, String examTitle, String status, LocalDateTime submittedAt) {}
}
