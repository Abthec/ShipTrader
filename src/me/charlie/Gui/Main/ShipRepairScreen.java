package me.charlie.Gui.Main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Gui.Popups.UnableToRepairPopup;
import me.charlie.Ship.Ship;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShipRepairScreen {

	private JFrame frameShipRepairScreen;
	private GameManager gameManager;
	private Game game;
	
	/**
	 * Constructs an instance of ShipRepairScreen, initializing the GUI component.
	 * 
	 * @param gameManager an instance of GameManager which is used to control the game
	 * @param game an instance of the Game where all the game data is saved
	 */
	public ShipRepairScreen(GameManager gameManager, Game game) {
		this.gameManager = gameManager;
		this.game = game;
		initialize();
		frameShipRepairScreen.setVisible(true);
	}
	
	/**
	 * Closes the window by terminating the instance of the frame.
	 */
	public void closeWindow() {
		frameShipRepairScreen.dispose();
	}
	
	/**
	 * Calls the closeShipRepair() function from GameManager.
	 * This calls closeWindow() and launches ActivitySelectorScreen.
	 */
	public void finishedWindow() {
		gameManager.closeShipRepairScreen(this);
	}
	
	/**
	 * Launches a popup denying the repair attempt.
	 * 
	 * @param reason the reason the repair was unable to proceed.
	 */
	public void launchUnableToRepairPopup(String reason) {
		UnableToRepairPopup unableToRepairPopup = new UnableToRepairPopup(this, reason);
	}
	
    public int getFullRepairCost() {
    	Ship ship = game.getShip();
        double eachRepair = ship.getShipEndurance()/10;
        double healthMissing = ship.getShipEndurance() - ship.getShipHealth();
        int numberOfRepairs = (int) Math.ceil(healthMissing / eachRepair);
        int fullRepairCost = numberOfRepairs * 100;
        return fullRepairCost;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipRepairScreen window = new ShipRepairScreen();
					window.frameShipRepairScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShipRepairScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameShipRepairScreen = new JFrame();
		frameShipRepairScreen.setBounds(100, 100, 396, 239);
		frameShipRepairScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frameShipRepairScreen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome To The Ship Repairer.");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 1;
		frameShipRepairScreen.getContentPane().add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblSpacer2 = new JLabel("                                                          ");
		GridBagConstraints gbc_lblSpacer2 = new GridBagConstraints();
		gbc_lblSpacer2.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer2.gridx = 0;
		gbc_lblSpacer2.gridy = 2;
		frameShipRepairScreen.getContentPane().add(lblSpacer2, gbc_lblSpacer2);
		
		JLabel lblCurrentShipHealth = new JLabel("New label");
		
		lblCurrentShipHealth.setText("Current ship health: " + game.getShip().getShipHealth() + "/" + game.getShip().getShipEndurance() + ".");
		
		lblCurrentShipHealth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCurrentShipHealth = new GridBagConstraints();
		gbc_lblCurrentShipHealth.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentShipHealth.gridx = 0;
		gbc_lblCurrentShipHealth.gridy = 3;
		frameShipRepairScreen.getContentPane().add(lblCurrentShipHealth, gbc_lblCurrentShipHealth);
		
		JLabel lblSpacer4 = new JLabel("                                                          ");
		GridBagConstraints gbc_lblSpacer4 = new GridBagConstraints();
		gbc_lblSpacer4.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer4.gridx = 0;
		gbc_lblSpacer4.gridy = 4;
		frameShipRepairScreen.getContentPane().add(lblSpacer4, gbc_lblSpacer4);
		
		JLabel lblRepairCost = new JLabel("New label");
		
		lblRepairCost.setText("Cost to repair: " + getFullRepairCost() + " coins.");
		
		lblRepairCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRepairCost = new GridBagConstraints();
		gbc_lblRepairCost.insets = new Insets(0, 0, 5, 0);
		gbc_lblRepairCost.gridx = 0;
		gbc_lblRepairCost.gridy = 5;
		frameShipRepairScreen.getContentPane().add(lblRepairCost, gbc_lblRepairCost);
		
		JLabel lblSpacer3 = new JLabel("                                                          ");
		GridBagConstraints gbc_lblSpacer3 = new GridBagConstraints();
		gbc_lblSpacer3.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer3.gridx = 0;
		gbc_lblSpacer3.gridy = 6;
		frameShipRepairScreen.getContentPane().add(lblSpacer3, gbc_lblSpacer3);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		frameShipRepairScreen.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnRepair = new JButton("REPAIR");
		btnRepair.addActionListener(new ActionListener() {
			/**
			 * Attemtps a repair
			 */
			public void actionPerformed(ActionEvent e) {
				if (game.getTrader().getMoney() < getFullRepairCost()) {
					launchUnableToRepairPopup("You cannot afford the cost to repair.");
				} else {
					game.getTrader().subtractMoney(getFullRepairCost());
					game.getShip().repairFull();
					btnRepair.setEnabled(false);
					lblCurrentShipHealth.setText("Current ship health: " + game.getShip().getShipHealth() + "/" + game.getShip().getShipEndurance() + ".");
					lblRepairCost.setText("Cost to repair: " + getFullRepairCost() + " coins.");
				}
			}
		});
		btnRepair.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnRepair);
		
		JLabel lblSpacer1 = new JLabel("                                                          ");
		panel.add(lblSpacer1);
		
		JButton btnLeave = new JButton("LEAVE");
		btnLeave.addActionListener(new ActionListener() {
			/**
			 * Calls finishedWindow() to go back to ActivitySelector.
			 */
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnLeave.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnLeave);
	}

}
