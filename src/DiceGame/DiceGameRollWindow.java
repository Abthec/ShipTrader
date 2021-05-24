package DiceGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;

import me.charlie.Game.DiceGame;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class DiceGameRollWindow {

	private JFrame rollFrame;
	private DiceGameManager diceGameManager;
	private DiceGame diceGame;

	/**
	 * Launch the application.
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
	DiceGameRollWindow(){
		initialize();
	}
	/**
	 * Create the application.
	 * @param diceGameManager 
	 */
	public DiceGameRollWindow(DiceGameManager diceGameManager) {
		this.diceGameManager = diceGameManager;
		initialize();
		rollFrame.setVisible(true);
	}
	public void closeWindow() {
		rollFrame.dispose();
	}
	private String makeSummary() {
		int[] dice = diceGame.getDice();
		int playerScore = diceGameManager.getPlayerScore();
		int playerTurn = diceGameManager.getPlayerTurnScore();
		int pirateScore = diceGameManager.getPirateScore();
		String summary = String.format("Your last role was %o, %o. Your current score total is %o and your turn score is %o."
				+ " The pirates have a score %o" ,dice[0], dice[1], playerScore, playerTurn, pirateScore );
		return summary;
	}
	public void reRoll() {
		diceGameManager.reRoll();
	}
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
				reRoll();}
		});
		rollFrame.getContentPane().add(btnNewButton, "cell 0 2");
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passTurn();}
		});
		rollFrame.getContentPane().add(btnNewButton_1, "cell 2 2");
	}
}
