package me.charlie.Gui;

import java.util.Scanner;

import me.charlie.Game.Game;
import me.charlie.Gui.gameSetup.ActivitySelectorScreen;
import me.charlie.Gui.gameSetup.InvalidTraderNamePopup;
import me.charlie.Gui.gameSetup.ShipPropertiesScreen;
import me.charlie.Gui.gameSetup.ShipSelectionScreen;
import me.charlie.Gui.gameSetup.StartupScreen;
import me.charlie.Ship.Ship;

@SuppressWarnings({ "unused"})
public class GameManager {
		
	private StartupScreen startupScreen;
	int gameDuration;
	String traderName;
	Ship chosenShip;
	Game game;
	
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
		ShipPropertiesScreen shipPropertiesWindow = new ShipPropertiesScreen(this, shipSelectionWindow);
	}
	
	public void shipPropertiesGoBack(ShipPropertiesScreen shipPropertiesWindow, ShipSelectionScreen shipSelectionWindow) {
		shipPropertiesWindow.closeWindow();
		unMinimizeShipSelectionScreen(shipSelectionWindow);
	}
	
	// this method running marks the end of the game creation
	public void closeShipPropertiesScreen(ShipPropertiesScreen shipPropertiesWindow) {
		this.chosenShip = shipPropertiesWindow.getShip();
		this.game = new Game(traderName, gameDuration, chosenShip, 5);
		shipPropertiesWindow.closeWindow();
		launchActivitySelectorScreen();
	}
	
	public void launchActivitySelectorScreen() {
		ActivitySelectorScreen activitySelectorWindow = new ActivitySelectorScreen(this, game);
	}
	
	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		gameManager.launchStartupScreen();
	}



}
