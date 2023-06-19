package com.Group2.springbootBankingAPI.service;

import com.Group2.springbootBankingAPI.entity.Employee;
import com.Group2.springbootBankingAPI.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

//    Dependecy Injection
    @Autowired
    EmployeeRepository employeeRepository;

    public String save(Employee employee){
        employeeRepository.save(employee);
        return "Saved Successfully";
    }
}
