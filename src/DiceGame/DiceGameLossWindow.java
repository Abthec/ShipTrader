package DiceGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiceGameLossWindow {

	private JFrame lossFrame;
	private DiceGameManager diceGameManager;
	private int penalty;

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
	private String makeSummary() {
		diceGameManager.makePenalty();
		String summary = String.format("You lost the pirates are taking %o gold, if you cant afford this you lose!", diceGameManager.getPenalty());
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
				diceGameManager.closeLossWindow();
			}
		});
		lossFrame.getContentPane().add(btnNewButton, "cell 0 1,alignx center");
	}

}
