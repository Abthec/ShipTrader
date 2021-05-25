package DiceGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PirateSummaryWindow {

	private JFrame summaryFrame;
	private DiceGameManager diceGameManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PirateSummaryWindow window = new PirateSummaryWindow();
					window.summaryFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PirateSummaryWindow(DiceGameManager diceGameManager) {
		this.diceGameManager = diceGameManager;
		initialize();
		summaryFrame.setVisible(true);
	}
	public PirateSummaryWindow() {
		initialize();
	}
	public void closeWindow() {
		summaryFrame.dispose();
	}
	private String makeSummary() {
		String result = String.format("The pirates have had their turn and now have %o points" , diceGameManager.getPirateScore());
		return result;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		summaryFrame = new JFrame();
		summaryFrame.setBounds(100, 100, 450, 300);
		summaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		summaryFrame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][][]"));
		
		JTextPane summaryText = new JTextPane();
		summaryFrame.getContentPane().add(summaryText, "cell 0 0,grow");
		summaryText.setEditable(false);
		summaryText.setText(makeSummary());
		
		JLabel lblNewLabel = new JLabel("Ready to take your turn?");
		summaryFrame.getContentPane().add(lblNewLabel, "cell 0 1,alignx center,aligny center");
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceGameManager.closePirateSummaryWindow();
			}
		});
		summaryFrame.getContentPane().add(btnNewButton, "cell 0 2,alignx center");
	}

}