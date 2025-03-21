package com.events.laMem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.laMem.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
