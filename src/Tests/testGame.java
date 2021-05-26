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
	private DiceGame diceGame;
	

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
	/** creates a ship, GameManager, DiceGaneManager and DiceGame in order to test the DiceGameManager.Playerturnfunction.
	 * you can test the handicap aspect by adjusting the amount of times the .addCannon is used as the amount of handicaps determines the players handicap
	 */
	void testPlayerTurn() {
		islandTotal = 5;
		Ship Temana = new Ship(ShipType.AIRCRAFT_CARRIER, 4, 15, 30, 50, 750, null, null);
		Game testGame = new Game("Tester", 30, Temana, islandTotal);
		this.game = testGame;
		GameManager gameManager = new GameManager();
		List<Route> routesList = testGame.getRoutes();
		Temana.addCannon();
		Temana.addCannon();
		Temana.addCannon();
		int handicap = (game.getShip().getNumberOfCannons())*6;
		System.out.println(handicap);
		Route route = routesList.get(1);
		DiceGame diceGame = new DiceGame(handicap);
		this.diceGame = diceGame;
		DiceGameManager diceGameManager = new DiceGameManager(gameManager, game, route, handicap, diceGame);
		diceGame.PlayerTurn(0, handicap, 0);
		diceGameManager.playerTurn();
		diceGameManager.passTurn();
		System.out.println("new score is: " + diceGameManager.getPlayerScore());
	}
	@Test
	/** Most of this function is performed automatically, this is test the rolls are being added properly
	 * 
	 */
	void testPirateTurn() {
		islandTotal = 5;
		Ship Temana = new Ship(ShipType.AIRCRAFT_CARRIER, 4, 15, 30, 50, 750, null, null);
		Game testGame = new Game("Tester", 30, Temana, islandTotal);
		this.game = testGame;
		GameManager gameManager = new GameManager();
		List<Route> routesList = testGame.getRoutes();
		Route route = routesList.get(1);
		int handicap = (game.getShip().getNumberOfCannons())*6;
		DiceGame diceGame = new DiceGame(handicap);
		this.diceGame = diceGame;
		DiceGameManager diceGameManager = new DiceGameManager(gameManager, game, route, handicap, diceGame);
		System.out.println(String.format("The pirates score is: %d", diceGameManager.getPirateScore()));
		diceGameManager.pirateTurn();
		int dice[] = diceGame.getDice();
		System.out.println(String.format("Pirates roll is: %d , %d", dice[0], dice[1]));
		System.out.println(String.format("The pirates score is: %d", diceGameManager.getPirateScore()));	}
}
