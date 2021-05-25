package me.charlie.Gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import me.charlie.Gui.Popups.UnableToUpgradePopup;
import me.charlie.Gui.gameSetup.SetupShipPropertiesScreen;
import me.charlie.Gui.gameSetup.ShipSelectionScreen;
import me.charlie.Gui.gameSetup.StartupScreen;
import me.charlie.Island.Route;
import me.charlie.Item.Item;
<<<<<<< HEAD
import me.charlie.Item.ItemType;
=======
import me.charlie.Item.UpgradeType;
>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
import me.charlie.Ship.Ship;

@SuppressWarnings({ "unused"})
public class GameManager {
		
	private StartupScreen startupScreen;
	int gameDuration;
	String traderName;
	Ship chosenShip;
	Game game;
	private DiceGameManager diceGameManager;
	
	public GameManager() {}
	
	public void launchStartupScreen() {
		StartupScreen startupWindow = new StartupScreen(this);
		this.startupScreen = startupWindow;
	}
	
	public void minimizeStartupScreen(StartupScreen startupWindow) {
		startupWindow.getSetupJFrame().setVisible(false);
	}
	
	public void unMinimizeStartupScreen(StartupScreen startupWindow) {
		startupWindow.getSetupJFrame().setVisible(true);
	}
	
	public void closeStartupScreen(StartupScreen startupWindow) {
		this.gameDuration = startupWindow.getGameDuration();
		this.traderName = startupWindow.getTraderName();
		startupWindow.closeWindow();
		launchShipSelectionScreen();
	}
	
	public void launchInvalidTraderNamePopup() {
		minimizeStartupScreen(startupScreen);
		InvalidTraderNamePopup invalidTraderNamePopupWindow = new InvalidTraderNamePopup(this);
	}
	
	public void closeInvalidTraderNamePopup(InvalidTraderNamePopup invalidTraderNamePopupWindow) {
		invalidTraderNamePopupWindow.closeWindow();
		unMinimizeStartupScreen(startupScreen);
	}
	
	public void launchShipSelectionScreen() {
		ShipSelectionScreen shipSelector = new ShipSelectionScreen(this);
	}
	
	public void shipSelectorGoBack(ShipSelectionScreen shipSelectionWindow) {
		shipSelectionWindow.closeWindow();
		launchStartupScreen();
	}
	
	public void minimizeShipSelectionScreen(ShipSelectionScreen shipSelectionWindow) {
		Ship ship = shipSelectionWindow.getChosenShip(); 
		shipSelectionWindow.getJFrame().setVisible(false);
		launchShipPropertiesScreen(shipSelectionWindow);
	}
	
	public void unMinimizeShipSelectionScreen(ShipSelectionScreen shipSelectionWindow) {
		shipSelectionWindow.getJFrame().setVisible(true);
	}
	
	public void closeShipSelectorScreen(ShipSelectionScreen shipSelectionWindow) {
		Ship ship = shipSelectionWindow.getChosenShip();
		shipSelectionWindow.closeWindow();
	}
	
	public void launchShipPropertiesScreen(ShipSelectionScreen shipSelectionWindow) {
		SetupShipPropertiesScreen shipPropertiesWindow = new SetupShipPropertiesScreen(this, shipSelectionWindow);
	}
	
	public void shipPropertiesGoBack(SetupShipPropertiesScreen shipPropertiesWindow, ShipSelectionScreen shipSelectionWindow) {
		shipPropertiesWindow.closeWindow();
		unMinimizeShipSelectionScreen(shipSelectionWindow);
	}
	
	// this method running marks the end of the game creation
	public void closeShipPropertiesScreen(SetupShipPropertiesScreen shipPropertiesWindow) {
		this.chosenShip = shipPropertiesWindow.getShip();
		this.game = new Game(traderName, gameDuration, chosenShip, 5);
		shipPropertiesWindow.closeWindow();
		launchActivitySelectorScreen();
	}
	
	public void launchActivitySelectorScreen() {
		if (!canSailSomewhere() && !hasItemsToSell()) {
			launchGameoverScreen("Not enough days to sail anywhere and no items to sell.", false);
		} else if (game.getDaysRemaining()>0 && !canAffordToPayCrewOneDaysWages() && !hasItemsToSell()) {
			launchGameoverScreen("Cannot afford to sail and had no items to sell.", false);
		} else {
			ActivitySelectorScreen activitySelectorWindow = new ActivitySelectorScreen(this, game);
		}
	}
	
	public void closeActivitySelectorScreen(ActivitySelectorScreen activitySelectorWindow) {
		activitySelectorWindow.closeWindow();
	}
	
	public void launchRouteSelectionScreen() {
		RouteSelectionScreen routeSelectionWindow = new RouteSelectionScreen(this, game);
	}
	
	public void closeRouteSelectionScreen(RouteSelectionScreen routeSelectionWindow, Route chosenRoute) {
		routeSelectionWindow.closeWindow();
		launchArrivalScreen(chosenRoute);
	}
	
	public void launchStormyWeatherEventScreen(Route chosenRoute) {
		StormyWeatherEventScreen stormyWeatherEventWindow = new StormyWeatherEventScreen(this, chosenRoute, game);
	}
	
	public void closeStormyWeatherEventScreen(StormyWeatherEventScreen stormyWeatherEventWindow, Route chosenRoute) {
		stormyWeatherEventWindow.closeWindow();
		launchArrivalScreen(chosenRoute);
	}
	
	public void launchDrowningSailorsEventScreen(Route routeChosen) {
		DrowningSailorsEventScreen drowningSailorsEventScreen = new DrowningSailorsEventScreen(this, game, routeChosen);
	}
	
	public void closeDrowningSailorsEventScreen(DrowningSailorsEventScreen drowningSailorsEventScreen, Route chosenRoute) {
		drowningSailorsEventScreen.closeWindow();
		launchArrivalScreen(chosenRoute);
	}
	
	public void launchPiratesEventScreen(Route chosenRoute) {
		PiratesEventScreen piratesEventWindow = new PiratesEventScreen(this, game, chosenRoute);
	}
	public void launchDiceGame(Route chosenRoute) {
		List<Item> upgrades = new ArrayList();
		List<Item> cargo = game.getShip().getCurrentCargo();
		for (Item item : cargo) {
			if (item.getItemType().equals(ItemType.UPGRADE)) {
				upgrades.add(item);
			}
		}
		int handicap = 6*upgrades.size();
		DiceGame diceGame = new DiceGame(handicap);
		DiceGameManager diceGameManager = new DiceGameManager(this, game, chosenRoute, handicap, diceGame);
		this.diceGameManager = diceGameManager;
	}
	public void closePiratesEventScreen(PiratesEventScreen piratesEventWindow, Route chosenRoute) {
		piratesEventWindow.closeWindow();
		launchDiceGame(chosenRoute);
	}
	
	public void launchArrivalScreen(Route chosenRoute) {
		ArrivalScreen arrivalWindow = new ArrivalScreen(this, chosenRoute, game);
	}
	
	public void closeArrivalScreen(ArrivalScreen arrivalWindow) {
		arrivalWindow.closeWindow();
		launchActivitySelectorScreen();
	}
	
	public void launchStoreOptionsScreen() {
		StoreOptionsScreen storeOptionsWindow = new StoreOptionsScreen(this, game);
	}
	
	public void closeStoreOptionsScreen(StoreOptionsScreen storeOptionsWindow) {
		storeOptionsWindow.closeWindow();
		launchActivitySelectorScreen();
	}
	
	public void launchCrewHireScreen() {
		CrewHireScreen crewHireWindow = new CrewHireScreen(this, game);
	}
	
	public void closeCrewHireScreen(CrewHireScreen crewHireWindow) {
		crewHireWindow.closeWindow();
		launchActivitySelectorScreen();
	}
	
	public void launchShipRepairScreen() {
		ShipRepairScreen shipRepairWindow = new ShipRepairScreen(this, game);
	}
	
	public void closeShipRepairScreen(ShipRepairScreen shipRepairWindow) {
		shipRepairWindow.closeWindow();
		launchActivitySelectorScreen();
	}
	
	public void launchShipPropertiesScreen() {
		ShipPropertiesScreen shipPropertiesWindow = new ShipPropertiesScreen(this, game);
	}
	
	public void closeShipPropertiesScreen(ShipPropertiesScreen shipPropertiesWindow) {
		shipPropertiesWindow.closeWindow();
		launchActivitySelectorScreen();
	}
	
	public void launchShipUpgrdeScreen(String outcome) {
		ShipUpgradeScreen shipUpgradeWindow = new ShipUpgradeScreen(this, game, outcome);
	}
	
	public void closeShipUpgradeScreen(ShipUpgradeScreen shipUpgradeWindow) {
		shipUpgradeWindow.closeWindow();
		launchActivitySelectorScreen();
	}
	
	public void launchGameoverScreen(String reason, boolean lossToPirates) {
		GameoverScreen gameoverWindow = new GameoverScreen(game, this, reason, lossToPirates);
	}
	
	public boolean canAffordToPayCrewOneDaysWages() {
		return game.getTrader().getMoney() > game.getShip().getCurrentCrewSize()*10;
	}
	
	public boolean hasItemsToSell() {
		return game.getShip().getCurrentCargo().size() > 0;
	}
	
	public boolean canSailSomewhere() {
		boolean canSail = false;
		if (game.getDaysRemaining()==0) {
			return false;
		} else {
			for (Item upgrade : game.getShip().getCurrentCargo()) {
				if (upgrade.getUpgradeType().equals(UpgradeType.MAST)) {
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
	
	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		gameManager.launchStartupScreen();
	}
}
