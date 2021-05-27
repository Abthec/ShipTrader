package me.charlie.Gui.gameSetup;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import me.charlie.Gui.GameManager;

/**
 * Opens when game starts. A screen to get the players name and desired game
 * duration.
 * 
 * @author charlie
 *
 */
public class StartupScreen {

	private JFrame frmIslandTraderSetup;
	private JTextField textFieldTraderName;
	private GameManager gameManager;
	private String traderName;
	private int gameDuration;

	/**
	 * Creates the first screen for the Game, to get a trader name and game
	 * duration.
	 * 
	 * @param gameManager controls the launching and closing of the window.
	 */
	public StartupScreen(GameManager gameManager) {
		this.gameManager = gameManager;
		initialize();
		frmIslandTraderSetup.setVisible(true);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frmIslandTraderSetup.dispose();
	}

	/**
	 * Calls gameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.closeStartupScreen(this);
	}

	/**
	 * 
	 * @return the frame of the current window.
	 */
	public JFrame getSetupJFrame() {
		return frmIslandTraderSetup;
	}

	/**
	 * 
	 * @return the name entered by the player.
	 */
	public String getTraderName() {
		return traderName;
	}

	/**
	 * 
	 * @return the duration selected by the player.
	 */
	public int getGameDuration() {
		return gameDuration;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIslandTraderSetup = new JFrame();
		frmIslandTraderSetup.setTitle("Island Trader Setup");
		frmIslandTraderSetup.setBounds(100, 100, 580, 361);
		frmIslandTraderSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		frmIslandTraderSetup.getContentPane().setLayout(gridBagLayout);

		JLabel lblWelcomeMessage = new JLabel("Welcome to Island Trader!");
		lblWelcomeMessage.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblWelcomeMessage = new GridBagConstraints();
		gbc_lblWelcomeMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcomeMessage.gridx = 2;
		gbc_lblWelcomeMessage.gridy = 1;
		frmIslandTraderSetup.getContentPane().add(lblWelcomeMessage, gbc_lblWelcomeMessage);

		JLabel spacer1 = new JLabel(" ");
		GridBagConstraints gbc_spacer1 = new GridBagConstraints();
		gbc_spacer1.insets = new Insets(0, 0, 5, 5);
		gbc_spacer1.gridx = 3;
		gbc_spacer1.gridy = 2;
		frmIslandTraderSetup.getContentPane().add(spacer1, gbc_spacer1);

		JLabel lblEnterTraderName = new JLabel("Enter Trader Name:");
		lblEnterTraderName.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblEnterTraderName = new GridBagConstraints();
		gbc_lblEnterTraderName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterTraderName.gridx = 2;
		gbc_lblEnterTraderName.gridy = 3;
		frmIslandTraderSetup.getContentPane().add(lblEnterTraderName, gbc_lblEnterTraderName);

		textFieldTraderName = new JTextField();
		GridBagConstraints gbc_textFieldTraderName = new GridBagConstraints();
		gbc_textFieldTraderName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTraderName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTraderName.gridx = 3;
		gbc_textFieldTraderName.gridy = 4;
		frmIslandTraderSetup.getContentPane().add(textFieldTraderName, gbc_textFieldTraderName);
		textFieldTraderName.setColumns(10);

		JLabel lblTraderNameConstraints = new JLabel("(3-15 Alphabetic Characters)");
		GridBagConstraints gbc_lblTraderNameConstraints = new GridBagConstraints();
		gbc_lblTraderNameConstraints.insets = new Insets(0, 0, 5, 5);
		gbc_lblTraderNameConstraints.gridx = 2;
		gbc_lblTraderNameConstraints.gridy = 5;
		frmIslandTraderSetup.getContentPane().add(lblTraderNameConstraints, gbc_lblTraderNameConstraints);

		JLabel spacer2 = new JLabel(" ");
		GridBagConstraints gbc_spacer2 = new GridBagConstraints();
		gbc_spacer2.insets = new Insets(0, 0, 5, 5);
		gbc_spacer2.gridx = 3;
		gbc_spacer2.gridy = 6;
		frmIslandTraderSetup.getContentPane().add(spacer2, gbc_spacer2);

		JLabel lblSelectGameDuration = new JLabel("Select Game Duration:");
		lblSelectGameDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblSelectGameDuration = new GridBagConstraints();
		gbc_lblSelectGameDuration.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectGameDuration.gridx = 2;
		gbc_lblSelectGameDuration.gridy = 7;
		frmIslandTraderSetup.getContentPane().add(lblSelectGameDuration, gbc_lblSelectGameDuration);

		JSlider sliderGameDuration = new JSlider();
		sliderGameDuration.setSnapToTicks(true);
		sliderGameDuration.setPaintTicks(true);
		sliderGameDuration.setPaintLabels(true);
		sliderGameDuration.setValue(35);
		sliderGameDuration.setMinorTickSpacing(1);
		sliderGameDuration.setMinimum(20);
		sliderGameDuration.setMaximum(50);
		sliderGameDuration.setMajorTickSpacing(5);
		GridBagConstraints gbc_sliderGameDuration = new GridBagConstraints();
		gbc_sliderGameDuration.insets = new Insets(0, 0, 5, 5);
		gbc_sliderGameDuration.gridx = 3;
		gbc_sliderGameDuration.gridy = 8;
		frmIslandTraderSetup.getContentPane().add(sliderGameDuration, gbc_sliderGameDuration);

		JLabel lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 9;
		frmIslandTraderSetup.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblGameDurationConstraints = new JLabel("(20-50 Days)");
		GridBagConstraints gbc_lblGameDurationConstraints = new GridBagConstraints();
		gbc_lblGameDurationConstraints.insets = new Insets(0, 0, 5, 5);
		gbc_lblGameDurationConstraints.gridx = 2;
		gbc_lblGameDurationConstraints.gridy = 10;
		frmIslandTraderSetup.getContentPane().add(lblGameDurationConstraints, gbc_lblGameDurationConstraints);

		JLabel spacer3 = new JLabel(" ");
		GridBagConstraints gbc_spacer3 = new GridBagConstraints();
		gbc_spacer3.insets = new Insets(0, 0, 5, 5);
		gbc_spacer3.gridx = 3;
		gbc_spacer3.gridy = 11;
		frmIslandTraderSetup.getContentPane().add(spacer3, gbc_spacer3);

		JButton btnReady = new JButton("READY");
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				traderName = textFieldTraderName.getText();
				gameDuration = sliderGameDuration.getValue();
				if ((traderName.length() < 3 || traderName.length() > 15) || (!traderName.matches("^[a-zA-Z]*$"))) {
					gameManager.launchInvalidTraderNamePopup();
				} else {
					finishedWindow();
				}
			}
		});
		btnReady.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnReady = new GridBagConstraints();
		gbc_btnReady.insets = new Insets(0, 0, 0, 5);
		gbc_btnReady.gridx = 2;
		gbc_btnReady.gridy = 12;
		frmIslandTraderSetup.getContentPane().add(btnReady, gbc_btnReady);
	}

}
