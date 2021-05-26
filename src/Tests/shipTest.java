package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.charlie.Island.Island;
import me.charlie.Item.Item;
import me.charlie.Ship.Ship;
import me.charlie.Ship.ShipNameHandler;
import me.charlie.Ship.ShipType;

class shipTest {
	
	 String name;
	    ShipType shipType;
	    double sailSpeed;
	    double crewFullness;
	    int maxCargoCapacity;
	    int cargoSpaceRemaining;
	    int maxCrewSize;
	    int currentCrewSize;
	    int cargoFullness;
	    int shipId;
	    int numberOfCannons;
	    int numberOfMastUpgrades;
	    int numberOfCargoHoldUpgrades;
	    int numberOfBulkheadUpgrades;
	    double shipEndurance;
	    double currentShipEndurance;
	    double shipHealth;
	    Island currentIsland;
	    private List<Item> currentCargo;
	    private List<Item> receipts;
	    
	    private Ship Temana;
	    private Ship Otago;
	    private Ship Manawanui;
	    private Ship Aotearoa;
	@BeforeEach
	/** Generate a ship for each type
	 * 
	 */
	void setUp() {
		ShipNameHandler shipNameHandler = new ShipNameHandler();
		Ship Temana = new Ship(ShipType.AIRCRAFT_CARRIER, 4, 15, 30, 50, 750, null, shipNameHandler.getName());
		Ship Otago = new Ship(ShipType.BRIGANTINE, 3, 16, 18, 24, 310, null, shipNameHandler.getName());
		Ship Manawanui = new Ship(ShipType.BARQUENTINE, 2, 20, 8, 12, 150, null, shipNameHandler.getName());
		Ship Aotearoa = new Ship(ShipType.SCHOONER, 1, 17.5, 10, 15, 250, null, shipNameHandler.getName());
	}

	@Test
	void testaddItemToCargo() {
		Temana.addItemToCargo(null);
		
	}

}
