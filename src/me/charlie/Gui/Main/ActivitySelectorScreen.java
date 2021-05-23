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
	Game game;
	Ship ship;
	
	public ActivitySelectorScreen(GameManager gameManager, Game game) {
		this.gameManager = gameManager;
		this.game = game;
		this.ship = game.getShip();
		initialize();
		frameActivitySelector.setVisible(true);
	}
	
	public void closeWindow() {
		frameActivitySelector.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeActivitySelectorScreen(this);
	}
	
	public void launchShipPropertiesScreen() {
		
	}
	
	public void launchRouteSelectionScreen() {
		gameManager.launchRouteSelectionScreen();
		finishedWindow();
	}
	
	public void launchCrewHireScreen() {
		
	}
	
	public void launchShipRepairScreen() {
		
	}
	
	public void launchShipUpgradeScreen() {
		
	}
	
	public void launchUnableToRepairPopup() {
		frameActivitySelector.setVisible(false);
		UnableToRepairPopup unableToRepairPopup = new UnableToRepairPopup(this);
	}
	
	public void launchUnableToUpgradePopup() {
		frameActivitySelector.setVisible(false);
		UnableToUpgradePopup unableToUpgradePopup = new UnableToUpgradePopup(this);
	}
	
	public void launchUnableToSailPopup() {
		frameActivitySelector.setVisible(false);
		UnableToSailPopup unableToSailPopup = new UnableToSailPopup(this, "Repair your ship before setting out.");
	}
	
	public void launchUnableToHireCrewPopup() {
		frameActivitySelector.setVisible(false);
		UnableToHireCrewPopup unableToHireCrewPopup = new UnableToHireCrewPopup(this);
	}
	
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
		frameActivitySelector.setBounds(100, 100, 302, 292);
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
		btnVisitStore.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnVisitStore);
		
		JButton btnHireCrew = new JButton("    Hire more crew members    ");
		btnHireCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getShip().getCrewFullness() == 1) {
					launchUnableToHireCrewPopup();
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
					
				} else {
					launchUnableToUpgradePopup();
				}
			}
		});
		btnUpgradeShip.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnUpgradeShip);
		
		JLabel lblPlayerCash = new JLabel("Current Wallet:");
		lblPlayerCash.setText("Current Wallet : " + game.getTrader().getMoney());
		lblPlayerCash.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameActivitySelector.getContentPane().add(lblPlayerCash);
	}

}
