package com.Group2.springbootBankingAPI.repository;

import com.Group2.springbootBankingAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
