package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    private String type;
    private String colour;
    private String status;
    private String malfunctionDetails;

    @ManyToOne
    @JoinColumn(name = "current_driver_id")
    private Employee currentDriver;

    @ManyToOne
    @JoinColumn(name = "current_line_id")
    private Line currentLine;
}