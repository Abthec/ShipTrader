package DiceGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/** lets the player know that they rolled a one, they got zero points for their turn and its now the pirates turn
 * @author Josef
 *
 */
public class RolledOneWindow {

	private JFrame rolledOneFrame;
	private DiceGameManager diceGameManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RolledOneWindow window = new RolledOneWindow();
					window.rolledOneFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RolledOneWindow(DiceGameManager diceGameManager) {
		this.diceGameManager = diceGameManager;
		initialize();
		rolledOneFrame.setVisible(true);
	}
	public RolledOneWindow() {
		initialize();
	}
	public void closeWindow() {
		rolledOneFrame.dispose();
	}
	private String makeSummary() {
		int score = diceGameManager.getPlayerScore();
		String summary = String.format("You rolled a one, your last turn doesnt count and your turn is over."+
				"\nYour score for this turn is zero"+
				"\nYour total score is %d"+
				"\nThe Pirates will now have their turn.", score);
		return summary;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rolledOneFrame = new JFrame();
		rolledOneFrame.setBounds(100, 100, 450, 300);
		rolledOneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rolledOneFrame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JTextPane summary = new JTextPane();
		rolledOneFrame.getContentPane().add(summary, "cell 0 0,alignx center,aligny center");
		summary.setEditable(false);
		summary.setText(makeSummary());
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diceGameManager.closeRolledOneWindow();
			}
		});
		rolledOneFrame.getContentPane().add(btnNewButton, "cell 0 1,alignx center,aligny center");
	}

}
