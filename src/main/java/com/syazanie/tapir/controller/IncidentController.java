package com.syazanie.tapir.controller;

import com.syazanie.tapir.entity.Complaint;
import com.syazanie.tapir.entity.FactLineBreakdown;
import com.syazanie.tapir.service.IncidentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping("/complaints")
    public Complaint createComplaint(@RequestBody Complaint c) { return incidentService.createComplaint(c); }

    @GetMapping("/complaints")
    public List<Complaint> getComplaints() { return incidentService.getAllComplaints(); }

    @PostMapping("/line-issues")
    public FactLineBreakdown reportIssue(@RequestBody FactLineBreakdown flb) { return incidentService.reportLineIssue(flb); }

    @GetMapping("/line-issues")
    public List<FactLineBreakdown> getLineIssues() { return incidentService.getAllLineIssues(); }
}