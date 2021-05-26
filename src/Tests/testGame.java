package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import DiceGame.DiceGameManager;
import me.charlie.Game.DiceGame;
import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Island.Island;
import me.charlie.Island.Route;
import me.charlie.Ship.Ship;
import me.charlie.Ship.ShipType;

class DiceGameTest {
	int islandTotal;
	private Ship ship;
	private Game game;
	private DiceGameManager diceGameManager;
	

	@Test
	void createIslandsTest() {
		islandTotal = 5;
		Ship Temana = new Ship(ShipType.AIRCRAFT_CARRIER, 4, 15, 30, 50, 750, null, null);
		Game testGame = new Game("Tester", 30, Temana, islandTotal);
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
	@Test
	void testDiceGame() {
		islandTotal = 5;
		Ship Temana = new Ship(ShipType.AIRCRAFT_CARRIER, 4, 15, 30, 50, 750, null, null);
		Game testGame = new Game("Tester", 30, Temana, islandTotal);
		GameManager gameManager = new GameManager();
		List<Route> routesList = testGame.getRoutes();
		Temana.addCannon();
		int handicap = game.getShip().getNumberOfCannons();
		System.out.println(handicap);
		Route route = routesList.get(1);
		DiceGame diceGame = new DiceGame(handicap);
		DiceGameManager diceGameManager = new DiceGameManager(gameManager, game, route, handicap);
		diceGame.PlayerTurn(0, handicap, 0);
	}
}
