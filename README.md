# 🏋️‍♂️ Smart Health & Fitness Logger

A full-stack health tracking web application that helps users **log daily activities, track fitness goals, and monitor progress**.  
Built with **Spring Boot (backend)** and a **modern responsive frontend (HTML, CSS, JS)**.

---

## ✨ Features

- 👤 **User Authentication** – Register & Login securely  
- 🍎 **Food Logging** – Add daily meals with calories  
- 💪 **Exercise Tracking** – Track workouts & calories burned  
- 😴 **Sleep Monitoring** – Log daily sleep hours  
- 🎯 **Goal Management** – Set and monitor calorie/fitness goals    
- 📊 **Daily Summary** – Get a consolidated report of your activities    

---

## 🛠 Tech Stack

**Frontend**
- HTML5, CSS3, JavaScript  
- Responsive UI with premium glassmorphism design  

**Backend**
- Java 17  
- Spring Boot 3.x  
- Spring Web, Spring Data JPA, Hibernate  
- MySQL / PostgreSQL (configurable)  

**Deployment**
- Render / Railway / Heroku  

---

## 📂 Project Structure

smart-health-fitness-logger/
│
├── src/main/java/com/villain/healthtracker
│ ├── controller/ # REST Controllers (Food, Exercise, Sleep, Goal, User)
│ ├── entity/ # JPA Entities
│ ├── repository/ # JPA Repositories
│ ├── service/ # Business Logic
│ └── SmartHealthLoggerApplication.java
│
├── src/main/resources/
│ ├── application.properties # DB + server config
│ └── static/ # Frontend files (index.html, style.css, script.js)
│
└── pom.xml