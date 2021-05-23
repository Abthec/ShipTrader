package me.charlie.Gui.Main.Travel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Island.Route;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

public class ArrivalScreen {

	private JFrame frameArrivalScreen;
	private GameManager gameManager;
	private Route route;
	
	public ArrivalScreen(GameManager gameManager, Route route, Game game) {
		this.gameManager = gameManager;
		this.route = route;
		initialize();
		frameArrivalScreen.setVisible(true);
	}
	
	public void closeWindow() {
		frameArrivalScreen.dispose();
		initialize();
		frameArrivalScreen.setVisible(true);
	}
	
	public void finishedWindow() {
		gameManager.closeArrivalScreen(this);
	}
	
	public JFrame getJFrame() {
		return frameArrivalScreen;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrivalScreen window = new ArrivalScreen();
					window.frameArrivalScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArrivalScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameArrivalScreen = new JFrame();
		frameArrivalScreen.setBounds(100, 100, 738, 484);
		frameArrivalScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frameArrivalScreen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome to");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcome.setText("Welcome to <dynamic>. Enjoy your stay!");
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 0, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 1;
		frameArrivalScreen.getContentPane().add(lblWelcome, gbc_lblWelcome);
	}

}
