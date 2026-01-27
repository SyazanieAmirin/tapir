package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @Column(nullable = false)
    private String name;
    private String type;
    private String region;
    private String websiteUrl;
    private String logoUrl;
    private String status;
}