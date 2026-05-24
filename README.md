# EmployeeManagementSystem structure:

com.kavya.EmployeeManagementSystem
│
├── controller
│   └── EmployeeController.java       ← handles HTTP requests
│
├── service
│   ├── EmployeeService.java          ← interface
│   └── impl
│       └── EmployeeServiceImpl.java  ← business logic
│
├── repository
│   └── EmployeeRepository.java       ← talks to DB (JPA)
│
├── entity
│   └── Employee.java                 ← DB table mapped as Java class
│
├── dto
│   ├── EmployeeRequestDto.java       ← what client sends
│   └── EmployeeResponseDto.java      ← what you return back
│
├── exception
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java   ← @ControllerAdvice
│
└── EmployeeManagementSystemApplication.java
