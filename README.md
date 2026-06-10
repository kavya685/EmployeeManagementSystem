# Employee Management System

![Java](https://img.shields.io/badge/Java-17+-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![MySQL](https://img.shields.io/badge/MySQL-blue)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

A RESTful backend application built with Java and Spring Boot for managing employee records. The system follows a clean layered architecture with the DTO pattern to separate the database layer from the API layer.

---

## Architecture

```text
Client / Postman
        │
        ▼
Controller (REST API)
        │
        ▼
Service Interface + Impl (Business Logic)
        │
        ▼
Repository (Spring Data JPA)
        │
        ▼
MySQL Database
```

---

## Tech Stack

- **Language:** Java 17+
- **Framework:** Spring Boot, Spring Data JPA
- **Libraries:** Lombok
- **Database:** MySQL
- **Build Tool:** Maven

---

## Project Structure

```text
com.kavya.EmployeeManagementSystem
│
├── controller/         → REST endpoints (EmployeeController)
├── service/            → Business logic interface + implementation
├── repository/         → Spring Data JPA repository
├── entity/             → JPA entity (Employee)
├── dto/                → EmployeeRequestDto, EmployeeResponseDto
├── exception/          → ResourceNotFoundException, GlobalExceptionHandler
└── EmployeeManagementSystemApplication.java
```

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| POST | `/api/employees` | Create new employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

---

## Key Design Decisions

**DTO Pattern** — `EmployeeRequestDto` controls what the client sends in; `EmployeeResponseDto` controls what gets returned, keeping sensitive or internal fields out of the API response.

**Global Exception Handling** — `@ControllerAdvice` with `ResourceNotFoundException` returns clean, consistent error messages instead of raw stack traces.

**Constructor Injection** — Lombok's `@RequiredArgsConstructor` is used throughout for safe, boilerplate-free dependency injection.

---

## Getting Started

### Prerequisites
- Java 17+
- MySQL
- Maven

### Clone the Repository
```bash
git clone https://github.com/kavya685/EmployeeManagementSystem.git
cd EmployeeManagementSystem
```

### Configure Database
Update your credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Run the Application
```bash
mvn spring-boot:run
```

The application starts on `http://localhost:8080`
