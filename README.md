# Online Quiz and Exam Platform – Member 1 (Student & Quiz Management)

This package contains the Student Module:
- React + Vite frontend
- Java 17 + Spring Boot backend
- MySQL database configuration and starter SQL

## Requirements
- Node.js 18+ and npm
- Java 17+
- Maven 3.8+
- MySQL 8+

## 1. Database
Create a MySQL database:
```sql
CREATE DATABASE quiz_platform;
```
The backend uses `spring.jpa.hibernate.ddl-auto=update` to create/update the tables.
Configure your MySQL username/password in `backend/src/main/resources/application.properties`.
Do not commit real database passwords.

## 2. Start backend
```bash
cd backend
mvn spring-boot:run
```
Backend: http://localhost:8080

## 3. Start frontend
Open another terminal:
```bash
cd frontend
npm install
npm run dev
```
Frontend: http://localhost:5173

## 4. Student workflow
1. Register a student account.
2. Log in.
3. View available exams.
4. Open instructions and start an exam.
5. Answer MCQs and submit.
6. View submitted attempts.

## API endpoints
- POST `/api/auth/register`
- POST `/api/auth/login`
- GET `/api/student/profile` (authenticated)
- GET `/api/student/exams` (authenticated)
- GET `/api/student/exams/{examId}` (authenticated)
- GET `/api/student/exams/{examId}/questions` (authenticated; correct answers are never returned)
- POST `/api/student/exams/{examId}/submit` (authenticated)
- GET `/api/student/attempts` (authenticated)

## Notes for team integration
- Member 2 should create/manage exams and questions using the same `exams`, `questions`, and `options` tables/entities.
- This Member 1 module saves submitted answers and attempts. Automatic evaluation and result generation should be completed by Member 2 or jointly integrated.
- The API currently uses a simple bearer-token demo authentication implementation. Replace it with a production JWT/session solution and add role-based authorization before deployment.
- This is a development starter, not a production-hardened examination system. Add server-side exam-window enforcement, attempt limits, audit logs, rate limiting, HTTPS, and stronger token management before real use.
