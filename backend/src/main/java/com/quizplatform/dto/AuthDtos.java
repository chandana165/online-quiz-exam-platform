package com.quizplatform.dto;
import jakarta.validation.constraints.*;
public class AuthDtos {
 public record RegisterRequest(@NotBlank @Size(min=2,max=100) String name, @NotBlank @Email String email,
   String phone, @NotBlank @Size(min=8,max=100) String password) {}
 public record LoginRequest(@NotBlank @Email String email, @NotBlank String password) {}
 public record UserResponse(Long id, String name, String email, String phone, String role) {}
 public record AuthResponse(String token, UserResponse user) {}
}
