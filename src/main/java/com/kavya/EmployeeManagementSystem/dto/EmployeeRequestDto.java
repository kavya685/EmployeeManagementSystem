package com.kavya.EmployeeManagementSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

    @NotBlank(message = "first name is required")
    private String firstname;

    @NotBlank(message = "last name is required")
    private String lastname;

    @NotBlank(message = "email is required")
    @Email(message = "email should be valid")
    private String email;

    @NotBlank(message = "department is required")
    private String department;

    @NotNull(message = "salary is required")
    @Positive(message = "salary should be a positive number")
    private Double salary;
}
