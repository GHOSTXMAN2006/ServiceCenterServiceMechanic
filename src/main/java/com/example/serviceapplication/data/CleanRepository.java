package com.example.serviceapplication.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface CleanRepository extends JpaRepository<Clean, Integer> {

    @Query("SELECT c FROM Clean c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(c.desc) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Clean> search(@Param("keyword") String keyword);
}
