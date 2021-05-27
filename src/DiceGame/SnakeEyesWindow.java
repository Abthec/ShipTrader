package DiceGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

/** lets the player know they rolled snake eyes, their score has been reset and the turn will pass to the pirates
 * @author Josef
 */
public class SnakeEyesWindow {

	private JFrame snakeEyesFrame;
	private DiceGameManager diceGameManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnakeEyesWindow window = new SnakeEyesWindow();
					window.snakeEyesFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param diceGameManager2
	 */
	public SnakeEyesWindow(DiceGameManager diceGameManager) {
		this.diceGameManager = diceGameManager;
		initialize();
		snakeEyesFrame.setVisible(true);
	}
	/** create the application
	 */
	public SnakeEyesWindow() {
		initialize();
	 }
	/** creates the summary that is displayed to the user
	 * @return String, string that is displayed to the user
	 */
	 private String getSummary() {
		int score =  diceGameManager.getPlayerScore();
		String summary = String.format("You rolled snake eyes so your turn is over and your score has been reset. Your current score is %d"+
		"/nThe pirates will now make their turn" ,score);
		return summary;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		snakeEyesFrame = new JFrame();
		snakeEyesFrame.setBounds(100, 100, 450, 300);
		snakeEyesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		snakeEyesFrame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][]"));

		JTextPane summary = new JTextPane();
		snakeEyesFrame.getContentPane().add(summary, "cell 0 0,alignx center,aligny center");
		summary.setEditable(false);
		summary.setText(getSummary());

		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceGameManager.closeSnakeEyesWindow();
			}
		});
		snakeEyesFrame.getContentPane().add(btnNewButton, "cell 0 1,alignx center");
	}

	public void closeWindow() {
		snakeEyesFrame.dispose();
	}
}
