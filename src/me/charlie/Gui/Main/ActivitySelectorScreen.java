package me.charlie.Gui.Main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Gui.Popups.UnableToHireCrewPopup;
import me.charlie.Gui.Popups.UnableToRepairPopup;
import me.charlie.Gui.Popups.UnableToSailPopup;
import me.charlie.Gui.Popups.UnableToUpgradePopup;
import me.charlie.Item.Item;
import me.charlie.Item.ItemType;
import me.charlie.Ship.Ship;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class ActivitySelectorScreen {

	private JFrame frameActivitySelector;
	private GameManager gameManager;
	private Game game;
	private Ship ship;
	
	/**
	 * Creates a window for the player to choose their next activity.
	 * 
	 * @param gameManager controls the launching and closing of the window.
	 * @param game where the current games data is stored.
	 */
	public ActivitySelectorScreen(GameManager gameManager, Game game) {
		this.gameManager = gameManager;
		this.game = game;
		this.ship = game.getShip();
		initialize();
		frameActivitySelector.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frameActivitySelector.dispose();
	}
	
	/**
	 * Calls GameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.closeActivitySelectorScreen(this);
	}
	
	/**
	 * Opens a screen for the player to view their ships properties.
	 */
	public void launchShipPropertiesScreen() {
		gameManager.launchShipPropertiesScreen();
		finishedWindow();
	}
	
	/**
	 * Opens a window for the player to interact with the store.
	 */
	public void launchStoreOptionsScreen() {
		gameManager.launchStoreOptionsScreen();
		finishedWindow();
	}
	
	/**
	 * Opens a window for the player to choose a Route to sail on.
	 */
	public void launchRouteSelectionScreen() {
		gameManager.launchRouteSelectionScreen();
		finishedWindow();
	}
	
	/**
	 * Opens a window for the player to hire more crew.
	 */
	public void launchCrewHireScreen() {
		gameManager.launchCrewHireScreen();
		finishedWindow();
	}
	
	/**
	 * Opens a window for the player to repair their ship.
	 */
	public void launchShipRepairScreen() {
		gameManager.launchShipRepairScreen();
		finishedWindow();
	}
	
	/**
	 * Opens a window for the player to upgrade their ship.
	 * 
	 * @param outcome the outcome of the upgrade.
	 */
	public void launchShipUpgradeScreen(String outcome) {
		gameManager.launchShipUpgrdeScreen(outcome);
		finishedWindow();
	}
	
	/**
	 * Blocks the player from the repair screen.
	 * Only occurs if the players ships health is already max.
	 */
	public void launchUnableToRepairPopup() {
		frameActivitySelector.setVisible(false);
		UnableToRepairPopup unableToRepairPopup = new UnableToRepairPopup(this, "Ship health is full.");
	}
	
	/**
	 * Blocks the player from the upgrade screen.
	 * 
	 * @param reason the reason they were blocked from upgrading.
	 */
	public void launchUnableToUpgradePopup(String reason) {
		frameActivitySelector.setVisible(false);
		UnableToUpgradePopup unableToUpgradePopup = new UnableToUpgradePopup(this, reason);
	}
	
	/**
	 * Blocks the player from the RouteSelectionScreen.
	 */
	public void launchUnableToSailPopup() {
		frameActivitySelector.setVisible(false);
		UnableToSailPopup unableToSailPopup = new UnableToSailPopup(this, gameManager, game, "Repair your ship before setting out.");
	}
	
	/**
	 * Blocks the player from the crew hire screen.
	 */
	public void launchUnableToHireCrewPopup() {
		frameActivitySelector.setVisible(false);
		UnableToHireCrewPopup unableToHireCrewPopup = new UnableToHireCrewPopup(this);
	}
	
	/**
	 * 
	 * @return the frame of the current window.
	 */
	public JFrame getJFrame() {
		return frameActivitySelector;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivitySelectorScreen window = new ActivitySelectorScreen();
					window.frameActivitySelector.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ActivitySelectorScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameActivitySelector = new JFrame();
		frameActivitySelector.setTitle("Island Trader");
		frameActivitySelector.setResizable(false);
		frameActivitySelector.setType(Type.UTILITY);
		frameActivitySelector.setBounds(100, 100, 302, 336);
		frameActivitySelector.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameActivitySelector.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblWindowDescription = new JLabel("What would you like to do?");
		lblWindowDescription.setFont(new Font("Tahoma", Font.BOLD, 20));
		frameActivitySelector.getContentPane().add(lblWindowDescription);
		
		JLabel lblWindowInstruction = new JLabel("Choose from the following options.");
		lblWindowInstruction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frameActivitySelector.getContentPane().add(lblWindowInstruction);
		
		JButton btnSail = new JButton("    Sail to another island    ");
		btnSail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getShip().getShipHealth() < game.getShip().getShipEndurance()) {
					launchUnableToSailPopup();
				} else {
					launchRouteSelectionScreen();
				}
			}
		});
		btnSail.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnSail);
		
		JButton btnVisitStore = new JButton("    Visit the store    ");
		btnVisitStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchStoreOptionsScreen();
			}
		});
		btnVisitStore.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnVisitStore);
		
		JButton btnHireCrew = new JButton("    Hire more crew members    ");
		btnHireCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getShip().getCrewFullness() == 1) {
					launchUnableToHireCrewPopup();
				} else {
					launchCrewHireScreen();
				}
			}
		});
		btnHireCrew.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnHireCrew);
		
		JButton btnRepairShip = new JButton("    Repair your ship    ");
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ship.getShipHealth() >= ship.getShipEndurance()) {
					btnRepairShip.setEnabled(false);
					launchUnableToRepairPopup();
				} else {
					launchShipRepairScreen();
				}
			}
		});
		btnRepairShip.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnRepairShip);
		
		JButton btnViewProperties = new JButton("    View your ship's properties    ");
		btnViewProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchShipPropertiesScreen();
				finishedWindow();
			}
		});
		btnViewProperties.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnViewProperties);
		
		JButton btnUpgradeShip = new JButton("    Upgrade your ship    ");
		btnUpgradeShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canUpgrade = false;
				for (Item item : game.getShip().getCurrentCargo()) {
					if (item.getItemType().equals(ItemType.UPGRADE)) {
						canUpgrade = true;
					}
				}
				if (canUpgrade) {
					launchShipUpgradeScreen("");
				} else {
					launchUnableToUpgradePopup("You must first purchase upgrades from the store.");
				}
			}
		});
		btnUpgradeShip.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnUpgradeShip);
		
		JLabel lblPlayerCash = new JLabel("       Current Wallet : 0       ");
		lblPlayerCash.setText("       Current Wallet : " + game.getTrader().getMoney() + "       ");
		lblPlayerCash.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameActivitySelector.getContentPane().add(lblPlayerCash);
		
		JLabel lblDaysRemaining = new JLabel("    Days Remaining:     ");
		lblDaysRemaining.setText("    Days Remaining: " + game.getDaysRemaining() + "    ");
		lblDaysRemaining.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameActivitySelector.getContentPane().add(lblDaysRemaining);
	}

}
