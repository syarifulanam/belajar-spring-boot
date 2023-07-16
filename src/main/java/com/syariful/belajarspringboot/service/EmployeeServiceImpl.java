package com.syariful.belajarspringboot.service;

import com.syariful.belajarspringboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import com.syariful.belajarspringboot.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository eRepository;

    // CTRL + SHIFT + ALT + L

    @Override
    public List<Employee> getEmployees() {
        return null;
    }

    // fungsinya untuk mengambil semua data employee
    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "id");
        return eRepository.findAll(pages).getContent();
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
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return eRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
        return eRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeesByKeyword() {
        return null;
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return null;
    }

    @Override
    public List<Employee> getEmployeesByKeyword(String name, String location) {
        return eRepository.findByNameAndLocation(name, location);
    }

    @Override
    public List<Employee> getEmployeesByKeyword(String name) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return eRepository.findByNameContaining(name, sort);
    }

    @Override
    public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
        return eRepository.getEmployeesByNameAndLocation(name, location);
    }

    @Override
    public Integer deleteEmployeeByName(String name) {
        return eRepository.deleteEmployeeByName(name);
    }
}

