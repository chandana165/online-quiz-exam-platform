package com.quizplatform.entity;
import jakarta.persistence.*;
@Entity @Table(name="student_answers")
public class StudentAnswer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="attempt_id") private ExamAttempt attempt;
 @ManyToOne(optional=false) @JoinColumn(name="question_id") private Question question;
 @ManyToOne(optional=false) @JoinColumn(name="selected_option_id") private Option selectedOption;
 public Long getId(){return id;} public ExamAttempt getAttempt(){return attempt;} public void setAttempt(ExamAttempt v){attempt=v;}
 public Question getQuestion(){return question;} public void setQuestion(Question v){question=v;}
 public Option getSelectedOption(){return selectedOption;} public void setSelectedOption(Option v){selectedOption=v;}
}
