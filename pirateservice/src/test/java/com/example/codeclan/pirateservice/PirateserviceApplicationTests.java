package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void createPirateAndShip(){
//		Ship ship = new Ship("The Flying Dutchman");
//		shipRepository.save(ship);
//
//		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
//		pirateRepository.save(pirate1);
//	}
//
//	@Test
//	public void addPiratesAndRaids(){
//		Ship ship = new Ship("The Flying Dutchman");
//		shipRepository.save(ship);
//
//		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
//		pirateRepository.save(pirate1);
//
//		Raid raid1 = new Raid("Tortuga", 100);
//		raidRepository.save(raid1);
//
//		raid1.addPirate(pirate1);
//		raidRepository.save(raid1);
//
//	}

	@Test
	public void canFindPiratesOver30() {
		List<Pirate> found = pirateRepository.findPiratesByAgeGreaterThan(30);
		assertEquals(7, found.size());
	}

	@Test
	public void canFindRaidByLocation() {
		Raid raid = raidRepository.findRaidByLocation("Tortuga");
		assertEquals("Tortuga", raid.getLocation());
	}

	@Test
	public void findPiratesByRaidId() {
		List<Pirate> foundPirates = pirateRepository.findPiratesByRaidsId(1L);
		assertEquals(1, foundPirates.size());
		assertEquals("Jack", foundPirates.get(0).getFirstName());
	}

	@Test
	public void canFindShipsWithPiratesFirstName() {
		List<Ship> foundShips = shipRepository.findShipsByPiratesFirstName("Maggie");
		assertEquals("The Flying Dustman", foundShips.get(0).getName());
	}

	@Test
	public void findAllRaidsForAGivenShip() {
		Ship foundShip = shipRepository.getOne(3L);
		List<Raid> foundRaids = raidRepository.findRaidByPiratesShip(foundShip);
		assertEquals("Barbados", foundRaids.get(0).getLocation());
	}

}
