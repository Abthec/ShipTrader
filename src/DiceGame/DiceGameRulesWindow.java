package DiceGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
<<<<<<< HEAD
/** when the dice game launches this window opens to explain the rules and flow of the game
 * @author Josef
=======
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

/**
 * Informs the player about the rules of the dice game.
 * 
 * @author josef
>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
 *
 */
public class DiceGameRulesWindow {

	private JFrame rulesFrame;
	private DiceGameManager diceGameManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceGameRulesWindow window = new DiceGameRulesWindow();
					window.rulesFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	DiceGameRulesWindow() {
		initialize();
	}

	/**
	 * Create the application.
	 * 
	 * @param diceGameManager
	 */
	public DiceGameRulesWindow(DiceGameManager diceGameManager) {
		this.diceGameManager = diceGameManager;
		initialize();
		rulesFrame.setVisible(true);
	}

	public void closeWindow() {
		rulesFrame.dispose();
	}

	public void finishedWindow() {
		diceGameManager.closeRulesWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rulesFrame = new JFrame();
		rulesFrame.setBounds(100, 100, 450, 300);
		rulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rulesFrame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][]"));

		JButton readybttn = new JButton("Roll");
		readybttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});

		JTextPane Rules = new JTextPane();
		Rules.setEditable(false);
		Rules.setText("The game is snake eyes, you roll two dice and the sum is added you your turn score."
				+ "\nThe aim is to reach 100 points total. If you roll a one your turn is over and you get zero for your turn"
				+ "\nthe pirates then have their turn but if you roll two ones, your score is reset back to zero or your handicap and your turn ends");
		rulesFrame.getContentPane().add(Rules, "cell 0 0,alignx center,aligny center");
		rulesFrame.getContentPane().add(readybttn, "cell 0 1,alignx center");
	}

}
