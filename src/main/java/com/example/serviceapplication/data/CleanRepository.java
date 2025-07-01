package com.example.serviceapplication.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleanRepository extends JpaRepository<Clean, Integer> {
}
