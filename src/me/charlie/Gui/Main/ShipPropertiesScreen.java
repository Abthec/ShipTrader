package me.charlie.Gui.Main;

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
 * A screen for the player to view the current stats of the ship, also a link to
 * the cargo screen.
 * 
 * @author charlie.
 *
 */
public class ShipPropertiesScreen {

	private JFrame frameShipPropertiesScreen;
	private GameManager gameManager;
	private Game game;

	/**
	 * Opens a window for the player to view their Ship's stats.
	 * 
	 * @param gameManager controls the launching and closing of the window.
	 * @param game        the Game data.
	 */
	public ShipPropertiesScreen(GameManager gameManager, Game game) {
		this.game = game;
		this.gameManager = gameManager;
		initialize();
		frameShipPropertiesScreen.setVisible(true);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frameShipPropertiesScreen.dispose();
	}

	/**
	 * Calls GameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.closeShipPropertiesScreen(this);
	}

	/**
	 * Opens a window for the player to view cargo.
	 */
	public void launchCargoScreen() {
		frameShipPropertiesScreen.setVisible(false);
		new CargoScreen(this, game);
	}

	/**
	 * 
	 * @return the frame of the current window.
	 */
	public JFrame getJFrame() {
		return frameShipPropertiesScreen;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameShipPropertiesScreen = new JFrame();
		frameShipPropertiesScreen.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frameShipPropertiesScreen.setBounds(100, 100, 630, 250);
		frameShipPropertiesScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 313, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		frameShipPropertiesScreen.getContentPane().setLayout(gridBagLayout);

		JLabel lblShipProperties = new JLabel("Ship Properties");
		lblShipProperties.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblShipProperties = new GridBagConstraints();
		gbc_lblShipProperties.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipProperties.gridx = 0;
		gbc_lblShipProperties.gridy = 0;
		frameShipPropertiesScreen.getContentPane().add(lblShipProperties, gbc_lblShipProperties);

		JLabel lblSpacer1_6 = new JLabel("                                 ");
		GridBagConstraints gbc_lblSpacer1_6 = new GridBagConstraints();
		gbc_lblSpacer1_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer1_6.gridx = 2;
		gbc_lblSpacer1_6.gridy = 0;
		frameShipPropertiesScreen.getContentPane().add(lblSpacer1_6, gbc_lblSpacer1_6);

		JLabel lblSpacer1_5 = new JLabel("                                 ");
		GridBagConstraints gbc_lblSpacer1_5 = new GridBagConstraints();
		gbc_lblSpacer1_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer1_5.gridx = 2;
		gbc_lblSpacer1_5.gridy = 1;
		frameShipPropertiesScreen.getContentPane().add(lblSpacer1_5, gbc_lblSpacer1_5);

		JLabel lblShipName = new JLabel("Ship Name:");
		lblShipName.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblShipName = new GridBagConstraints();
		gbc_lblShipName.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipName.gridx = 0;
		gbc_lblShipName.gridy = 2;
		frameShipPropertiesScreen.getContentPane().add(lblShipName, gbc_lblShipName);

		JLabel lblShipNameValue = new JLabel("Ship Name");
		lblShipNameValue.setText(game.getShip().getName());
		lblShipNameValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblShipNameValue = new GridBagConstraints();
		gbc_lblShipNameValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipNameValue.gridx = 1;
		gbc_lblShipNameValue.gridy = 2;
		frameShipPropertiesScreen.getContentPane().add(lblShipNameValue, gbc_lblShipNameValue);

		JLabel lblSpacer1 = new JLabel("                                 ");
		GridBagConstraints gbc_lblSpacer1 = new GridBagConstraints();
		gbc_lblSpacer1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer1.gridx = 2;
		gbc_lblSpacer1.gridy = 2;
		frameShipPropertiesScreen.getContentPane().add(lblSpacer1, gbc_lblSpacer1);

		JLabel lblShipType = new JLabel("Ship Type:");
		lblShipType.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblShipType = new GridBagConstraints();
		gbc_lblShipType.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipType.gridx = 3;
		gbc_lblShipType.gridy = 2;
		frameShipPropertiesScreen.getContentPane().add(lblShipType, gbc_lblShipType);

		JLabel lblShipTypeValue = new JLabel("Ship Type");
		lblShipTypeValue.setText(game.getShip().getShipType().getName());
		lblShipTypeValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblShipTypeValue = new GridBagConstraints();
		gbc_lblShipTypeValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblShipTypeValue.gridx = 4;
		gbc_lblShipTypeValue.gridy = 2;
		frameShipPropertiesScreen.getContentPane().add(lblShipTypeValue, gbc_lblShipTypeValue);

		JLabel lblSpacer1_1 = new JLabel("                                 ");
		GridBagConstraints gbc_lblSpacer1_1 = new GridBagConstraints();
		gbc_lblSpacer1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer1_1.gridx = 2;
		gbc_lblSpacer1_1.gridy = 3;
		frameShipPropertiesScreen.getContentPane().add(lblSpacer1_1, gbc_lblSpacer1_1);

		JLabel lblCrew = new JLabel("Current Crew:");
		lblCrew.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblCrew = new GridBagConstraints();
		gbc_lblCrew.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrew.gridx = 0;
		gbc_lblCrew.gridy = 4;
		frameShipPropertiesScreen.getContentPane().add(lblCrew, gbc_lblCrew);

		JLabel lblCurrentCrewValue = new JLabel("0/0");
		lblCurrentCrewValue.setText(game.getShip().getCurrentCrewSize() + "/" + game.getShip().getMaxCrewSize());
		lblCurrentCrewValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCurrentCrewValue = new GridBagConstraints();
		gbc_lblCurrentCrewValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentCrewValue.gridx = 1;
		gbc_lblCurrentCrewValue.gridy = 4;
		frameShipPropertiesScreen.getContentPane().add(lblCurrentCrewValue, gbc_lblCurrentCrewValue);

		JLabel lblSpacer1_2 = new JLabel("                                 ");
		GridBagConstraints gbc_lblSpacer1_2 = new GridBagConstraints();
		gbc_lblSpacer1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer1_2.gridx = 2;
		gbc_lblSpacer1_2.gridy = 4;
		frameShipPropertiesScreen.getContentPane().add(lblSpacer1_2, gbc_lblSpacer1_2);

		JLabel lblCrewWages = new JLabel("Crew Wages Per Day Sailed:");
		lblCrewWages.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblCrewWages = new GridBagConstraints();
		gbc_lblCrewWages.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrewWages.gridx = 3;
		gbc_lblCrewWages.gridy = 4;
		frameShipPropertiesScreen.getContentPane().add(lblCrewWages, gbc_lblCrewWages);

		JLabel lblCrewWagesValue = new JLabel("69");
		lblCrewWagesValue.setText(String.valueOf(game.getShip().getCurrentCrewSize() * 10));
		lblCrewWagesValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCrewWagesValue = new GridBagConstraints();
		gbc_lblCrewWagesValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblCrewWagesValue.gridx = 4;
		gbc_lblCrewWagesValue.gridy = 4;
		frameShipPropertiesScreen.getContentPane().add(lblCrewWagesValue, gbc_lblCrewWagesValue);

		JLabel lblSpacer1_3 = new JLabel("                                 ");
		GridBagConstraints gbc_lblSpacer1_3 = new GridBagConstraints();
		gbc_lblSpacer1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer1_3.gridx = 2;
		gbc_lblSpacer1_3.gridy = 5;
		frameShipPropertiesScreen.getContentPane().add(lblSpacer1_3, gbc_lblSpacer1_3);

		JLabel lblCargoCapacity = new JLabel("Current Cargo:");
		lblCargoCapacity.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblCargoCapacity = new GridBagConstraints();
		gbc_lblCargoCapacity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargoCapacity.gridx = 0;
		gbc_lblCargoCapacity.gridy = 6;
		frameShipPropertiesScreen.getContentPane().add(lblCargoCapacity, gbc_lblCargoCapacity);

		JLabel lblCargoCapacityValue = new JLabel("0/0");
		lblCargoCapacityValue.setText(game.getShip().getCargoFullness() + "/" + game.getShip().getMaxCargoCapacity());
		lblCargoCapacityValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCargoCapacityValue = new GridBagConstraints();
		gbc_lblCargoCapacityValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblCargoCapacityValue.gridx = 1;
		gbc_lblCargoCapacityValue.gridy = 6;
		frameShipPropertiesScreen.getContentPane().add(lblCargoCapacityValue, gbc_lblCargoCapacityValue);

		JLabel lblSpacer1_4 = new JLabel("                                 ");
		GridBagConstraints gbc_lblSpacer1_4 = new GridBagConstraints();
		gbc_lblSpacer1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer1_4.gridx = 2;
		gbc_lblSpacer1_4.gridy = 6;
		frameShipPropertiesScreen.getContentPane().add(lblSpacer1_4, gbc_lblSpacer1_4);

		JLabel lblShipHealth = new JLabel("Ship Health:");
		lblShipHealth.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblShipHealth = new GridBagConstraints();
		gbc_lblShipHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblShipHealth.gridx = 3;
		gbc_lblShipHealth.gridy = 6;
		frameShipPropertiesScreen.getContentPane().add(lblShipHealth, gbc_lblShipHealth);

		JLabel lblShipHealthValue = new JLabel("100.0/100.0");
		lblShipHealthValue.setText(game.getShip().getShipHealth() + "/" + game.getShip().getShipEndurance());
		lblShipHealthValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblShipHealthValue = new GridBagConstraints();
		gbc_lblShipHealthValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblShipHealthValue.gridx = 4;
		gbc_lblShipHealthValue.gridy = 6;
		frameShipPropertiesScreen.getContentPane().add(lblShipHealthValue, gbc_lblShipHealthValue);

		JLabel lblSpacer1_7 = new JLabel("                                 ");
		GridBagConstraints gbc_lblSpacer1_7 = new GridBagConstraints();
		gbc_lblSpacer1_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer1_7.gridx = 2;
		gbc_lblSpacer1_7.gridy = 7;
		frameShipPropertiesScreen.getContentPane().add(lblSpacer1_7, gbc_lblSpacer1_7);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		frameShipPropertiesScreen.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnBack = new JButton("      BACK      ");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnBack);

		JLabel lblSpacer1_8 = new JLabel("                                 ");
		panel.add(lblSpacer1_8);

		JButton btnViewCargo = new JButton("VIEW CARGO");
		btnViewCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchCargoScreen();
			}
		});
		btnViewCargo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnViewCargo);
	}

}
