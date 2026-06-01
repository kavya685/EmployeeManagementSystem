package com.kavya.EmployeeManagementSystem.controller;

import com.kavya.EmployeeManagementSystem.dto.EmployeeRequestDto;
import com.kavya.EmployeeManagementSystem.dto.EmployeeResponseDto;
import com.kavya.EmployeeManagementSystem.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // CREATE employee
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(
            @Valid @RequestBody EmployeeRequestDto requestDto) {
        EmployeeResponseDto response = employeeService.createEmployee(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET employee by id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(
            @PathVariable Long id) {
        EmployeeResponseDto response = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(response);
    }

    // GET all employees
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        List<EmployeeResponseDto> response = employeeService.getAllEmployees();
        return ResponseEntity.ok(response);
    }

    // UPDATE employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDto requestDto) {
        EmployeeResponseDto response = employeeService.updateEmployee(id, requestDto);
        return ResponseEntity.ok(response);
    }

    // DELETE employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
