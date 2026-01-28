package com.syazanie.tapir.repository;

import com.syazanie.tapir.entity.FactStopsTrafficDaily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationTrafficRepository extends JpaRepository<FactStopsTrafficDaily, Long> {}