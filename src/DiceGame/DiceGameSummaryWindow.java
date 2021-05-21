package DiceGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiceGameSummaryWindow {

	private JFrame summaryFrame;
	private DiceGameManager diceGameManager;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceGameSummaryWindow window = new DiceGameSummaryWindow(null);
					window.summaryFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param diceGameManager 
	 */
	public DiceGameSummaryWindow(DiceGameManager diceGameManager) {
		this.diceGameManager = diceGameManager;
		initialize();
		summaryFrame.setVisible(true);
	}
	public void closeWindow() {
		summaryFrame.dispose();
	}
	public void finishedWindow() {
		 diceGameManager.closeSummaryWindow(this);
	}
	
	public String getSummary() {
		int playerScore = diceGameManager.getPlayerScore();
		int playerTurn = diceGameManager.getPlayerTurnScore();
		int pirateScore = diceGameManager.getPirateScore();
		String summary = String.format("Your current score total is %o and your turn score is %o."
				+ " The pirates have a score %o" , playerScore, playerTurn, pirateScore );
		return summary;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		summaryFrame = new JFrame();
		summaryFrame.setBounds(100, 100, 450, 300);
		summaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		summaryFrame.getContentPane().setLayout(new MigLayout("", "[][grow][]", "[grow][][]"));
		
		JTextPane Summary = new JTextPane();
		summaryFrame.getContentPane().add(Summary, "cell 1 0,grow");
		Summary.setEditable(false);
		Summary.setText(getSummary());
		
		JLabel lblNewLabel = new JLabel("Do you want to roll?");
		summaryFrame.getContentPane().add(lblNewLabel, "cell 1 1,alignx center");
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			diceGameManager.rollDice();}
		});
		summaryFrame.getContentPane().add(btnNewButton, "cell 0 2");
		
		JButton btnNewButton_1 = new JButton("No");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			diceGameManager.passTurn();}
		});
		summaryFrame.getContentPane().add(btnNewButton_1, "cell 2 2");
	}

}
