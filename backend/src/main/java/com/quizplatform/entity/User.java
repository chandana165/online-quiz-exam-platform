package com.quizplatform.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=100) private String name;
 @Column(nullable=false,unique=true,length=150) private String email;
 @Column(length=20) private String phone;
 @Column(nullable=false) private String password;
 @Column(nullable=false,length=20) private String role="STUDENT";
 private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public String getRole(){return role;} public void setRole(String v){role=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
