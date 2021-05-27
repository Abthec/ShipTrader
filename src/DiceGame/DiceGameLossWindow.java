package DiceGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
<<<<<<< HEAD
/** The loss window is activated when the pirates win the dice game, it is called from diceGameManager
 * @author Josef
=======
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import net.miginfocom.swing.MigLayout;

/**
 * A screen to let the player know they lost the dice game and their penalty or
 * losing.
 * 
 * @author josef
>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
 *
 */
public class DiceGameLossWindow {

	private JFrame lossFrame;
	private DiceGameManager diceGameManager;

	/**
	 * Launches the application
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceGameLossWindow window = new DiceGameLossWindow();
					window.lossFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiceGameLossWindow() {
		initialize();
	}
<<<<<<< HEAD
	/**
	 * Create the application.
	 * @param diceGameManager instance that this window belongs to
	 */
=======

>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
	public DiceGameLossWindow(DiceGameManager diceGameManager) {
		this.diceGameManager = diceGameManager;
		initialize();
		lossFrame.setVisible(true);
	}
<<<<<<< HEAD
	/** closes the window
	 */
=======

>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
	public void closeWindow() {
		lossFrame.dispose();
	}
<<<<<<< HEAD
	/**calls back to the manager to close the window
	 */
=======

>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
	public void finishedWindow() {
		diceGameManager.closeLossWindow(this);
	}
<<<<<<< HEAD
	/** generates a string which is a summary of the what happened and the penalty
	 * @return summary, the string to be displayed in the window
	 */
=======

>>>>>>> branch 'master' of https://github.com/Abthec/ShipTrader.git
	private String makeSummary() {
		diceGameManager.makePenalty();
		String summary = String.format(
				"You lost the pirates are taking your items, if they aren't satisfied they'll make you walk the plank!",
				diceGameManager.getPenalty());
		return summary;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lossFrame = new JFrame();
		lossFrame.setBounds(100, 100, 569, 395);
		lossFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lossFrame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][]"));

		JTextPane lossPane = new JTextPane();
		lossFrame.getContentPane().add(lossPane, "cell 0 0,alignx center,aligny center");
		lossPane.setEditable(false);
		lossPane.setText(makeSummary());

		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		lossFrame.getContentPane().add(btnNewButton, "cell 0 1,alignx center");
	}

}
