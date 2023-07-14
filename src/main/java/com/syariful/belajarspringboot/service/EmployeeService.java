package com.syariful.belajarspringboot.service;

import com.syariful.belajarspringboot.model.Employee;

import java.util.List;

// interface -> hanya kumpulan method / function2 yang akan di implementasikan oleh class IMPL
public interface EmployeeService {
    List<Employee> getEmployees();

    Employee saveEmployee(Employee employee);

    Employee getSingleEmployee(Long id);

    void deleteEmployee (Long id);

    Employee updateEmployee (Employee employee);
}

