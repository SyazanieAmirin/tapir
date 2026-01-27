package com.syazanie.tapir.service;

import com.syazanie.tapir.entity.Stop;
import com.syazanie.tapir.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopService {

    private final StopRepository stopRepository;

    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    // Create a Station (e.g., "TRX")
    public Stop createStop(Stop stop) {
        return stopRepository.save(stop);
    }

    // Get all Stations (To plot on the map)
    public List<Stop> getAllStops() {
        return stopRepository.findAll();
    }
}