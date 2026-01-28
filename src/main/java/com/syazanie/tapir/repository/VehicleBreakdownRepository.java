package com.syazanie.tapir.repository;

import com.syazanie.tapir.entity.VehicleBreakdown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleBreakdownRepository extends JpaRepository<VehicleBreakdown, Long> {}