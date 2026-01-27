package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "`lines`") // Backticks are CRITICAL here
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Line extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "transit_id")
    private Transit transit;

    @Column(nullable = false)
    private String name;
    private String code;
    private String colourHex;
    private Double lengthKm;
    private LocalDate dateStarted;
    private String status;
}