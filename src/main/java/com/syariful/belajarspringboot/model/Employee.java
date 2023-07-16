package com.syariful.belajarspringboot.model;

import com.syariful.belajarspringboot.request.EmployeeRequest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JoinColumn(name = "department_id")
    @OneToOne
    private Department department;

//    @NotBlank(message = "Name should not be null")
//    private String name;

    private Long age = 0L;

    private String location;

    @Email(message = "please enter the valid email address")
    private String email;

//    @NotBlank(message = "department should not be null")
//    private String department;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private Date updateAt;

    public Employee(EmployeeRequest req) {
        this.name = req.getName();
    }
}
