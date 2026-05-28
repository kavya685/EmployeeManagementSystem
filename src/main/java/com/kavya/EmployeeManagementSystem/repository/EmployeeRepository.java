/* Your EmployeeRepository (interface)
        ↓ extends
JpaRepository (interface)
        ↓ implemented by
SimpleJpaRepository (actual class, written by Spring team)
        ↓ talks to
MySQL Database */

package com.kavya.EmployeeManagementSystem.repository;

import com.kavya.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
