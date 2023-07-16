package com.syariful.belajarspringboot.repository;

import com.syariful.belajarspringboot.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    List<Employee> findByName(String name);

    //SELECT FROM table WHERE name="syariful" AND location="Jakarta"
    List<Employee> findByNameAndLocation(String name, String location);

    //SELECT FROM table WHERE name "%ram%"
    List<Employee> findByNameContaining(String keyword, Sort sort );

    @Query("FROM Employee WHERE name = :name OR location = :location")
    List<Employee> getEmployeesByNameAndLocation(String name, String location);

    @Transactional
    @Modifying
    @Query("DELETE FROM Employee WHERE name = :name")
    Integer deleteEmployeeByName(String name);

    // munculin semua karyawan yg pake YMAIL / yahoo mail
    //SELECT * FROM tbl_employee where email like "%ymail%";
    // findBy ==> SELECT * FROM tbl_employee where
    // Containing ==> where email like "%ymail%";
//    List<Employee> findByEmailContaining(String email); // list itu untuk data lebih dari 1 biji

    //SELECT * FROM tbl_employee where email = "anam04@gmail.com";
//    Employee findByEmail(String email); // 1 data saja
}
