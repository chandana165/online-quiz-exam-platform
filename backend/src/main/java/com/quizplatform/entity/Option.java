package com.quizplatform.entity;
import jakarta.persistence.*;
@Entity @Table(name="options")
public class Option {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="question_id") private Question question;
 @Column(nullable=false,length=1000) private String optionText;
 @Column(nullable=false) private Boolean correct=false;
 public Long getId(){return id;} public Question getQuestion(){return question;} public void setQuestion(Question v){question=v;}
 public String getOptionText(){return optionText;} public void setOptionText(String v){optionText=v;}
 public Boolean getCorrect(){return correct;} public void setCorrect(Boolean v){correct=v;}
}
