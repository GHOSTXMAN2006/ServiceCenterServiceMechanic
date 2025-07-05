package com.example.serviceapplication.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;  // <-- add this import
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {

    @Query("SELECT m FROM Mechanic m WHERE m.availability = 1")
    List<Mechanic> findAvailableMechanics();

    // Short, simple search by name or skillset (case-insensitive)
    @Query("SELECT m FROM Mechanic m WHERE LOWER(m.name) LIKE %:q% OR LOWER(m.skillset) LIKE %:q%")
    List<Mechanic> searchByNameOrSkillset(@Param("q") String query);
}
