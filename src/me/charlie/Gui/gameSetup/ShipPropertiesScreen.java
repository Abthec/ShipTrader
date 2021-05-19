package me.charlie.Gui.gameSetup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import me.charlie.Gui.GameManager;
import me.charlie.Ship.Ship;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class ShipPropertiesScreen {

	private JFrame frameShipProperties;
	private GameManager gameManager;
	private ShipSelectionScreen shipSelectionWindow;
	private Ship ship;
	
	public ShipPropertiesScreen(GameManager gameManager, ShipSelectionScreen shipSelectionWindow) {
		this.gameManager = gameManager;
		this.ship = shipSelectionWindow.getChosenShip();
		this.shipSelectionWindow = shipSelectionWindow;
		initialize();
		frameShipProperties.setVisible(true);
	}
	
	public void closeWindow() {
		frameShipProperties.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeShipPropertiesScreen(this);
	}
	
	public void goBack() {
		gameManager.shipPropertiesGoBack(this, shipSelectionWindow);
	}
	
	public Ship getShip() {
		return ship;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipPropertiesScreen window = new ShipPropertiesScreen();
					window.frameShipProperties.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShipPropertiesScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameShipProperties = new JFrame();
		frameShipProperties.setType(Type.UTILITY);
		frameShipProperties.setBounds(100, 100, 749, 252);
		frameShipProperties.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameShipProperties.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		frameShipProperties.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][][]"));
		
		JLabel lblShipTypeIdentifier = new JLabel("Ship Type:");
		lblShipTypeIdentifier.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblShipTypeIdentifier, "cell 0 0");
		
		JLabel lblShipType = new JLabel("New label");
		lblShipType.setText(ship.getShipType().getName());
		lblShipType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblShipType, "cell 2 0");
		
		JLabel spacer_1_1 = new JLabel(" \r\n");
		panel.add(spacer_1_1, "cell 0 1");
		
		JLabel lblMaxCargoCapacityIdentifier = new JLabel("Max Cargo Capacity:");
		lblMaxCargoCapacityIdentifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblMaxCargoCapacityIdentifier, "cell 0 2");
		
		JLabel lblMaxCargoCapacity = new JLabel("New label");
		lblMaxCargoCapacity.setText(String.valueOf(ship.getMaxCargoCapacity()));
		lblMaxCargoCapacity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblMaxCargoCapacity, "cell 2 2");
		
		JLabel spacer_1_2 = new JLabel(" \r\n");
		panel.add(spacer_1_2, "cell 0 3");
		
		JLabel lblMaxCrewSizeIdentifier = new JLabel("Max Crew Size:");
		lblMaxCrewSizeIdentifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblMaxCrewSizeIdentifier, "cell 0 4");
		
		JLabel lblMaxCrewSize = new JLabel("New label");
		lblMaxCrewSize.setText(String.valueOf(ship.getMaxCrewSize()));
		lblMaxCrewSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblMaxCrewSize, "cell 2 4");
		
		JLabel spacer_1_3 = new JLabel(" \r\n");
		panel.add(spacer_1_3, "cell 0 5");
		
		JLabel spacer_1_4 = new JLabel(" \r\n");
		panel.add(spacer_1_4, "cell 0 7");
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnConfirm, "cell 0 8");
		
		JPanel panel_1 = new JPanel();
		frameShipProperties.getContentPane().add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][]", "[][][][][][][][][]"));
		
		JLabel lblShipNameIdentifier = new JLabel("Ship Name:");
		lblShipNameIdentifier.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblShipNameIdentifier, "cell 0 0");
		
		JLabel lblShipName = new JLabel("New label");
		lblShipName.setText(ship.getName());
		lblShipName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblShipName, "cell 2 0");
		
		JLabel spacer_1_5 = new JLabel(" \r\n");
		panel_1.add(spacer_1_5, "cell 0 1");
		
		JLabel lblSailSpeedIdentifier = new JLabel("Sail Speed:");
		lblSailSpeedIdentifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblSailSpeedIdentifier, "cell 0 2");
		
		JLabel lblSailSpeed = new JLabel("New label");
		lblSailSpeed.setText(ship.getSailSpeed() + "km/day");
		lblSailSpeed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblSailSpeed, "cell 2 2");
		
		JLabel spacer_1_6 = new JLabel(" \r\n");
		panel_1.add(spacer_1_6, "cell 0 3");
		
		JLabel lblShipEnduranceIdentifier = new JLabel("Ship Endurance:");
		lblShipEnduranceIdentifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblShipEnduranceIdentifier, "cell 0 4");
		
		JLabel lblShipEndurance = new JLabel("New label");
		lblShipEndurance.setText(String.valueOf(ship.getShipEndurance()));
		lblShipEndurance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblShipEndurance, "cell 2 4");
		
		JLabel spacer_1_7 = new JLabel(" \r\n");
		panel_1.add(spacer_1_7, "cell 0 5");
		
		JLabel spacer_1 = new JLabel(" \r\n");
		panel_1.add(spacer_1, "cell 0 6");
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(btnBack, "cell 0 8");
	}
}
