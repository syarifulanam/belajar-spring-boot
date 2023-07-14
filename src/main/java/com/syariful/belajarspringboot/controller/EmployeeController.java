package com.syariful.belajarspringboot.controller;

import com.syariful.belajarspringboot.model.Employee;

import com.syariful.belajarspringboot.service.EmployeeService;
import com.syariful.belajarspringboot.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService eService;

    @GetMapping("/test-params")
    public String testParams(@RequestParam String id,
                             @RequestParam("name") String namaKaryawan) {
        return "ID: " + id + ", Name: " + namaKaryawan;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return eService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return eService.getSingleEmployee(id);
    }

    // simpan data
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return eService.saveEmployee(employee);
    }

    // update / ubah data
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return eService.updateEmployee(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam Long id) {
        eService.deleteEmployee(id);
    }
}
