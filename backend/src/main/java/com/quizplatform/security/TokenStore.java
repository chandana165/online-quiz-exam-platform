package com.quizplatform.security;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TokenStore {
 private final Map<String, Long> tokens = new ConcurrentHashMap<>();
 public String issue(Long userId) { String token = UUID.randomUUID().toString(); tokens.put(token, userId); return token; }
 public Long findUserId(String token) { return tokens.get(token); }
}
