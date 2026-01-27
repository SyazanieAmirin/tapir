package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "operators")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operator extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String coRegNo;
    private String contactEmail;
    private String contactNo;
    private String hqAddress;
    private String licenseCode;
    private String status;
}