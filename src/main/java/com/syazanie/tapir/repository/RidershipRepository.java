package com.syazanie.tapir.repository;

import com.syazanie.tapir.entity.FactLineDailyRidership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RidershipRepository extends JpaRepository<FactLineDailyRidership, Long> {
    // Magic method: Find all stats for a specific Line ID
    List<FactLineDailyRidership> findByLineId(Long lineId);
}