# 🚀 HireSense - Smart Job Portal Web Application

HireSense is a full-stack Job Portal Web Application built using Java, JSP, Servlets, JDBC, and Bootstrap.  

It provides a complete recruitment system where:
- 👨‍💼 Employers can post jobs and manage applicants  
- 👩‍💻 Job seekers can apply for jobs and upload resumes  
- 📧 Email notifications are sent automatically   
- 🧠 Resume skill matching and scoring system is implemented  

---

## 🛠️ Tech Stack

### 🔹 Backend
- Java
- JSP & Servlets
- JDBC
- MySQL
- Apache Tomcat

### 🔹 Frontend
- HTML5
- CSS3
- Bootstrap 5
- JavaScript

### 🔹 Tools & Utilities
- Eclipse IDE
- Git & GitHub
- JavaMail API (Email Integration)

---

## ✨ Features

### 👨‍💼 Employer Features
- Register/Login
- Post jobs
- View applicants
- Filter by application status (Applied / Shortlisted / Rejected)
- Shortlist or Reject applicants
- Automatic email notification on status update

### 👩‍💻 Job Seeker Features
- Register/Login
- Upload Resume
- Apply for jobs
- View applied jobs
- Receive email notifications for:
  - Application confirmation
  - Shortlisting
  - Rejection
  - OTP verification

### 🧠 Smart Resume Matching
- Resume parsing logic
- Skill extraction
- Match score calculation
- Applications ordered by score

---

## 📂 Project Structure

<img width="367" height="498" alt="image" src="https://github.com/user-attachments/assets/a2cd57f0-e598-4e72-8036-c773d52c38fc" />


---

## 📨 Email Notifications

Integrated JavaMail API to send:
- Registration OTP
- Password reset OTP
- Application confirmation
- Application status updates
- Employer notification on new application

---

## 🗃️ Database Tables (Main)

- users
- jobs
- applications
- resume_analysis_logs

---

## 🚀 How To Run The Project

1. Clone the repository
   
git clone https://github.com/PhoolSagar/HireSense.git


3. Import into Eclipse as Existing Maven Project

4. Configure:
- Database connection in DBConnection.java
- Email credentials in MailConfig.java

4. Deploy on Apache Tomcat

5. Run in browser:

http://localhost:8080/HireSense

---

## 🌐 Host It (Docker)

This repository now includes a containerized deployment setup:
- `Dockerfile`
- `docker-compose.yml`
- `.env.example`

### 1. Configure environment variables

Create `.env` from `.env.example` and set real mail credentials:

```bash
HIRESENSE_MAIL_USERNAME=your_email@gmail.com
HIRESENSE_MAIL_PASSWORD=your_gmail_app_password
```

### 2. Run with Docker Compose

From project root (`HireSense/`):

```bash
docker compose --env-file .env up -d --build
```

### 3. Open the app

```text
http://localhost:8080/HireSense/login.jsp
```

### 4. Runtime configuration keys

The app reads these environment variables at startup:
- `HIRESENSE_DB_URL`
- `HIRESENSE_DB_USERNAME`
- `HIRESENSE_DB_PASSWORD`
- `HIRESENSE_MAIL_USERNAME`
- `HIRESENSE_MAIL_PASSWORD`
- `HIRESENSE_APP_NAME`

If not provided, it falls back to values in `WEB-INF/web.xml`.

---

## 🔒 Security Features

- Session-based authentication
- Role-based access (User / Employer)
- Input validation
- Secure email authentication

---

## 📌 Future Improvements

- Interview scheduling system
- Admin dashboard
- In-app notification system
- Resume update management
- Cloud deployment

---

## 👨‍💻 Developed By

**Phoolsagar Singh**  

B.Tech Computer Science Engineering  

---

## 📷 Screenshots

# Home page
<img width="2159" height="1224" alt="image" src="https://github.com/user-attachments/assets/a7ad4249-4ea1-443b-bd15-972a8695fd1b" />

---
# Login Page
<img width="1228" height="781" alt="Screenshot 2026-02-12 192917" src="https://github.com/user-attachments/assets/d949acd0-a75c-40eb-a779-66713717984a" />

---
# SignIn Page
<img width="768" height="695" alt="image" src="https://github.com/user-attachments/assets/feb5facc-87f1-477c-b323-af03c3df9348" />

---
# User Dashboard
<img width="2128" height="1216" alt="image" src="https://github.com/user-attachments/assets/27ddac03-4d0a-46b3-821e-1f2a054c6293" />

---
# Employer Dashboard
<img width="2133" height="1219" alt="image" src="https://github.com/user-attachments/assets/2f043cf2-4f51-4a7c-aea2-be6277460b1b" />
<img width="2136" height="1188" alt="image" src="https://github.com/user-attachments/assets/bf1e4197-59d4-4fcb-a670-7a2cc6a9128b" />

---
# Admin Dashboard
<img width="2127" height="1216" alt="image" src="https://github.com/user-attachments/assets/60208cd4-083a-4d05-a136-700365532159" />
<img width="2132" height="1222" alt="image" src="https://github.com/user-attachments/assets/d092812b-92a2-454c-8fef-02399be39fcd" />









---

## ⭐ If You Like This Project

Give it a star on GitHub ⭐
