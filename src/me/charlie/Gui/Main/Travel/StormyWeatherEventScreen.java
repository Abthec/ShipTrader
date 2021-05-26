package me.charlie.Gui.Main.Travel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Island.Route;
import me.charlie.RandomEvents.RandomEvent;
import me.charlie.RandomEvents.RandomEventType;
import me.charlie.Ship.Ship;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.util.Random;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StormyWeatherEventScreen {

	private JFrame frameStormyWeatherEventScreen;
	private GameManager gameManager;
	private Route route;
	private RandomEvent randomEvent;
	private Random random = new Random();
	private Game game;
	private Ship ship;
	
	/**
	 * Creates a StormyWeatherEventScreen.
	 * 
	 * @param gameManager controls the launching and closing of the event.
	 * @param route the Route on which the event occurred.
	 * @param game the current instance of the Game.
	 */
	public StormyWeatherEventScreen(GameManager gameManager, Route route, Game game) {
		this.gameManager = gameManager;
		this.route = route;
		this.randomEvent = route.getRandomEvent();
		this.game = game;
		this.ship = game.getShip();
		initialize();
		frameStormyWeatherEventScreen.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frameStormyWeatherEventScreen.dispose();
	}
	
	/**
	 * Calls GameManager to close the window and launch the next window.
	 */
	public void finishedWindow() {
		gameManager.closeStormyWeatherEventScreen(this, route);
	}
	
	/**
	 * 
	 * @return the frame of the current window.
	 */
	public JFrame getJFrame() {
		return frameStormyWeatherEventScreen;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StormyWeatherEventScreen window = new StormyWeatherEventScreen();
					window.frameStormyWeatherEventScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StormyWeatherEventScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameStormyWeatherEventScreen = new JFrame();
		frameStormyWeatherEventScreen.setBounds(100, 100, 496, 324);
		frameStormyWeatherEventScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frameStormyWeatherEventScreen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblStormyEncounterBanner = new JLabel("While you were sailing you encountered (event).");
		lblStormyEncounterBanner.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblStormyEncounterBanner.setText("While you were sailing you encountered " + randomEvent.getRandomEventType().getName() + ".");
		
		GridBagConstraints gbc_lblStormyEncounterBanner = new GridBagConstraints();
		gbc_lblStormyEncounterBanner.insets = new Insets(0, 0, 5, 0);
		gbc_lblStormyEncounterBanner.gridx = 1;
		gbc_lblStormyEncounterBanner.gridy = 1;
		frameStormyWeatherEventScreen.getContentPane().add(lblStormyEncounterBanner, gbc_lblStormyEncounterBanner);
		
		JLabel lblSpacer1 = new JLabel("   ");
		GridBagConstraints gbc_lblSpacer1 = new GridBagConstraints();
		gbc_lblSpacer1.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer1.gridx = 1;
		gbc_lblSpacer1.gridy = 2;
		frameStormyWeatherEventScreen.getContentPane().add(lblSpacer1, gbc_lblSpacer1);
		
		JLabel lblShipDamage = new JLabel("Your ship took (damage) damage.");
		double healthRemoved = 25 + random.nextInt(25);
        ship.removeShipHealth(healthRemoved);
		
		lblShipDamage.setText("Your ship took " + healthRemoved + " damage.");
		
		lblShipDamage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblShipDamage = new GridBagConstraints();
		gbc_lblShipDamage.insets = new Insets(0, 0, 5, 0);
		gbc_lblShipDamage.gridx = 1;
		gbc_lblShipDamage.gridy = 3;
		frameStormyWeatherEventScreen.getContentPane().add(lblShipDamage, gbc_lblShipDamage);
		
		JLabel lblSpacer2 = new JLabel("   ");
		GridBagConstraints gbc_lblSpacer2 = new GridBagConstraints();
		gbc_lblSpacer2.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer2.gridx = 1;
		gbc_lblSpacer2.gridy = 4;
		frameStormyWeatherEventScreen.getContentPane().add(lblSpacer2, gbc_lblSpacer2);
		
		JLabel lblHealthRemaining = new JLabel("HealthRemaining");
		
		lblHealthRemaining.setText("Your ship has " + ship.getShipHealth() + "/" + ship.getShipEndurance() + " health remaining");
		
		lblHealthRemaining.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblHealthRemaining = new GridBagConstraints();
		gbc_lblHealthRemaining.insets = new Insets(0, 0, 5, 0);
		gbc_lblHealthRemaining.gridx = 1;
		gbc_lblHealthRemaining.gridy = 5;
		frameStormyWeatherEventScreen.getContentPane().add(lblHealthRemaining, gbc_lblHealthRemaining);
		
		JLabel lblSpacer4 = new JLabel("   ");
		GridBagConstraints gbc_lblSpacer4 = new GridBagConstraints();
		gbc_lblSpacer4.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer4.gridx = 1;
		gbc_lblSpacer4.gridy = 6;
		frameStormyWeatherEventScreen.getContentPane().add(lblSpacer4, gbc_lblSpacer4);
		
		JLabel lblRepairInstruction = new JLabel("You will need to repair before you can set sail again.");
		lblRepairInstruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRepairInstruction = new GridBagConstraints();
		gbc_lblRepairInstruction.insets = new Insets(0, 0, 5, 0);
		gbc_lblRepairInstruction.gridx = 1;
		gbc_lblRepairInstruction.gridy = 7;
		frameStormyWeatherEventScreen.getContentPane().add(lblRepairInstruction, gbc_lblRepairInstruction);
		
		JLabel lblSpacer3 = new JLabel("   ");
		GridBagConstraints gbc_lblSpacer3 = new GridBagConstraints();
		gbc_lblSpacer3.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer3.gridx = 1;
		gbc_lblSpacer3.gridy = 8;
		frameStormyWeatherEventScreen.getContentPane().add(lblSpacer3, gbc_lblSpacer3);
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.insets = new Insets(0, 0, 5, 0);
		gbc_btnContinue.gridx = 1;
		gbc_btnContinue.gridy = 9;
		frameStormyWeatherEventScreen.getContentPane().add(btnContinue, gbc_btnContinue);
	}

}
