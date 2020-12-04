package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaidRepository extends JpaRepository<Raid, Long> {
    Raid findRaidByLocation(String location);
    List<Raid> findRaidByPiratesShip(Ship ship);
}

// Find Raid by location
//Write a query to find a raid by location
//Write a test to make sure the query works.

//    Find all the raids for a given ship
//        Write a query to find all the raids for a given ship
//        Write a test to make sure the query works.
//        Tip: you'll need to give it a Ship you know has pirates that are on raids!

