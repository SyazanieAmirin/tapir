package com.syazanie.tapir.repository;

import com.syazanie.tapir.entity.Transit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitRepository extends JpaRepository<Transit, Long> {}