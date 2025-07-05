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

    @Query("SELECT m FROM Mechanic m WHERE LOWER(m.name) LIKE %:q%")
    List<Mechanic> searchByName(@Param("q") String query);

    @Query("SELECT m FROM Mechanic m WHERE LOWER(m.skillset) LIKE %:q%")
    List<Mechanic> searchBySkillset(@Param("q") String query);

    List<Mechanic> findByAvailabilityFalse();

}

