package me.charlie.Gui.gameSetup;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;

import java.awt.Font;
import java.awt.Window.Type;

@SuppressWarnings("unused")
public class ActivitySelectorScreen {

	private JFrame frameActivitySelector;
	private GameManager gameManager;
	Game game;
	
	public ActivitySelectorScreen(GameManager gameManager, Game game) {
		this.gameManager = gameManager;
		this.game = game;
		initialize();
		frameActivitySelector.setVisible(true);
	}
	
	public void closeWindow() {
		frameActivitySelector.dispose();
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
		btnSail.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnSail);
		
		JButton btnVisitStore = new JButton("    Visit the store    ");
		btnVisitStore.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnVisitStore);
		
		JButton btnHireCrew = new JButton("    Hire more crew members    ");
		btnHireCrew.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnHireCrew);
		
		JButton btnRepairShip = new JButton("    Repair your ship    ");
		btnRepairShip.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnRepairShip);
		
		JButton btnViewProperties = new JButton("    View your ship's properties    ");
		btnViewProperties.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnViewProperties);
		
		JButton btnUpgradeShip = new JButton("    Upgrade your ship    ");
		btnUpgradeShip.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameActivitySelector.getContentPane().add(btnUpgradeShip);
		
		JLabel lblPlayerCash = new JLabel("Current Wallet:");
		lblPlayerCash.setText("Current Wallet : " + game.getTrader().getMoney());
		lblPlayerCash.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameActivitySelector.getContentPane().add(lblPlayerCash);
	}

}
