package com.syazanie.tapir.controller;

import com.syazanie.tapir.entity.Stop;
import com.syazanie.tapir.service.StopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stops")
public class StopController {

    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @PostMapping
    public Stop create(@RequestBody Stop stop) {
        return stopService.createStop(stop);
    }

    @GetMapping
    public List<Stop> getAll() {
        return stopService.getAllStops();
    }
}