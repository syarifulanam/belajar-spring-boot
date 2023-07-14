package com.syariful.belajarspringboot.service;

import com.syariful.belajarspringboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.syariful.belajarspringboot.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
 public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository eRepository;

    // CTRL + SHIFT + ALT + L

    // fungsinya untuk mengambil semua data employee
    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }

    // fungsinya untuk menyimpan data employee
    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for the id");
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee (Employee employee) {
        return eRepository.save(employee);
    }
}

