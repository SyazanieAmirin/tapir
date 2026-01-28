package com.syazanie.tapir.service;

import com.syazanie.tapir.entity.FactLineDailyRidership;
import com.syazanie.tapir.repository.RidershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {

    private final RidershipRepository ridershipRepository;

    public StatsService(RidershipRepository ridershipRepository) {
        this.ridershipRepository = ridershipRepository;
    }

    public FactLineDailyRidership addRidershipStats(FactLineDailyRidership stats) {
        return ridershipRepository.save(stats);
    }

    public List<FactLineDailyRidership> getStatsByLine(Long lineId) {
        return ridershipRepository.findByLineId(lineId);
    }
}