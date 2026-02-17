
---

```markdown
# Collaborative Whiteboard Backend

## 📌 Project Overview
This project is a **Spring Boot + PostgreSQL backend** for a collaborative whiteboard application.  
It demonstrates clean backend scaffolding with relational data models, RESTful APIs, and recruiter‑friendly documentation.  
Entities include **Users, Boards, and Notes**, showcasing one‑to‑many and many‑to‑one relationships.

## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 3.5.10**
- **PostgreSQL 16**
- **Hibernate/JPA**
- **Lombok**
- **Maven**

## ⚙️ Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/chetanmeena45/whiteboard-backend.git
   cd whiteboard-backend
   ```
2. Configure `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5433/whiteboarddb
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## 🔗 API Endpoints

### 👤 Users
- `POST /users` → Create a new user
- `GET /users` → List all users
- `GET /users/{id}` → Get user by ID
- `PUT /users/{id}` → Update user
- `DELETE /users/{id}` → Delete user

### 📋 Boards
- `POST /boards` → Create a new board
- `GET /boards` → List all boards
- `GET /boards/{id}` → Get board by ID
- `PUT /boards/{id}` → Update board
- `DELETE /boards/{id}` → Delete board
- `GET /boards/{id}/notes` → List all notes on a board

### 📝 Notes
- `POST /notes` → Create a new note
- `GET /notes` → List all notes
- `GET /notes/{id}` → Get note by ID
- `PUT /notes/{id}` → Update note
- `DELETE /notes/{id}` → Delete note
- `GET /notes/board/{boardId}` → Get notes by board
- `GET /notes/user/{userId}` → Get notes by user

## 📂 Example JSON Payloads

### Create User
```json
{
  "username": "chetan",
  "email": "chetan@example.com",
  "role": "student"
}
```

### Create Board
```json
{
  "title": "Team Brainstorm Board"
}
```

### Create Note
```json
{
  "content": "First collaborative note",
  "user": { "id": 1 },
  "board": { "id": 1 }
}
```

## 🎯 Key Features
- Clean project scaffolding with **Spring Boot + PostgreSQL**.
- Relational modeling: **Users → Notes → Boards**.
- RESTful APIs with full CRUD operations.
- Lombok annotations for concise, recruiter‑friendly entities.
- Hibernate auto‑table creation (no manual SQL required).

## 👨‍💻 Author
**Chetan Meena**  
B.Tech CSE (Data Science), OIST Bhopal — Graduating 2026  
Focused on backend engineering, workflow optimization, and reproducible project scaffolding.
