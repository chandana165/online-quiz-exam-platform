package com.quizplatform.service;
import com.quizplatform.dto.AuthDtos.*;
import com.quizplatform.entity.User;
import com.quizplatform.repository.UserRepository;
import com.quizplatform.security.TokenStore;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
 private final UserRepository users; private final PasswordEncoder encoder; private final TokenStore tokens;
 public AuthService(UserRepository users, PasswordEncoder encoder, TokenStore tokens) { this.users=users; this.encoder=encoder; this.tokens=tokens; }
 @Transactional public AuthResponse register(RegisterRequest req) {
  if(users.existsByEmail(req.email().toLowerCase())) throw new IllegalArgumentException("Email is already registered.");
  User u=new User(); u.setName(req.name().trim()); u.setEmail(req.email().toLowerCase().trim()); u.setPhone(req.phone());
  u.setPassword(encoder.encode(req.password())); u.setRole("STUDENT"); users.save(u);
  return response(u);
 }
 public AuthResponse login(LoginRequest req) {
  User u=users.findByEmail(req.email().toLowerCase().trim()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
  if(!encoder.matches(req.password(),u.getPassword())) throw new IllegalArgumentException("Invalid email or password.");
  return response(u);
 }
 private AuthResponse response(User u) { return new AuthResponse(tokens.issue(u.getId()),new UserResponse(u.getId(),u.getName(),u.getEmail(),u.getPhone(),u.getRole())); }
}
