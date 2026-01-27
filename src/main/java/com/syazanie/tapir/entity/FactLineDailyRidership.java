package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "fact_line_daily_ridership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FactLineDailyRidership extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate recordDate;

    @ManyToOne
    @JoinColumn(name = "line_id", nullable = false)
    private Line line;

    private Integer totalRiders;
    private Integer peakHourRiders;
}