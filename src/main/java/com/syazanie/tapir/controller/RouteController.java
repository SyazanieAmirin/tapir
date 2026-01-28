package com.syazanie.tapir.controller;

import com.syazanie.tapir.entity.RouteStop;
import com.syazanie.tapir.entity.FactStopsTrafficDaily;
import com.syazanie.tapir.service.RouteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/assign-station")
    public RouteStop assignStation(@RequestBody RouteStop rs) { return routeService.addStationToLine(rs); }

    @GetMapping("/assignments")
    public List<RouteStop> getAll() { return routeService.getAllRoutes(); }

    @PostMapping("/traffic")
    public FactStopsTrafficDaily addTraffic(@RequestBody FactStopsTrafficDaily stat) { return routeService.addTrafficStat(stat); }

    @GetMapping("/traffic")
    public List<FactStopsTrafficDaily> getTraffic() { return routeService.getAllTrafficStats(); }
}