package com.syazanie.tapir.controller;

import com.syazanie.tapir.entity.Vehicle;
import com.syazanie.tapir.entity.VehicleBreakdown;
import com.syazanie.tapir.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fleet")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Vehicles
    @PostMapping("/vehicles")
    public Vehicle register(@RequestBody Vehicle vehicle) { return vehicleService.registerVehicle(vehicle); }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() { return vehicleService.getAllVehicles(); }

    @GetMapping("/vehicles/line/{lineId}")
    public List<Vehicle> getByLine(@PathVariable Long lineId) { return vehicleService.getVehiclesByLine(lineId); }

    // Breakdowns
    @PostMapping("/breakdowns")
    public VehicleBreakdown reportBreakdown(@RequestBody VehicleBreakdown vb) { return vehicleService.reportBreakdown(vb); }

    @GetMapping("/breakdowns")
    public List<VehicleBreakdown> getAllBreakdowns() { return vehicleService.getAllBreakdowns(); }
}