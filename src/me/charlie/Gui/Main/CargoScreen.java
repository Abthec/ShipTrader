package me.charlie.Gui.Main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Item.Item;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class CargoScreen {

	private JFrame frameCargoScreen;
	private ShipPropertiesScreen shipPropertiesWindow;
	private Game game;
	private int listIndex = 0;
	
	public CargoScreen(ShipPropertiesScreen shipPropertiesWindow, Game game) {
		this.game = game;
		this.shipPropertiesWindow = shipPropertiesWindow;
		initialize();
		frameCargoScreen.setVisible(true);
	}

	public void closeWindow() {
		frameCargoScreen.dispose();
	}
	
	public void finishedWindow() {
		shipPropertiesWindow.getJFrame().setVisible(true);
		closeWindow();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargoScreen window = new CargoScreen();
					window.frameCargoScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CargoScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCargoScreen = new JFrame();
		frameCargoScreen.setBounds(100, 100, 769, 513);
		frameCargoScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frameCargoScreen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCurrentCargo = new JLabel("Current Cargo Inventory.");
		lblCurrentCargo.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCurrentCargo = new GridBagConstraints();
		gbc_lblCurrentCargo.gridwidth = 2;
		gbc_lblCurrentCargo.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentCargo.gridx = 0;
		gbc_lblCurrentCargo.gridy = 0;
		frameCargoScreen.getContentPane().add(lblCurrentCargo, gbc_lblCurrentCargo);
		
		DefaultListModel listModel = new DefaultListModel();
		
		for (Item item : game.getShip().getCurrentCargo()) {
			String itemString = "";
			listModel.add(listIndex, itemString);
			listIndex++;
		}
		
		JLabel lblCurrentItems = new JLabel("Currently Store Items");
		lblCurrentItems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCurrentItems = new GridBagConstraints();
		gbc_lblCurrentItems.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentItems.gridx = 0;
		gbc_lblCurrentItems.gridy = 1;
		frameCargoScreen.getContentPane().add(lblCurrentItems, gbc_lblCurrentItems);
		
		JLabel lblPreviousItems = new JLabel("Previously Stored Items (Sold Items)");
		lblPreviousItems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPreviousItems = new GridBagConstraints();
		gbc_lblPreviousItems.insets = new Insets(0, 0, 5, 0);
		gbc_lblPreviousItems.gridx = 1;
		gbc_lblPreviousItems.gridy = 1;
		frameCargoScreen.getContentPane().add(lblPreviousItems, gbc_lblPreviousItems);
		
		JLabel lblNewLabel = new JLabel("         Item Type | Place Of Purchase | Purchase Price         ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		frameCargoScreen.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Item Type | Place Of Purchase | Purchase Price | Sold Price");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		frameCargoScreen.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		frameCargoScreen.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JList listCurrentItems = new JList();
		scrollPane.setViewportView(listCurrentItems);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 3;
		frameCargoScreen.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		
		JList listSoldItems = new JList();
		scrollPane_1.setViewportView(listSoldItems);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridwidth = 2;
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 4;
		frameCargoScreen.getContentPane().add(btnBack, gbc_btnBack);
	}

}
