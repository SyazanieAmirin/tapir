package com.syazanie.tapir.service;

import com.syazanie.tapir.entity.Vehicle;
import com.syazanie.tapir.entity.VehicleBreakdown;
import com.syazanie.tapir.repository.VehicleRepository;
import com.syazanie.tapir.repository.VehicleBreakdownRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepo;
    private final VehicleBreakdownRepository breakdownRepo;

    public VehicleService(VehicleRepository vehicleRepo, VehicleBreakdownRepository breakdownRepo) {
        this.vehicleRepo = vehicleRepo;
        this.breakdownRepo = breakdownRepo;
    }

    // Vehicle Logic
    public Vehicle registerVehicle(Vehicle vehicle) { return vehicleRepo.save(vehicle); }
    public List<Vehicle> getAllVehicles() { return vehicleRepo.findAll(); }
    public List<Vehicle> getVehiclesByLine(Long lineId) { return vehicleRepo.findByCurrentLineId(lineId); }

    // Breakdown Logic
    public VehicleBreakdown reportBreakdown(VehicleBreakdown breakdown) {
        // Option: Logic to update Vehicle status to "MAINTENANCE" could go here
        return breakdownRepo.save(breakdown);
    }
    public List<VehicleBreakdown> getAllBreakdowns() { return breakdownRepo.findAll(); }
}