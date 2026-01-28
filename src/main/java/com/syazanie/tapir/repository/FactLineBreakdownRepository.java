package com.syazanie.tapir.repository;

import com.syazanie.tapir.entity.FactLineBreakdown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactLineBreakdownRepository extends JpaRepository<FactLineBreakdown, Long> {}