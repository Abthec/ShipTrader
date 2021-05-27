package DiceGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import me.charlie.Game.DiceGame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** displays a window showing the players last roll and their total score when they win the game
 * when the button is clicked the game carries on and they arrive at their destination
 * @author Josef
 */
public class DiceGameVictoryWindow {

	private JFrame victoryFrame;
	private DiceGameManager diceGameManager;
	private DiceGame diceGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceGameVictoryWindow window = new DiceGameVictoryWindow();
					window.victoryFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiceGameVictoryWindow(DiceGameManager diceGameManager, DiceGame diceGame) {
		this.diceGameManager = diceGameManager;
		this.diceGame = diceGame;
		initialize();
		victoryFrame.setVisible(true);
	}

	public DiceGameVictoryWindow() {
		initialize();
	}

	public void closeWindow() {
		victoryFrame.dispose();
	}

	private String makeSummary() {
		int[] dice = diceGame.getDice();
		int score = diceGameManager.getPlayerScore();
		String summary = String.format("Congratulations your last roll of %d, %d gave you a total score of %d."
				+ "\nThe pirates are retreating", dice[0], dice[1], score);
		return summary;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		victoryFrame = new JFrame();
		victoryFrame.setBounds(100, 100, 450, 300);
		victoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		victoryFrame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][]"));

		JTextPane summaryPane = new JTextPane();
		victoryFrame.getContentPane().add(summaryPane, "cell 0 0,alignx center,aligny center");
		summaryPane.setEditable(false);
		summaryPane.setText(makeSummary());

		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceGameManager.closeVictoryWindow();
			}
		});
		victoryFrame.getContentPane().add(btnNewButton, "cell 0 1,alignx center,aligny center");
	}

}
