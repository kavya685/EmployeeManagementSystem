package com.kavya.EmployeeManagementSystem.service.impl;

import com.kavya.EmployeeManagementSystem.dto.EmployeeRequestDto;
import com.kavya.EmployeeManagementSystem.dto.EmployeeResponseDto;
import com.kavya.EmployeeManagementSystem.entity.Employee;
import com.kavya.EmployeeManagementSystem.exception.ResourceNotFoundException;
import com.kavya.EmployeeManagementSystem.repository.EmployeeRepository;
import com.kavya.EmployeeManagementSystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Convert Entity → ResponseDto
    private EmployeeResponseDto mapToResponseDto(Employee employee) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());
        dto.setSalary(employee.getSalary());
        return dto;
    }

    // Convert RequestDto → Entity
    private Employee mapToEntity(EmployeeRequestDto requestDto) {
        Employee employee = new Employee();
        employee.setFirstName(requestDto.getFirstName());
        employee.setLastName(requestDto.getLastName());
        employee.setEmail(requestDto.getEmail());
        employee.setDepartment(requestDto.getDepartment());
        employee.setSalary(requestDto.getSalary());
        return employee;
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto) {
        Employee employee = mapToEntity(requestDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return mapToResponseDto(savedEmployee);
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee not found with id: " + id));
        return mapToResponseDto(employee);
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto requestDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee not found with id: " + id));
        employee.setFirstName(requestDto.getFirstName());
        employee.setLastName(requestDto.getLastName());
        employee.setEmail(requestDto.getEmail());
        employee.setDepartment(requestDto.getDepartment());
        employee.setSalary(requestDto.getSalary());
        Employee updatedEmployee = employeeRepository.save(employee);
        return mapToResponseDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee not found with id: " + id));
        employeeRepository.deleteById(id);
    }
}
