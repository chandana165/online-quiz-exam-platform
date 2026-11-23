package com.quizplatform.controller;
import com.quizplatform.dto.AuthDtos.UserResponse;
import com.quizplatform.dto.QuizDtos.*;
import com.quizplatform.service.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/student")
public class StudentController {
 private final StudentService service;
 public StudentController(StudentService service) { this.service=service; }
 private Long userId(Authentication auth) { return Long.valueOf(auth.getPrincipal().toString()); }
 @GetMapping("/profile") public UserResponse profile(Authentication auth) { return service.profile(userId(auth)); }
 @GetMapping("/exams") public List<ExamSummary> exams() { return service.exams(); }
 @GetMapping("/exams/{examId}") public ExamDetail exam(@PathVariable Long examId) { return service.exam(examId); }
 @GetMapping("/exams/{examId}/questions") public List<QuestionView> questions(@PathVariable Long examId) { return service.questions(examId); }
 @PostMapping("/exams/{examId}/submit") public SubmitResponse submit(@PathVariable Long examId, @RequestBody SubmitRequest req, Authentication auth) { return service.submit(userId(auth),examId,req); }
 @GetMapping("/attempts") public List<AttemptView> attempts(Authentication auth) { return service.attempts(userId(auth)); }
}
