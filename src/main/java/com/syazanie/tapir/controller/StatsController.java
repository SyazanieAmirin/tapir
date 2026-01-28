package com.syazanie.tapir.controller;

import com.syazanie.tapir.entity.FactLineDailyRidership;
import com.syazanie.tapir.service.StatsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @PostMapping("/ridership")
    public FactLineDailyRidership addStats(@RequestBody FactLineDailyRidership stats) {
        return statsService.addRidershipStats(stats);
    }

    @GetMapping("/ridership/{lineId}")
    public List<FactLineDailyRidership> getStats(@PathVariable Long lineId) {
        return statsService.getStatsByLine(lineId);
    }
}