package com.syazanie.tapir.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complaint extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private String subject;
    private String description;
    private LocalDateTime incidentDate;
    private LocalDateTime reportedDate;
    private String severity;
    private String status;

    private String complainantName;
    private String complainantEmail;
    private String complainantPhoneNo;
    private String evidenceUrl;
    private String resolutionNotes;
}