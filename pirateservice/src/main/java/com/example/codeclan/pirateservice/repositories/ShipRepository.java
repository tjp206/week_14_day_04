package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findShipsByPiratesFirstName(String firstName);
}

// Find all Ships with a given pirate's first name on them
//Write a query to find all the ships that have pirates with a given first name on them
//Write a test to make sure the query works.






