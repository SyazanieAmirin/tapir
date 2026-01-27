package com.syazanie.tapir.repository;

import com.syazanie.tapir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Magic method: Finds a user just by their username
    Optional<User> findByUserName(String userName);
}