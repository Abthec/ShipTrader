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

import DiceGame.DiceGameManager;

public class PiratesEventScreen {

	private JFrame framePirateEventScreen;
	private GameManager gameManager;
	private Game game;
	private Route route;
	private DiceGameManager diceGameManager;
	private Trader trader;
	
	public PiratesEventScreen(GameManager gameManager, Game game, Route route) {
		this.game = game;
		this.gameManager = gameManager;
		this.route = route;
		this.trader = game.getTrader();
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
	public void launchDiceGame() {
		DiceGameManager diceGame = new DiceGameManager(20);
		this.diceGameManager = diceGame;
		diceGameManager.launchDiceGameRulesWindow();
		int penalty = diceGame.getPenalty();
		trader.subtractMoney(penalty);
		finishedWindow();
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
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framePirateEventScreen.setVisible(false);
				launchDiceGame();
			}
		});
		framePirateEventScreen.getContentPane().setLayout(new MigLayout("", "[85px,grow]", "[grow][23px]"));
		
		JTextPane introduction = new JTextPane();
		framePirateEventScreen.getContentPane().add(introduction, "cell 0 0,alignx center,aligny center");
		framePirateEventScreen.getContentPane().add(btnContinue, "cell 0 1,alignx center,aligny center");
		introduction.setEditable(false);
		introduction.setText("Youve been boarded by pirates, youll have to beat them in a dice game to protect your inventory!");
	}

}
