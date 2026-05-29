/* Client sends JSON
        ↓
        Controller receives → RequestDto
        ↓
        Service takes RequestDto
        ↓ converts to Entity → saves to DB
        ↓ fetches from DB → converts to ResponseDto
        Service returns → ResponseDto
        ↓
        Controller returns ResponseDto
        ↓
        Jackson converts to JSON → Client receives */

package com.kavya.EmployeeManagementSystem.service;

import com.kavya.EmployeeManagementSystem.dto.EmployeeRequestDto;
import com.kavya.EmployeeManagementSystem.dto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto createEmployee(EmployeeRequestDto requestDto);

    EmployeeResponseDto getEmployeeById(Long id);

    List<EmployeeResponseDto> getAllEmployees();

    EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto requestDto);

    void deleteEmployee(Long id);
}
