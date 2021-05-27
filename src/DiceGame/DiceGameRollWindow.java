package DiceGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import me.charlie.Game.DiceGame;
import net.miginfocom.swing.MigLayout;

<<<<<<< HEAD
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

/** Creates a summary of the players last roll, current turn value, current total score and pirates current total score
 * Provides options to the player to lock in their current turn score or roll again
 * @author Josef
=======
/**
 * Displayed during the players turn and informs them of their rolls.
 * 
 * @author josef
>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
 *
 */
public class DiceGameRollWindow {

	private JFrame rollFrame;
	private DiceGameManager diceGameManager;
	private DiceGame diceGame;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceGameRollWindow window = new DiceGameRollWindow();
					window.rollFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param diceGameManager
	 * @param diceGame
	 */
	DiceGameRollWindow(DiceGameManager diceGameManager, DiceGame diceGame) {
		this.diceGameManager = diceGameManager;
		this.diceGame = diceGame;
		initialize();
		rollFrame.setVisible(true);
	}
<<<<<<< HEAD
	/** create the application
	 */
	DiceGameRollWindow(){
=======

	DiceGameRollWindow() {
>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
		initialize();
	}
<<<<<<< HEAD
	/**close the window
	 */
=======

>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
	public void closeWindow() {
		rollFrame.dispose();
	}
<<<<<<< HEAD
	/** creates and returns a string to be displayed to the player
	 * the string 
	 * @return summary, the string to be displayed
	 */
=======

>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
	private String makeSummary() {
		int[] dice = diceGame.getDice();
		int pirateScore = diceGameManager.getPirateScore();
		int playerScore = diceGameManager.getPlayerScore();
		int turnScore = diceGameManager.getPlayerTurnScore();
		String summary = String.format("Your last role was %d, %d."
				+ "\nYour current score total is %d and your turn score is %d." + "\nThe pirates have a score of %d",
				dice[0], dice[1], playerScore, turnScore, pirateScore);
		return summary;
	}
<<<<<<< HEAD
	/** calls to the reRoll function in diceGameManager
	*/
=======

>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
	public void reRoll() {
		diceGameManager.reRoll();
	}
<<<<<<< HEAD
	/** calls to the passTurn in diceGameManager
	 */
=======

>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
	public void passTurn() {
		diceGameManager.passTurn();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rollFrame = new JFrame();
		rollFrame.setBounds(100, 100, 450, 300);
		rollFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rollFrame.getContentPane().setLayout(new MigLayout("", "[][grow][]", "[grow][][]"));

		JTextPane summaryPane = new JTextPane();
		rollFrame.getContentPane().add(summaryPane, "cell 1 0,grow");
		summaryPane.setEditable(false);
		summaryPane.setText(makeSummary());

		JLabel lblNewLabel = new JLabel("Roll again?");
		rollFrame.getContentPane().add(lblNewLabel, "cell 1 1,alignx center,aligny center");

		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reRoll();
			}
		});
		rollFrame.getContentPane().add(btnNewButton, "cell 0 2");

		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passTurn();
			}
		});
		rollFrame.getContentPane().add(btnNewButton_1, "cell 2 2");
	}
}
