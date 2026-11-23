package com.quizplatform.service;
import com.quizplatform.dto.AuthDtos.UserResponse;
import com.quizplatform.dto.QuizDtos.*;
import com.quizplatform.entity.*;
import com.quizplatform.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
 private final UserRepository users; private final ExamRepository exams; private final QuestionRepository questions;
 private final OptionRepository options; private final ExamAttemptRepository attempts; private final StudentAnswerRepository answers;
 public StudentService(UserRepository users, ExamRepository exams, QuestionRepository questions, OptionRepository options, ExamAttemptRepository attempts, StudentAnswerRepository answers) {
  this.users=users; this.exams=exams; this.questions=questions; this.options=options; this.attempts=attempts; this.answers=answers;
 }
 public UserResponse profile(Long userId) { User u=user(userId); return new UserResponse(u.getId(),u.getName(),u.getEmail(),u.getPhone(),u.getRole()); }
 public List<ExamSummary> exams() { return exams.findByPublishedTrue().stream().map(e -> new ExamSummary(e.getId(),e.getTitle(),e.getSubject(),e.getDescription(),e.getDurationMinutes(),e.getTotalMarks(),questions.countByExamId(e.getId()))).toList(); }
 public ExamDetail exam(Long examId) {
  Exam e=exams.findById(examId).filter(x -> Boolean.TRUE.equals(x.getPublished())).orElseThrow(() -> new IllegalArgumentException("Exam not found or unavailable."));
  return new ExamDetail(e.getId(),e.getTitle(),e.getSubject(),e.getDescription(),e.getDurationMinutes(),e.getTotalMarks(),questions.countByExamId(e.getId()),e.getStartAt(),e.getEndAt());
 }
 public List<QuestionView> questions(Long examId) {
  exam(examId);
  return questions.findByExamIdOrderByDisplayOrderAscIdAsc(examId).stream().map(q ->
   new QuestionView(q.getId(),q.getQuestionText(),q.getMarks(),options.findByQuestionId(q.getId()).stream().map(o -> new OptionView(o.getId(),o.getOptionText())).toList())
  ).toList();
 }
 @Transactional public SubmitResponse submit(Long userId, Long examId, SubmitRequest request) {
  User u=user(userId); Exam e=exams.findById(examId).filter(x -> Boolean.TRUE.equals(x.getPublished())).orElseThrow(() -> new IllegalArgumentException("Exam not found or unavailable."));
  if(request.answers()==null || request.answers().isEmpty()) throw new IllegalArgumentException("Please answer at least one question before submitting.");
  ExamAttempt attempt=new ExamAttempt(); attempt.setUser(u); attempt.setExam(e); attempt.setStatus("SUBMITTED"); attempt.setSubmittedAt(LocalDateTime.now()); attempts.save(attempt);
  for(AnswerSubmission submitted: request.answers()) {
   Question q=questions.findById(submitted.questionId()).orElseThrow(() -> new IllegalArgumentException("Invalid question."));
   if(!q.getExam().getId().equals(examId)) throw new IllegalArgumentException("Question does not belong to this exam.");
   Option option=options.findById(submitted.optionId()).orElseThrow(() -> new IllegalArgumentException("Invalid option."));
   if(!option.getQuestion().getId().equals(q.getId())) throw new IllegalArgumentException("Selected option does not belong to the question.");
   StudentAnswer answer=new StudentAnswer(); answer.setAttempt(attempt); answer.setQuestion(q); answer.setSelectedOption(option); answers.save(answer);
  }
  return new SubmitResponse(attempt.getId(),attempt.getStatus(),attempt.getSubmittedAt());
 }
 public List<AttemptView> attempts(Long userId) {
  return attempts.findByUserIdOrderBySubmittedAtDesc(userId).stream().map(a -> new AttemptView(a.getId(),a.getExam().getTitle(),a.getStatus(),a.getSubmittedAt())).toList();
 }
 private User user(Long id) { return users.findById(id).orElseThrow(() -> new IllegalArgumentException("Student account not found.")); }
}
