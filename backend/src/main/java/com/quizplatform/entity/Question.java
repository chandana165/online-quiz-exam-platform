package com.quizplatform.entity;
import jakarta.persistence.*;
@Entity @Table(name="questions")
public class Question {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="exam_id") private Exam exam;
 @Column(nullable=false,length=2000) private String questionText;
 private Integer marks=1;
 private Integer displayOrder=0;
 public Long getId(){return id;} public Exam getExam(){return exam;} public void setExam(Exam v){exam=v;}
 public String getQuestionText(){return questionText;} public void setQuestionText(String v){questionText=v;}
 public Integer getMarks(){return marks;} public void setMarks(Integer v){marks=v;}
 public Integer getDisplayOrder(){return displayOrder;} public void setDisplayOrder(Integer v){displayOrder=v;}
}
