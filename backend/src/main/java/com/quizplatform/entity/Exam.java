package com.quizplatform.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="exams")
public class Exam {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=180) private String title;
 @Column(length=100) private String subject;
 @Column(length=1000) private String description;
 private Integer durationMinutes=30;
 private Integer totalMarks=0;
 @Column(nullable=false) private Boolean published=true;
 private LocalDateTime startAt;
 private LocalDateTime endAt;
 public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getSubject(){return subject;} public void setSubject(String v){subject=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public Integer getDurationMinutes(){return durationMinutes;} public void setDurationMinutes(Integer v){durationMinutes=v;}
 public Integer getTotalMarks(){return totalMarks;} public void setTotalMarks(Integer v){totalMarks=v;}
 public Boolean getPublished(){return published;} public void setPublished(Boolean v){published=v;}
 public LocalDateTime getStartAt(){return startAt;} public void setStartAt(LocalDateTime v){startAt=v;}
 public LocalDateTime getEndAt(){return endAt;} public void setEndAt(LocalDateTime v){endAt=v;}
}
