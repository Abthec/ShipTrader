package me.charlie.Gui;

import DiceGame.DiceGameManager;
import me.charlie.Game.DiceGame;
import me.charlie.Game.Game;
import me.charlie.Gui.Main.ActivitySelectorScreen;
import me.charlie.Gui.Main.CrewHireScreen;
import me.charlie.Gui.Main.GameoverScreen;
import me.charlie.Gui.Main.ShipPropertiesScreen;
import me.charlie.Gui.Main.ShipRepairScreen;
import me.charlie.Gui.Main.ShipUpgradeScreen;
import me.charlie.Gui.Main.StoreOperations.StoreOptionsScreen;
import me.charlie.Gui.Main.Travel.ArrivalScreen;
import me.charlie.Gui.Main.Travel.DrowningSailorsEventScreen;
import me.charlie.Gui.Main.Travel.PiratesEventScreen;
import me.charlie.Gui.Main.Travel.RouteSelectionScreen;
import me.charlie.Gui.Main.Travel.StormyWeatherEventScreen;
import me.charlie.Gui.Popups.InvalidTraderNamePopup;
import me.charlie.Gui.gameSetup.SetupShipPropertiesScreen;
import me.charlie.Gui.gameSetup.ShipSelectionScreen;
import me.charlie.Gui.gameSetup.StartupScreen;
import me.charlie.Island.Route;
import me.charlie.Item.Item;
//<<<<<<< HEAD
import me.charlie.Item.ItemType;
//=======
import me.charlie.Item.UpgradeType;
//>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
import me.charlie.Ship.Ship;

/**
 * Controls the loop of the game. Controls the entire GUI portion of the game.
 * 
 * @author charlie
 *
 */
public class GameManager {

	private StartupScreen startupScreen;
	private int gameDuration;
	private String traderName;
	private Ship chosenShip;
	private Game game;
	private DiceGameManager diceGameManager;

	/**
	 * Launches the StartupScreen
	 */
	public void launchStartupScreen() {
		StartupScreen startupWindow = new StartupScreen(this);
		this.startupScreen = startupWindow;
	}

	/**
	 * Closes the StartupScreen without removing the information stored on it.
	 * 
	 * @param startupWindow the instance of StartupScreen.
	 */
	public void minimizeStartupScreen(StartupScreen startupWindow) {
		startupWindow.getSetupJFrame().setVisible(false);
	}

	/**
	 * Reopens the StartupScreen.
	 * 
	 * @param startupWindow the instance of StatupScreen.
	 */
	public void unMinimizeStartupScreen(StartupScreen startupWindow) {
		startupWindow.getSetupJFrame().setVisible(true);
	}

	/**
	 * Closes the StartupScreen and calls a function to launch the next screen.
	 * Assigns values to gameDuration and traderNamer.
	 * 
	 * @param startupWindow the instance of StartupScreen.
	 */
	public void closeStartupScreen(StartupScreen startupWindow) {
		this.gameDuration = startupWindow.getGameDuration();
		this.traderName = startupWindow.getTraderName();
		startupWindow.closeWindow();
		launchShipSelectionScreen();
	}

	/**
	 * launches an InvalidTraderNamePopup to say that the name entered does not meet
	 * specifications. Minimizes the StartupScreen.
	 */
	public void launchInvalidTraderNamePopup() {
		minimizeStartupScreen(startupScreen);
		InvalidTraderNamePopup invalidTraderNamePopupWindow = new InvalidTraderNamePopup(this);
	}

	/**
	 * Closes the InvalidTraderNamePopup, brings back the StartupScreen
	 * 
	 * @param invalidTraderNamePopupWindow the instance of InvalidTraderNamePopup.
	 */
	public void closeInvalidTraderNamePopup(InvalidTraderNamePopup invalidTraderNamePopupWindow) {
		invalidTraderNamePopupWindow.closeWindow();
		unMinimizeStartupScreen(startupScreen);
	}

	/**
	 * Launches the ShipSelectionScreen to get the players choice of Ship.
	 */
	public void launchShipSelectionScreen() {
		ShipSelectionScreen shipSelector = new ShipSelectionScreen(this);
	}

	/**
	 * Takes you from the ShipSelectionScreen back to the StartupScreen
	 * 
	 * @param shipSelectionWindow the instance of ShipSelectionScreen
	 */
	public void shipSelectorGoBack(ShipSelectionScreen shipSelectionWindow) {
		shipSelectionWindow.closeWindow();
		launchStartupScreen();
	}

	/**
	 * Closes the ShipSelectionScreen without terminating it.
	 * 
	 * @param shipSelectionWindow the instance of ShipSelectionScreen.
	 */
	public void minimizeShipSelectionScreen(ShipSelectionScreen shipSelectionWindow) {
		Ship ship = shipSelectionWindow.getChosenShip();
		shipSelectionWindow.getJFrame().setVisible(false);
		launchShipPropertiesScreen(shipSelectionWindow);
	}

	/**
	 * Reopens an existing instance of ShipSelectionScreen.
	 * 
	 * @param shipSelectionWindow the instance of ShipSelectionScreen.
	 */
	public void unMinimizeShipSelectionScreen(ShipSelectionScreen shipSelectionWindow) {
		shipSelectionWindow.getJFrame().setVisible(true);
	}

	/**
	 * Terminates the current instance of ShipSelectionScreen.
	 * 
	 * @param shipSelectionWindow the instance of ShipSelectionScreen.
	 */
	public void closeShipSelectorScreen(ShipSelectionScreen shipSelectionWindow) {
		Ship ship = shipSelectionWindow.getChosenShip();
		shipSelectionWindow.closeWindow();
	}

	/**
	 * Creates an instance of ShipPropertiesScreen.
	 * 
	 * @param shipSelectionWindow the current instance of ShipSelectionScreen.
	 */
	public void launchShipPropertiesScreen(ShipSelectionScreen shipSelectionWindow) {
		SetupShipPropertiesScreen shipPropertiesWindow = new SetupShipPropertiesScreen(this, shipSelectionWindow);
	}

	/**
	 * Takes the player back to the ShipSelectionScreen without terminating the
	 * current instance of ShipPropertiesScreen.
	 * 
	 * @param shipPropertiesWindow the instance of ShipPropertiesScreen.
	 * @param shipSelectionWindow  the instance of ShipSelectionScreen.
	 */
	public void shipPropertiesGoBack(SetupShipPropertiesScreen shipPropertiesWindow,
			ShipSelectionScreen shipSelectionWindow) {
		shipPropertiesWindow.closeWindow();
		unMinimizeShipSelectionScreen(shipSelectionWindow);
	}

	/**
	 * Terminates the current instance of ShipPropertiesScreen.
	 * 
	 * @param shipPropertiesWindow the window that is being closed.
	 */
	public void closeShipPropertiesScreen(SetupShipPropertiesScreen shipPropertiesWindow) {
		this.chosenShip = shipPropertiesWindow.getShip();
		this.game = new Game(traderName, gameDuration, chosenShip, 5);
		shipPropertiesWindow.closeWindow();
		launchActivitySelectorScreen();
	}

	/**
	 * Checks whether or not the game should end. If not, launches
	 * ActivitySelectorScreen. If yes, launches GameoverScreen.
	 */
	public void launchActivitySelectorScreen() {
		if (!canSailSomewhere() && !hasItemsToSell()) {
			launchGameoverScreen("Not enough days to sail anywhere and no items to sell.", false);
		} else if (game.getDaysRemaining() > 0 && !canAffordToPayCrewOneDaysWages() && !hasItemsToSell()) {
			launchGameoverScreen("Cannot afford to sail and had no items to sell.", false);
		} else {
			ActivitySelectorScreen activitySelectorWindow = new ActivitySelectorScreen(this, game);
		}
	}

	/**
	 * Closes the current instance of ActivitySelectorScreen.
	 * 
	 * @param activitySelectorWindow the current instance of ActivitySelectorScreen.
	 */
	public void closeActivitySelectorScreen(ActivitySelectorScreen activitySelectorWindow) {
		activitySelectorWindow.closeWindow();
	}

	/**
	 * Creates an instance of RouteSelectionScreen.
	 */
	public void launchRouteSelectionScreen() {
		RouteSelectionScreen routeSelectionWindow = new RouteSelectionScreen(this, game);
	}

	/**
	 * Closes the current instance of RouteSelecitonScreen.
	 * 
	 * @param routeSelectionWindow the current instance of RouteSelectionScreen.
	 * @param chosenRoute          the route the player has selected to travel.
	 */
	public void closeRouteSelectionScreen(RouteSelectionScreen routeSelectionWindow, Route chosenRoute) {
		routeSelectionWindow.closeWindow();
		launchArrivalScreen(chosenRoute);
	}

	/**
	 * Creates an instance of StormyWeatherEventScreen
	 * 
	 * @param chosenRoute the Route chosen by the player to travel.
	 */
	public void launchStormyWeatherEventScreen(Route chosenRoute) {
		StormyWeatherEventScreen stormyWeatherEventWindow = new StormyWeatherEventScreen(this, chosenRoute, game);
	}

	/**
	 * Closes the current instance of StormyWeatherEventScreen.
	 * 
	 * @param stormyWeatherEventWindow the current instance of
	 *                                 StormyWeatherEventScreen.
	 * @param chosenRoute              the Route chosen by the player to travel.
	 */
	public void closeStormyWeatherEventScreen(StormyWeatherEventScreen stormyWeatherEventWindow, Route chosenRoute) {
		stormyWeatherEventWindow.closeWindow();
		launchArrivalScreen(chosenRoute);
	}

	/**
	 * Creates an instance of the DrowningSailorsEventScreen
	 * 
	 * @param routeChosen the Route on which the event occurs.
	 */
	public void launchDrowningSailorsEventScreen(Route routeChosen) {
		DrowningSailorsEventScreen drowningSailorsEventScreen = new DrowningSailorsEventScreen(this, game, routeChosen);
	}

	/**
	 * Closes the current instance of DrowningSailorsEventScreen.
	 * 
	 * @param drowningSailorsEventScreen the current instance of
	 *                                   DrowningSailorsEventScreen.
	 * @param chosenRoute                the Route on which the event occurs.
	 */
	public void closeDrowningSailorsEventScreen(DrowningSailorsEventScreen drowningSailorsEventScreen,
			Route chosenRoute) {
		drowningSailorsEventScreen.closeWindow();
		launchArrivalScreen(chosenRoute);
	}

	/**
	 * Creates an instance of PiratesEventScreen.
	 * 
	 * @param chosenRoute the route on which the event occurs.
	 */
	public void launchPiratesEventScreen(Route chosenRoute) {
		PiratesEventScreen piratesEventWindow = new PiratesEventScreen(this, chosenRoute);
	}

	/**
	 * Launches the dice game to fight the pirates
	 * 
	 * @param chosenRoute the route on which the pirates attacked.
	 */
	public void launchDiceGame(Route chosenRoute) {
		int handicap = game.getShip().getNumberOfCannons();
		DiceGame diceGame = new DiceGame(handicap);
		DiceGameManager diceGameManager = new DiceGameManager(this, game, chosenRoute, handicap, diceGame);
		this.diceGameManager = diceGameManager;
	}

	/**
	 * Closes the current instance of PiratesEventScreen.
	 * 
	 * @param piratesEventWindow the current instance of PiratesEventScreen.
	 * @param chosenRoute        the route on which the event occurs.
	 */
	public void closePiratesEventScreen(PiratesEventScreen piratesEventWindow, Route chosenRoute) {
		piratesEventWindow.closeWindow();
		launchDiceGame(chosenRoute);
	}

	/**
	 * Creates an instance of ArrivalScreen.
	 * 
	 * @param chosenRoute the Route which the player has just traveled.
	 */
	public void launchArrivalScreen(Route chosenRoute) {
		ArrivalScreen arrivalWindow = new ArrivalScreen(this, chosenRoute, game);
	}

	/**
	 * Closes the current instance of ArrivalScreen.
	 * 
	 * @param arrivalWindow the current instance of ArrivalScreen.
	 */
	public void closeArrivalScreen(ArrivalScreen arrivalWindow) {
		arrivalWindow.closeWindow();
		launchActivitySelectorScreen();
	}

	/**
	 * Creates an instance of StoreOptionsScreen.
	 */
	public void launchStoreOptionsScreen() {
		StoreOptionsScreen storeOptionsWindow = new StoreOptionsScreen(this, game);
	}

	/**
	 * Closes the current instance of StoreOptionsScreen.
	 * 
	 * @param storeOptionsWindow the current instance of StoreOptionsScreen.
	 */
	public void closeStoreOptionsScreen(StoreOptionsScreen storeOptionsWindow) {
		storeOptionsWindow.closeWindow();
		launchActivitySelectorScreen();
	}

	/**
	 * Creates an instance of CrewHireScreen.
	 */
	public void launchCrewHireScreen() {
		CrewHireScreen crewHireWindow = new CrewHireScreen(this, game);
	}

	/**
	 * Closes the current instance of CrewHireScreen.
	 * 
	 * @param crewHireWindow the current instance of CrewHireScreen.
	 */
	public void closeCrewHireScreen(CrewHireScreen crewHireWindow) {
		crewHireWindow.closeWindow();
		launchActivitySelectorScreen();
	}

	/**
	 * Creates an instance of ShipRepairScreen.
	 */
	public void launchShipRepairScreen() {
		ShipRepairScreen shipRepairWindow = new ShipRepairScreen(this, game);
	}

	/**
	 * Closes the current instance of ShipRepairScreen.
	 * 
	 * @param shipRepairWindow the current instance of ShipRepairScreen.
	 */
	public void closeShipRepairScreen(ShipRepairScreen shipRepairWindow) {
		shipRepairWindow.closeWindow();
		launchActivitySelectorScreen();
	}

	/**
	 * Creates an instance of ShipPropertiesScreen.
	 */
	public void launchShipPropertiesScreen() {
		ShipPropertiesScreen shipPropertiesWindow = new ShipPropertiesScreen(this, game);
	}

	/**
	 * Closes the current instance of ShipPropertiesScreen.
	 * 
	 * @param shipPropertiesWindow the current instance of ShipPropertiesScreen.
	 */
	public void closeShipPropertiesScreen(ShipPropertiesScreen shipPropertiesWindow) {
		shipPropertiesWindow.closeWindow();
		launchActivitySelectorScreen();
	}

	/**
	 * Creates an instance of ShipUpgrdeScreen.
	 * 
	 * @param outcome the outcome of the upgrade attempt.
	 */
	public void launchShipUpgrdeScreen(String outcome) {
		ShipUpgradeScreen shipUpgradeWindow = new ShipUpgradeScreen(this, game, outcome);
	}

	/**
	 * Closes the current instance of ShipUpgrdeScreen.
	 * 
	 * @param shipUpgradeWindow the current instance of ShipUpgrdeScreen.
	 */
	public void closeShipUpgradeScreen(ShipUpgradeScreen shipUpgradeWindow) {
		shipUpgradeWindow.closeWindow();
		launchActivitySelectorScreen();
	}

	/**
	 * Creates an instance of GameoverScreen.
	 * 
	 * @param reason        the reason for the Game ending.
	 * @param lossToPirates true if the Game is ending because of pirates, false
	 *                      otherwise.
	 */
	public void launchGameoverScreen(String reason, boolean lossToPirates) {
		GameoverScreen gameoverWindow = new GameoverScreen(game, this, reason, lossToPirates);
	}

	/**
	 * Checks if the player is able to pay their sailors one days worth of sailing
	 * wages.
	 * 
	 * @return true if they can pay their crew, false otherwise.
	 */
	public boolean canAffordToPayCrewOneDaysWages() {
		return game.getTrader().getMoney() > game.getShip().getCurrentCrewSize() * 10;
	}

	/**
	 * 
	 * @return true if the player has items in their cargo.
	 */
	public boolean hasItemsToSell() {
		return game.getShip().getCurrentCargo().size() > 0;
	}

	/**
	 * 
	 * @return true if the player has enough days remaining to sail to another
	 *         island, false otherwise.
	 */
	public boolean canSailSomewhere() {
		boolean canSail = false;
		if (game.getDaysRemaining() == 0) {
			return false;
		} else {
			for (Item upgrade : game.getShip().getCurrentCargo()) {
				if (upgrade.getItemType().equals(ItemType.UPGRADE)) {
					if (upgrade.getUpgradeType().equals(UpgradeType.MAST))
						return true;
				}
			}
			for (Route route : game.getRoutes()) {
				if (route.getIslandA().equals(game.getShip().getCurrentIsland())) {
					if (route.getSailDuration(game.getShip()) <= game.getDaysRemaining()) {
						canSail = true;
					}
				}
			}
		}
		return canSail;
	}

	/**
	 * Begins the game loop
	 * 
	 * @param args args
	 */
	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		gameManager.launchStartupScreen();
	}
}
