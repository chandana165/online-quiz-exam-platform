package com.quizplatform.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="exam_attempts")
public class ExamAttempt {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="user_id") private User user;
 @ManyToOne(optional=false) @JoinColumn(name="exam_id") private Exam exam;
 @Column(nullable=false,length=20) private String status="SUBMITTED";
 private LocalDateTime startedAt=LocalDateTime.now();
 private LocalDateTime submittedAt;
 public Long getId(){return id;} public User getUser(){return user;} public void setUser(User v){user=v;}
 public Exam getExam(){return exam;} public void setExam(Exam v){exam=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public LocalDateTime getStartedAt(){return startedAt;} public LocalDateTime getSubmittedAt(){return submittedAt;} public void setSubmittedAt(LocalDateTime v){submittedAt=v;}
}
