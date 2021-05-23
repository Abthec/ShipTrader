package me.charlie.Gui.Main.Travel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Island.Route;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PiratesEventScreen {

	private JFrame framePirateEventScreen;
	private GameManager gameManager;
	private Game game;
	private Route route;
	
	public PiratesEventScreen(GameManager gameManager, Game game, Route route) {
		this.game = game;
		this.gameManager = gameManager;
		this.route = route;
		initialize();
		framePirateEventScreen.setVisible(true);
	}
	
	public void closeWindow() {
		framePirateEventScreen.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closePiratesEventScreen(this, route);
	}
	
	public JFrame getJFrame() {
		return framePirateEventScreen;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PiratesEventScreen window = new PiratesEventScreen();
					window.framePirateEventScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PiratesEventScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framePirateEventScreen = new JFrame();
		framePirateEventScreen.setBounds(100, 100, 560, 450);
		framePirateEventScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		framePirateEventScreen.getContentPane().setLayout(gridBagLayout);
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.gridx = 1;
		gbc_btnContinue.gridy = 12;
		framePirateEventScreen.getContentPane().add(btnContinue, gbc_btnContinue);
	}

}
