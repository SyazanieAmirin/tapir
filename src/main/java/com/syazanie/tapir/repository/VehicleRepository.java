package com.syazanie.tapir.repository;

import com.syazanie.tapir.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByCurrentLineId(Long lineId); // Find all trains on Kajang Line
}