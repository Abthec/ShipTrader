package me.charlie.Gui.gameSetup;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import me.charlie.Gui.GameManager;
import me.charlie.Ship.Ship;
import me.charlie.Ship.ShipNameHandler;
import me.charlie.Ship.ShipType;
import net.miginfocom.swing.MigLayout;

/**
 * A screen for the player to choose their ship.
 * 
 * @author charl
 *
 */
public class ShipSelectionScreen {

	private JFrame frameShipSelectoionScreen;
	private GameManager gameManager;
	List<Ship> ships;
	Ship chosenShip;

	/**
	 * Opens a screen for the player to choose a ship. Creates the Ships for the
	 * player to choose from.
	 * 
	 * @param gameManager controls the launching and closing of the window.
	 */
	public ShipSelectionScreen(GameManager gameManager) {
		ShipNameHandler shipNameHandler = new ShipNameHandler();
		this.ships = new ArrayList<Ship>();
		ships.add(new Ship(ShipType.SCHOONER, 1, 17.5, 10, 15, 250, null, shipNameHandler.getName()));
		ships.add(new Ship(ShipType.BARQUENTINE, 2, 20, 8, 12, 150, null, shipNameHandler.getName()));
		ships.add(new Ship(ShipType.BRIGANTINE, 3, 16, 18, 24, 310, null, shipNameHandler.getName()));
		ships.add(new Ship(ShipType.AIRCRAFT_CARRIER, 4, 15, 30, 50, 750, null, shipNameHandler.getName()));
		this.gameManager = gameManager;
		initialize();
		frameShipSelectoionScreen.setVisible(true);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frameShipSelectoionScreen.dispose();
	}

	/**
	 * Takes the player back to the StartupScreen.
	 */
	public void goBack() {
		gameManager.shipSelectorGoBack(this);
	}

	/**
	 * Calls GameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.closeShipSelectorScreen(this);
	}

	/**
	 * Opens the ShipPropertiesScreen through GameManager.
	 */
	public void viewShipProperties() {
		gameManager.minimizeShipSelectionScreen(this);
	}

	/**
	 * 
	 * @return the ship chosen by the player.
	 */
	public Ship getChosenShip() {
		return chosenShip;
	}

	/**
	 * 
	 * @return the frame of the current window.
	 */
	public JFrame getJFrame() {
		return frameShipSelectoionScreen;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipSelectionScreen window = new ShipSelectionScreen();
					window.frameShipSelectoionScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShipSelectionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameShipSelectoionScreen = new JFrame();
		frameShipSelectoionScreen.setType(Type.UTILITY);
		frameShipSelectoionScreen.setBounds(100, 100, 615, 349);
		frameShipSelectoionScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameShipSelectoionScreen.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frameShipSelectoionScreen.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 176, 183, 0 };
		gbl_panel.rowHeights = new int[] { 0, 25, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblChooseShip = new JLabel("Choose Your Ship:");
		lblChooseShip.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblChooseShip = new GridBagConstraints();
		gbc_lblChooseShip.insets = new Insets(0, 0, 5, 0);
		gbc_lblChooseShip.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblChooseShip.gridx = 1;
		gbc_lblChooseShip.gridy = 0;
		panel.add(lblChooseShip, gbc_lblChooseShip);

		JLabel lblSelectShip = new JLabel("Select any ship to view it's properties.");
		lblSelectShip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSelectShip = new GridBagConstraints();
		gbc_lblSelectShip.gridx = 1;
		gbc_lblSelectShip.gridy = 1;
		panel.add(lblSelectShip, gbc_lblSelectShip);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		frameShipSelectoionScreen.getContentPane().add(btnBack, BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		frameShipSelectoionScreen.getContentPane().add(panel_1, BorderLayout.CENTER);

		JButton btnShip1 = new JButton("SCHOONER");
		btnShip1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnShip1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenShip = ships.get(0);
				viewShipProperties();
			}
		});
		panel_1.setLayout(new MigLayout("", "[133px][133px][133px][133px]", "[232px]"));
		panel_1.add(btnShip1, "cell 0 0,grow");

		JButton btnShip2 = new JButton("BRIGANTINE");
		btnShip2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenShip = ships.get(2);
				viewShipProperties();
			}
		});
		btnShip2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(btnShip2, "cell 1 0,grow");

		JButton btnShip3 = new JButton("BARQUENTINE");
		btnShip3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenShip = ships.get(1);
				viewShipProperties();
			}
		});
		btnShip3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(btnShip3, "cell 2 0,grow");

		JButton btnShip4 = new JButton("AIRCRAFT\r\n CARRIER");
		btnShip4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenShip = ships.get(3);
				viewShipProperties();
			}
		});
		btnShip4.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(btnShip4, "cell 3 0,grow");
	}
}
