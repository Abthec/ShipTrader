package me.charlie.Gui.Main;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;

/**
 * A screen for the player to hire more screw members.
 * 
 * @author charlie
 *
 */
public class CrewHireScreen {

	private JFrame frameCrewHireScreen;
	private GameManager gameManager;
	private Game game;

	/**
	 * Opens a window for the player to hire more crew.
	 * 
	 * @param gameManager controls the launching and closing of the window.
	 * @param game        stores the current Game data.
	 */
	public CrewHireScreen(GameManager gameManager, Game game) {
		this.gameManager = gameManager;
		this.game = game;
		initialize();
		frameCrewHireScreen.setVisible(true);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frameCrewHireScreen.dispose();
	}

	/**
	 * Calls GameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.closeCrewHireScreen(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewHireScreen window = new CrewHireScreen();
					window.frameCrewHireScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrewHireScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCrewHireScreen = new JFrame();
		frameCrewHireScreen.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameCrewHireScreen.setBounds(100, 100, 532, 317);
		frameCrewHireScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		frameCrewHireScreen.getContentPane().setLayout(gridBagLayout);

		JLabel lblWelcome = new JLabel("Welcome To The Sailing Academy.");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 1;
		frameCrewHireScreen.getContentPane().add(lblWelcome, gbc_lblWelcome);

		JLabel lblSpacer1 = new JLabel("                      ");
		GridBagConstraints gbc_lblSpacer1 = new GridBagConstraints();
		gbc_lblSpacer1.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer1.gridx = 0;
		gbc_lblSpacer1.gridy = 2;
		frameCrewHireScreen.getContentPane().add(lblSpacer1, gbc_lblSpacer1);

		JLabel lblAskHire = new JLabel("Would you like to hire a new crew member?");
		lblAskHire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAskHire = new GridBagConstraints();
		gbc_lblAskHire.insets = new Insets(0, 0, 5, 0);
		gbc_lblAskHire.gridx = 0;
		gbc_lblAskHire.gridy = 3;
		frameCrewHireScreen.getContentPane().add(lblAskHire, gbc_lblAskHire);

		JLabel lblSpacer2 = new JLabel("                      ");
		GridBagConstraints gbc_lblSpacer2 = new GridBagConstraints();
		gbc_lblSpacer2.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer2.gridx = 0;
		gbc_lblSpacer2.gridy = 4;
		frameCrewHireScreen.getContentPane().add(lblSpacer2, gbc_lblSpacer2);

		JLabel lblNewLabel = new JLabel("Crew members wages are 10 coins per day of sailing.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		frameCrewHireScreen.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblSpacer4 = new JLabel("                      ");
		GridBagConstraints gbc_lblSpacer4 = new GridBagConstraints();
		gbc_lblSpacer4.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer4.gridx = 0;
		gbc_lblSpacer4.gridy = 6;
		frameCrewHireScreen.getContentPane().add(lblSpacer4, gbc_lblSpacer4);

		JLabel lblSpeedWarning = new JLabel(
				"If your crew employed is less than half your total crew you will suffer a sailing speed penalty.");
		lblSpeedWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSpeedWarning = new GridBagConstraints();
		gbc_lblSpeedWarning.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpeedWarning.gridx = 0;
		gbc_lblSpeedWarning.gridy = 7;
		frameCrewHireScreen.getContentPane().add(lblSpeedWarning, gbc_lblSpeedWarning);

		JLabel lblSpacer6 = new JLabel("                      ");
		GridBagConstraints gbc_lblSpacer6 = new GridBagConstraints();
		gbc_lblSpacer6.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer6.gridx = 0;
		gbc_lblSpacer6.gridy = 8;
		frameCrewHireScreen.getContentPane().add(lblSpacer6, gbc_lblSpacer6);

		JLabel lblCurrentCrew = new JLabel("New label");

		lblCurrentCrew.setText(
				"Current crew size: " + game.getShip().getCurrentCrewSize() + "/" + game.getShip().getMaxCrewSize());

		lblCurrentCrew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCurrentCrew = new GridBagConstraints();
		gbc_lblCurrentCrew.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentCrew.gridx = 0;
		gbc_lblCurrentCrew.gridy = 9;
		frameCrewHireScreen.getContentPane().add(lblCurrentCrew, gbc_lblCurrentCrew);

		JLabel lblSpacer5 = new JLabel("                      ");
		GridBagConstraints gbc_lblSpacer5 = new GridBagConstraints();
		gbc_lblSpacer5.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer5.gridx = 0;
		gbc_lblSpacer5.gridy = 10;
		frameCrewHireScreen.getContentPane().add(lblSpacer5, gbc_lblSpacer5);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 11;
		frameCrewHireScreen.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnHire = new JButton("HIRE?");
		btnHire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(game.getShip().getCrewFullness() == 1)) {
					game.getShip().hireCrewMember();
					lblCurrentCrew.setText("Current crew size: " + game.getShip().getCurrentCrewSize() + "/"
							+ game.getShip().getMaxCrewSize());
					if (game.getShip().getCrewFullness() == 1) {
						btnHire.setEnabled(false);
					}
				}
			}
		});
		btnHire.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnHire);

		JLabel lblSpacer3 = new JLabel("                      ");
		panel.add(lblSpacer3);

		JButton btnLeave = new JButton("LEAVE");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnLeave.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnLeave);
	}

}
