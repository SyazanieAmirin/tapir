package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle_breakdowns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleBreakdown extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "breakdown_manager_id")
    private Employee breakdownManager;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    private String reason;
    private String description;
    private String status;
    private Integer durationMinutes;
}