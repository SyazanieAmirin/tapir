package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fact_line_breakdowns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FactLineBreakdown extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "line_id", nullable = false)
    private Line line;

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