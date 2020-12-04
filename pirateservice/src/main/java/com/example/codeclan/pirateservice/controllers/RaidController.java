package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RaidController {

    @Autowired
    RaidRepository raidRepository;

    @GetMapping(value = "/raids")       // find raid by location or else return all raids
    public ResponseEntity<List<Raid>> findRaidsByFilteredLocation(
            @RequestParam(name="location", required = false)String location
    ) {
        if(location != null) {
            return new ResponseEntity(raidRepository.findRaidByLocation(location), HttpStatus.OK);
        }
        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/raids/{id}")
    public ResponseEntity getRaid(@PathVariable Long id) {
        return new ResponseEntity<>(raidRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/raids")
    public ResponseEntity<Raid> postRaid(@RequestBody Raid raid) {
        raidRepository.save(raid);
        return new ResponseEntity<>(raid, HttpStatus.CREATED);
    }

}

// Create a controller for "find / filter raid by location name"
//Write a controller that connects into the "find raid by location" query we completed in the last lesson
//TIP: Think about what controller it should be in. We're dealing with raids... so RaidController.java
//TIP: Consider using a query string to create a filter.
//TIP: Consider what might happen when our route clashes with the existing GET on /raids.
