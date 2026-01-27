package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "fact_stops_traffic_daily")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FactStopsTrafficDaily extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate recordDate;

    @ManyToOne
    @JoinColumn(name = "stop_id", nullable = false)
    private Stop stop;

    private Integer entriesCount;
    private Integer exitsCount;
}