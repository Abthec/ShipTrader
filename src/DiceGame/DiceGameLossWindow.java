package DiceGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
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
 *
 */
public class DiceGameLossWindow {

	private JFrame lossFrame;
	private DiceGameManager diceGameManager;

	/**
	 * Launch the application.
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

	public DiceGameLossWindow(DiceGameManager diceGameManager) {
		this.diceGameManager = diceGameManager;
		initialize();
		lossFrame.setVisible(true);
	}

	public void closeWindow() {
		lossFrame.dispose();
	}

	public void finishedWindow() {
		diceGameManager.closeLossWindow(this);
	}

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
