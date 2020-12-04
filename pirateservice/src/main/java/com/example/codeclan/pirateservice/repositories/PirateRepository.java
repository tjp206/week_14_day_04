package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long> {
    List<Pirate> findPiratesByAgeGreaterThan(int age);     // derived query - don't have to specify pirates in method as already in pirate repository
//    List<Pirate> findPiratesByFirstName(String name);
//    Pirate findDistinctPiratesByFirstName(String name);     // Find specific Pirate
//    List<Pirate> findDistinctPiratesByFirstNameOrLastName(String firstName, String lastName);
    List<Pirate> findPiratesByRaidsId(Long id);       // find pirates by raid id (traversing)


}

// Steps to write a 'derived query' below:
// List?
// Operation - is it a find, read, count, get
// Connected property? Raids/Ships etc
// Object I'm getting back
// Property on the object I'm searching by