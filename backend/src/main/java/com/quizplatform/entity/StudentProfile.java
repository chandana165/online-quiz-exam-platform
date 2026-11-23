package com.quizplatform.entity;
import jakarta.persistence.*;
@Entity @Table(name="student_profiles")
public class StudentProfile {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @OneToOne(optional=false) @JoinColumn(name="user_id",unique=true) private User user;
 @Column(length=100) private String college;
 @Column(length=100) private String course;
 public Long getId(){return id;} public User getUser(){return user;} public void setUser(User v){user=v;}
 public String getCollege(){return college;} public void setCollege(String v){college=v;}
 public String getCourse(){return course;} public void setCourse(String v){course=v;}
}
