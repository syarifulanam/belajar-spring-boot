package com.syariful.belajarspringboot.service;

import com.syariful.belajarspringboot.model.Employee;

import java.util.List;

// interface -> hanya kumpulan method / function2 yang akan di implementasikan oleh class IMPL
public interface EmployeeService {
    List<Employee> getEmployees();

    // fungsinya untuk mengambil semua data employee
    List<Employee> getEmployees(int pageNumber, int pageSize);

    Employee saveEmployee(Employee employee);

    Employee getSingleEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeeByNameAndLocation(String name, String location);

    List<Employee> getEmployeesByKeyword();

    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    List<Employee> getEmployeesByKeyword(String name, String location);

    List<Employee> getEmployeesByKeyword(String name);

    List<Employee> getEmployeesByNameOrLocation(String name, String location);

    Integer deleteEmployeeByName (String name);
}


