package me.charlie.Gui.Main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Gui.Popups.UnableToUpgradePopup;
import me.charlie.Item.Item;
import me.charlie.Item.ItemType;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShipUpgradeScreen {

	private JFrame frameShipUpgradeScreen;
	private GameManager gameManager;
	private Game game;
	private List<Item> upgrades = new ArrayList();
	private int listIndex=0;
	private JLabel lblOutcome;
	private JButton btnConfirm;
	private String outcome;
	
	/**
	 * Opens a window for the player to apply upgrades to their ship.
	 * 
	 * @param gameManager controls the launching and closing of the window.
	 * @param game the Game data.
	 * @param outcome the outcome of the previous upgrade.
	 */
	public ShipUpgradeScreen(GameManager gameManager, Game game, String outcome) {
		this.outcome = outcome;
		this.game = game;
		this.gameManager = gameManager;
		this.upgrades = getUpgrades();
		initialize();
		frameShipUpgradeScreen.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frameShipUpgradeScreen.dispose();
	}
	
	/**
	 * Calls GameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.closeShipUpgradeScreen(this);
	}
	
	/**
	 * Sets the outcome of the previous upgrade for the player to see.
	 */
	public void setOutcome() {
		lblOutcome.setText(outcome);
	}
	
	/**
	 * Disables the confirm button.
	 */
	public void disableConfirm() {
		btnConfirm.setEnabled(false);
	}
	
	/**
	 * Refreshes the text in the outcome label.
	 * 
	 * @param outcomeString the string to be put into the label.
	 */
	public void refresh(String outcomeString) {
		closeWindow();
		gameManager.launchShipUpgrdeScreen(outcomeString);
	}
	
	/**
	 * 
	 * @return the frame of the current window.
	 */
	public JFrame getJFrame() {
		return frameShipUpgradeScreen;
	}
	
	/**
	 * Blocks the player from upgrading with a popup.
	 * 
	 * @param reason the reason the player was unable to upgrade.
	 */
	public void launchUnableToUpgradePopup(String reason) {
		UnableToUpgradePopup unableToUpgradePopup = new UnableToUpgradePopup(this, reason);
		frameShipUpgradeScreen.setVisible(false);
	}
	
	/**
	 * Searches through the Ship's current cargo to find the available upgrades. 
	 * 
	 * @return all the upgrades currently possed by the player.
	 */
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
		frameShipUpgradeScreen.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frameShipUpgradeScreen.setBounds(100, 100, 674, 430);
		frameShipUpgradeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frameShipUpgradeScreen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Ship Upgrader.");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 0;
		frameShipUpgradeScreen.getContentPane().add(lblWelcome, gbc_lblWelcome);
		
		JLabel spacer6 = new JLabel("                   ");
		GridBagConstraints gbc_spacer6 = new GridBagConstraints();
		gbc_spacer6.insets = new Insets(0, 0, 5, 0);
		gbc_spacer6.gridx = 0;
		gbc_spacer6.gridy = 1;
		frameShipUpgradeScreen.getContentPane().add(spacer6, gbc_spacer6);
		
		JLabel lblInsctruction = new JLabel("Select an upgrade and press confirm.");
		lblInsctruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInsctruction = new GridBagConstraints();
		gbc_lblInsctruction.insets = new Insets(0, 0, 5, 0);
		gbc_lblInsctruction.gridx = 0;
		gbc_lblInsctruction.gridy = 2;
		frameShipUpgradeScreen.getContentPane().add(lblInsctruction, gbc_lblInsctruction);
		
		JLabel spacer5 = new JLabel("                   ");
		GridBagConstraints gbc_spacer5 = new GridBagConstraints();
		gbc_spacer5.insets = new Insets(0, 0, 5, 0);
		gbc_spacer5.gridx = 0;
		gbc_spacer5.gridy = 3;
		frameShipUpgradeScreen.getContentPane().add(spacer5, gbc_spacer5);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		frameShipUpgradeScreen.getContentPane().add(scrollPane, gbc_scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		
		for (Item item : upgrades) {
			String itemString = item.getUpgradeType().getName() + " | " + item.getUpgradeType().getDescription(item.getUpgradeType());
			listModel.add(listIndex, itemString);
			listIndex++;
		}
		
		JList listUpgrades = new JList();
		scrollPane.setViewportView(listUpgrades);
		listUpgrades.setModel(listModel);
		JLabel spacer8 = new JLabel("                   ");
		GridBagConstraints gbc_spacer8 = new GridBagConstraints();
		gbc_spacer8.insets = new Insets(0, 0, 5, 0);
		gbc_spacer8.gridx = 0;
		gbc_spacer8.gridy = 5;
		frameShipUpgradeScreen.getContentPane().add(spacer8, gbc_spacer8);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 6;
		frameShipUpgradeScreen.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnConfirm = new JButton("CONFIRM");
		this.btnConfirm = btnConfirm;
		if (getUpgrades().size() == 0) {
			disableConfirm();
		}
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String outComestring = "";
				int upgradeIndex = listUpgrades.getSelectedIndex();
				Item upgrade = getUpgrades().get(upgradeIndex);
				if (game.getShip().canUpgrade(upgrade.getUpgradeType())) {
					switch(upgrade.getUpgradeType()) {
						case BULKHEAD:
							game.getShip().upgradeShipEndurance();
							outComestring = ("A bulkhead upgrade was added.");
							break;
						case MAST:
							game.getShip().upgradeSailSpeed();
							outComestring = ("A mast upgrade was added.");
							break;
						case CANNON:
							game.getShip().addCannon();
							outComestring = ("A cannon was added.");
							break;
						case CARGO_HOLD:
							game.getShip().upgradeCargoCapacity();
							outComestring = ("A cargo hold upgrade was added.");
					}
					game.getShip().getCurrentCargo().remove(upgrade);
					game.getShip().addReceipt(upgrade);
					refresh(outComestring);
				} else {
					launchUnableToUpgradePopup("Upgrade slot already at maximum.");
				}
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(btnConfirm);
		
		JLabel spacer4 = new JLabel("                   ");
		panel_1.add(spacer4);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(btnBack);
		
		JLabel spacer9 = new JLabel("                   ");
		GridBagConstraints gbc_spacer9 = new GridBagConstraints();
		gbc_spacer9.insets = new Insets(0, 0, 5, 0);
		gbc_spacer9.gridx = 0;
		gbc_spacer9.gridy = 7;
		frameShipUpgradeScreen.getContentPane().add(spacer9, gbc_spacer9);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		frameShipUpgradeScreen.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel spacer = new JLabel("                ");
		panel.add(spacer);
		
		JLabel lblCannons = new JLabel("Number of Cannons: " + game.getShip().getNumberOfCannons() + "/5");
		lblCannons.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblCannons);
		
		JLabel spacer3 = new JLabel("                   ");
		panel.add(spacer3);
		
		JLabel lblMasts = new JLabel("Number of Mast Upgrades: " + game.getShip().getNumberOfMastUpgrades() + "/5");
		lblMasts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblMasts);
		
		JLabel spacer1 = new JLabel("            ");
		panel.add(spacer1);
		
		JLabel lblBulkHead = new JLabel("Number of Bulkhead Upgrades: " + game.getShip().getNumberOfBulkheadUpgrades());
		lblBulkHead.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblBulkHead);
		
		JLabel spacer2 = new JLabel("            ");
		panel.add(spacer2);
		
		JLabel lblCargoHold = new JLabel("Number of Cargo Hold Upgrades: " + game.getShip().getNumberOfCargoHoldUpgrades());
		lblCargoHold.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblCargoHold);
		
		JLabel lblOutcome = new JLabel("");
		this.lblOutcome = lblOutcome;
		lblOutcome.setText(outcome);
		lblOutcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblOutcome = new GridBagConstraints();
		gbc_lblOutcome.gridx = 0;
		gbc_lblOutcome.gridy = 9;
		frameShipUpgradeScreen.getContentPane().add(lblOutcome, gbc_lblOutcome);
	}

}
