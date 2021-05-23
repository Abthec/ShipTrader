package me.charlie.Gui.Main.StoreOperations;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Item.Item;
import me.charlie.Ship.Ship;
import me.charlie.Store.Store;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreSellScreen {

	private JFrame frameStoreSellScreen;
	private GameManager gameManager;
	private Store store;
	private Game game;
	private Ship ship;
	private StoreOptionsScreen storeOptionsWindow;
	private int listIndex=0;
	private JButton btnSell;
	
	public StoreSellScreen(GameManager gameManager, Game game, StoreOptionsScreen storeOptionsWindow) {
		this.gameManager = gameManager;
		this.game = game;
		this.store = game.getShip().getCurrentIsland().getStore();
		this.ship = game.getShip();
		this.storeOptionsWindow = storeOptionsWindow;
		initialize();
		frameStoreSellScreen.setVisible(true);
	}
	
	public void refresh() {
		closeWindow();
		storeOptionsWindow.launchStoreSellScreen();
	}
	
	public void closeWindow() {
		frameStoreSellScreen.dispose();
	}
	
	public void finishedWindow() {
		gameManager.launchStoreOptionsScreen();
		closeWindow();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreSellScreen window = new StoreSellScreen();
					window.frameStoreSellScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoreSellScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameStoreSellScreen = new JFrame();
		frameStoreSellScreen.setBounds(100, 100, 752, 464);
		frameStoreSellScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		frameStoreSellScreen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblStoreDetails = new JLabel("<dynamic> | <dynamic>");
		lblStoreDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblStoreDetails = new GridBagConstraints();
		gbc_lblStoreDetails.insets = new Insets(0, 0, 5, 0);
		gbc_lblStoreDetails.gridx = 0;
		gbc_lblStoreDetails.gridy = 1;
		frameStoreSellScreen.getContentPane().add(lblStoreDetails, gbc_lblStoreDetails);
		
		JLabel lblInstruction = new JLabel("Select the item you would like to sell or press back.");
		lblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInstruction = new GridBagConstraints();
		gbc_lblInstruction.insets = new Insets(0, 0, 5, 0);
		gbc_lblInstruction.gridx = 0;
		gbc_lblInstruction.gridy = 2;
		frameStoreSellScreen.getContentPane().add(lblInstruction, gbc_lblInstruction);
		
		JLabel lblFormat = new JLabel("Item Type | Item Cost | Item Size");
		lblFormat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFormat = new GridBagConstraints();
		gbc_lblFormat.insets = new Insets(0, 0, 5, 0);
		gbc_lblFormat.gridx = 0;
		gbc_lblFormat.gridy = 3;
		frameStoreSellScreen.getContentPane().add(lblFormat, gbc_lblFormat);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		frameStoreSellScreen.getContentPane().add(scrollPane, gbc_scrollPane);
		
		DefaultListModel listModel = new DefaultListModel();
		
		for (int i=0; i<game.getShip().getCurrentCargo().size(); i++) {
			Item item = game.getShip().getCurrentCargo().get(i);
			String itemString = item.getItemType().getName() + " | " + item.getSellCost(store) + " | " + item.getSize();
			listModel.add(i, itemString);
		}
		
		JList listItems = new JList();
		listItems.setFont(new Font("Tahoma", Font.ITALIC, 14));
		listItems.setModel(listModel);
		scrollPane.setViewportView(listItems);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		frameStoreSellScreen.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSell = new JButton(" SELL ");
		if (game.getShip().getCargoFullness()==0) {
			btnSell.setEnabled(false);
		}
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemIndex = listItems.getSelectedIndex();
				Item item = game.getShip().getCurrentCargo().remove(itemIndex);
				game.getShip().getReceipts().add(item);
				int sellCost = item.getSellCost(store);
				game.getTrader().addMoney(sellCost);
				item.setSoldPrice(sellCost);
				item.setPlaceOfSale(game.getShip().getCurrentIsland());
				refresh();
			}
		});
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnSell);
		
		JLabel lblSpacer = new JLabel("                                                     ");
		panel.add(lblSpacer);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 6;
		frameStoreSellScreen.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCurrentWallet = new JLabel("Current Wallet: 0 Coins.");
		lblCurrentWallet.setText("Current Wallet: " + game.getTrader().getMoney() + " Coins.");
		lblCurrentWallet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblCurrentWallet);
		
		JLabel lblSpacer_1 = new JLabel("                                                     ");
		panel_1.add(lblSpacer_1);
		
		JLabel lblCurrentCargoCapacity = new JLabel("Cargo Space Remaining: 0/0.");
		lblCurrentCargoCapacity.setText("Cargo Space Remaining: " + game.getShip().getCargoFullness() + "/" + game.getShip().getMaxCargoCapacity() + ".");
		lblCurrentCargoCapacity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblCurrentCargoCapacity);
	}

}
