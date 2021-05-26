package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.charlie.Game.Game;
import me.charlie.Island.Island;
import me.charlie.Island.Route;
import me.charlie.Ship.Ship;
import me.charlie.Ship.ShipType;

class testCreations {
	int islandTotal;
	private Game testGame;

	@BeforeEach
	void setUp() {
		islandTotal = 5;
		Ship Temana = new Ship(ShipType.AIRCRAFT_CARRIER, 4, 15, 30, 50, 750, null, null);
		Game testGame = new Game("Tester", 30, Temana, islandTotal);
		this.testGame = testGame;
	}

	@Test
	void createIslandsTest() {;
		List<Island> islandsList = testGame.getIslands();
		for (int i = 0; i< islandsList.size(); i++ ) {
			System.out.println(islandsList.get(i));
		}
	}
	@Test
	void createRoutesTest() {
		islandTotal = 5;
		Ship Temana = new Ship(ShipType.AIRCRAFT_CARRIER, 4, 15, 30, 50, 750, null, null);
		Game testGame = new Game("Tester", 30, Temana, islandTotal);
		List<Route> routesList = testGame.getRoutes();
		for (Route route: routesList) {
			System.out.println(route);
		}
	}
}
