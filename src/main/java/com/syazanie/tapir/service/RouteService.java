package com.syazanie.tapir.service;

import com.syazanie.tapir.entity.RouteStop;
import com.syazanie.tapir.entity.FactStopsTrafficDaily;
import com.syazanie.tapir.repository.RouteStopRepository;
import com.syazanie.tapir.repository.StationTrafficRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteStopRepository routeStopRepo;
    private final StationTrafficRepository trafficRepo;

    public RouteService(RouteStopRepository routeStopRepo, StationTrafficRepository trafficRepo) {
        this.routeStopRepo = routeStopRepo;
        this.trafficRepo = trafficRepo;
    }

    // Link a Station to a Line (e.g., "Add Kajang Station to Kajang Line at position 1")
    public RouteStop addStationToLine(RouteStop rs) { return routeStopRepo.save(rs); }
    public List<RouteStop> getAllRoutes() { return routeStopRepo.findAll(); }

    // Station Traffic Stats
    public FactStopsTrafficDaily addTrafficStat(FactStopsTrafficDaily stat) { return trafficRepo.save(stat); }
    public List<FactStopsTrafficDaily> getAllTrafficStats() { return trafficRepo.findAll(); }
}