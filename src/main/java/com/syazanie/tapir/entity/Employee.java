package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(name = "ic_no", unique = true)
    private String icNo;

    private String gender;
    private LocalDate birthDate;
    private String phoneNo;
    private String homeAddress;

    private String jobTitle;
    private String department;
    private String workAddress;
    private BigDecimal salary;
    private String status;
    private LocalDate joinDate;

    private String emergencyContactName;
    private String emergencyPhoneNo;
    private String healthCondition;
}