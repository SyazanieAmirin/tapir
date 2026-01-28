package com.syazanie.tapir.service;

import com.syazanie.tapir.entity.Complaint;
import com.syazanie.tapir.entity.FactLineBreakdown;
import com.syazanie.tapir.repository.ComplaintRepository;
import com.syazanie.tapir.repository.FactLineBreakdownRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {

    private final ComplaintRepository complaintRepo;
    private final FactLineBreakdownRepository lineBreakdownRepo;

    public IncidentService(ComplaintRepository complaintRepo, FactLineBreakdownRepository lineBreakdownRepo) {
        this.complaintRepo = complaintRepo;
        this.lineBreakdownRepo = lineBreakdownRepo;
    }

    // Complaints
    public Complaint createComplaint(Complaint c) { return complaintRepo.save(c); }
    public List<Complaint> getAllComplaints() { return complaintRepo.findAll(); }

    // Infrastructure Breakdowns
    public FactLineBreakdown reportLineIssue(FactLineBreakdown flb) { return lineBreakdownRepo.save(flb); }
    public List<FactLineBreakdown> getAllLineIssues() { return lineBreakdownRepo.findAll(); }
}