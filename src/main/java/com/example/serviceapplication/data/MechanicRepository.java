package com.example.serviceapplication.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {
    @Query("SELECT m FROM Mechanic m WHERE m.availability = 1")
    List<Mechanic> findAvailableMechanics();
}
