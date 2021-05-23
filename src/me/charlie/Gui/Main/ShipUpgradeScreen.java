package me.charlie.Gui.Main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Item.Item;
import me.charlie.Item.ItemType;

public class ShipUpgradeScreen {

	private JFrame frameShipUpgradeScreen;
	private GameManager gameManager;
	private Game game;
	private List<Item> upgrades = new ArrayList();
	
	public ShipUpgradeScreen(GameManager gameManager, Game game) {
		this.game = game;
		this.gameManager = gameManager;
		this.upgrades = getUpgrades();
		initialize();
		
	}
	
	public void closeWindow() {
		frameShipUpgradeScreen.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeShipUpgradeScreen(this);
	}
	
	public List<Item> getUpgrades() {
		List<Item> cargo = game.getShip().getCurrentCargo();
		for (Item item : cargo) {
			if (item.getItemType().equals(ItemType.UPGRADE)) {
				upgrades.add(item);
			}
		}
		return upgrades;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipUpgradeScreen window = new ShipUpgradeScreen();
					window.frameShipUpgradeScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShipUpgradeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameShipUpgradeScreen = new JFrame();
		frameShipUpgradeScreen.setBounds(100, 100, 450, 300);
		frameShipUpgradeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
