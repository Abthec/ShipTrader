package me.charlie.Gui.Main.Travel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Island.Route;
import me.charlie.Trader.Trader;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PiratesEventScreen {

	private JFrame framePirateEventScreen;
	private GameManager gameManager;
	private Route route;
	
	/**
	 * Creates a PirateEventScreen.
	 * 
	 * @param gameManager controls the PirateEvent
	 * @param route the Route on which the event occurred.
	 */
	public PiratesEventScreen(GameManager gameManager, Route route) {
		this.gameManager = gameManager;
		this.route = route;
		initialize();
		framePirateEventScreen.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		framePirateEventScreen.dispose();
	}
	
	/**
	 * Calls gameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.closePiratesEventScreen(this, route);
	}
	
	/**
	 * 
	 * @return the frame of the current window.
	 */
	public JFrame getJFrame() {
		return framePirateEventScreen;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
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
		framePirateEventScreen.setBounds(100, 100, 630, 241);
		framePirateEventScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		framePirateEventScreen.getContentPane().setLayout(new MigLayout("", "[85px,grow]", "[grow][23px]"));
		
		JLabel lblNewLabel = new JLabel("You have been boarded by pirates! You will have to beat them in a game to deter them.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		framePirateEventScreen.getContentPane().add(lblNewLabel, "cell 0 0");
		framePirateEventScreen.getContentPane().add(btnContinue, "cell 0 1,alignx center,aligny center");
	}

}
