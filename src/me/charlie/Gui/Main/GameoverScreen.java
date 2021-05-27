package me.charlie.Gui.Main;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Item.Item;

/**
 * Indicates the game is over. Displays significant stats and game information.
 * 
 * @author charl
 *
 */
public class GameoverScreen {

	private JFrame frameGameoverScreen;
	private Game game;
	private GameManager gameManager;
	private String reasonForGameover;
	private boolean lossToPirates;
	private String crewOutcome;
	private int soldItemsListIndex = 0;

	/**
	 * Opens a window that indicates the end of the game.
	 * 
	 * @param game              the Game data.
	 * @param gameManager       controls the launching and closing of the window.
	 * @param reasonForGameover the reason the game was ended.
	 * @param lossToPirates     if the game ended because of pirates.
	 */
	public GameoverScreen(Game game, GameManager gameManager, String reasonForGameover, boolean lossToPirates) {
		this.lossToPirates = lossToPirates;
		this.reasonForGameover = reasonForGameover;
		this.gameManager = gameManager;
		this.game = game;
		if (lossToPirates) {
			this.crewOutcome = "your crew was murdered by pirates!";
		} else {
			this.crewOutcome = game.getShip().getCurrentCrewSize() + " crew members!";
		}
		initialize();
		frameGameoverScreen.setVisible(true);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frameGameoverScreen.dispose();
	}

	/**
	 * Calls GameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.launchStartupScreen();
		closeWindow();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameGameoverScreen = new JFrame();
		frameGameoverScreen.setBounds(100, 100, 965, 590);
		frameGameoverScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		frameGameoverScreen.getContentPane().setLayout(gridBagLayout);

		JLabel lblGameover = new JLabel("Gameover!");
		lblGameover.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblGameover = new GridBagConstraints();
		gbc_lblGameover.gridwidth = 3;
		gbc_lblGameover.insets = new Insets(0, 0, 5, 0);
		gbc_lblGameover.gridx = 0;
		gbc_lblGameover.gridy = 0;
		frameGameoverScreen.getContentPane().add(lblGameover, gbc_lblGameover);

		JLabel spacer_3 = new JLabel("          ");
		GridBagConstraints gbc_spacer_3 = new GridBagConstraints();
		gbc_spacer_3.insets = new Insets(0, 0, 5, 5);
		gbc_spacer_3.gridx = 0;
		gbc_spacer_3.gridy = 1;
		frameGameoverScreen.getContentPane().add(spacer_3, gbc_spacer_3);

		JLabel spacer_5 = new JLabel("Item Type | Place of Purchase | Place of Sale | Purchase Cost | Sale Cost");
		spacer_5.setForeground(UIManager.getColor("EditorPane.disabledBackground"));
		spacer_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spacer_5.setVisible(false);
		GridBagConstraints gbc_spacer_5 = new GridBagConstraints();
		gbc_spacer_5.insets = new Insets(0, 0, 5, 0);
		gbc_spacer_5.gridx = 2;
		gbc_spacer_5.gridy = 1;
		frameGameoverScreen.getContentPane().add(spacer_5, gbc_spacer_5);

		JLabel lblGamoverReason = new JLabel(reasonForGameover);
		lblGamoverReason.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblGamoverReason = new GridBagConstraints();
		gbc_lblGamoverReason.gridwidth = 3;
		gbc_lblGamoverReason.insets = new Insets(0, 0, 5, 0);
		gbc_lblGamoverReason.gridx = 0;
		gbc_lblGamoverReason.gridy = 2;
		frameGameoverScreen.getContentPane().add(lblGamoverReason, gbc_lblGamoverReason);

		JLabel spacer_2 = new JLabel("          ");
		GridBagConstraints gbc_spacer_2 = new GridBagConstraints();
		gbc_spacer_2.insets = new Insets(0, 0, 5, 5);
		gbc_spacer_2.gridx = 0;
		gbc_spacer_2.gridy = 3;
		frameGameoverScreen.getContentPane().add(spacer_2, gbc_spacer_2);

		JLabel lblFinishingMoney = new JLabel(
				"You finished the game with: " + game.getTrader().getMoney() + " coins. And, " + crewOutcome);
		lblFinishingMoney.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFinishingMoney = new GridBagConstraints();
		gbc_lblFinishingMoney.gridwidth = 3;
		gbc_lblFinishingMoney.insets = new Insets(0, 0, 5, 0);
		gbc_lblFinishingMoney.gridx = 0;
		gbc_lblFinishingMoney.gridy = 4;
		frameGameoverScreen.getContentPane().add(lblFinishingMoney, gbc_lblFinishingMoney);

		JLabel spacer_1 = new JLabel("          ");
		GridBagConstraints gbc_spacer_1 = new GridBagConstraints();
		gbc_spacer_1.insets = new Insets(0, 0, 5, 5);
		gbc_spacer_1.gridx = 0;
		gbc_spacer_1.gridy = 5;
		frameGameoverScreen.getContentPane().add(spacer_1, gbc_spacer_1);

		JLabel lblSoldItems = new JLabel("Items Sold:");
		lblSoldItems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSoldItems = new GridBagConstraints();
		gbc_lblSoldItems.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldItems.gridx = 0;
		gbc_lblSoldItems.gridy = 6;
		frameGameoverScreen.getContentPane().add(lblSoldItems, gbc_lblSoldItems);

		JLabel spacer = new JLabel("          ");
		GridBagConstraints gbc_spacer = new GridBagConstraints();
		gbc_spacer.insets = new Insets(0, 0, 5, 5);
		gbc_spacer.gridx = 1;
		gbc_spacer.gridy = 6;
		frameGameoverScreen.getContentPane().add(spacer, gbc_spacer);

		JLabel lblShipUpgrades = new JLabel("Ship upgrades:");
		lblShipUpgrades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblShipUpgrades = new GridBagConstraints();
		gbc_lblShipUpgrades.insets = new Insets(0, 0, 5, 0);
		gbc_lblShipUpgrades.gridx = 2;
		gbc_lblShipUpgrades.gridy = 6;
		frameGameoverScreen.getContentPane().add(lblShipUpgrades, gbc_lblShipUpgrades);

		JLabel lblSoldItemsFormat = new JLabel(
				"Item Type | Place of Purchase | Place of Sale | Purchase Cost | Sale Cost");
		lblSoldItemsFormat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSoldItemsFormat = new GridBagConstraints();
		gbc_lblSoldItemsFormat.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldItemsFormat.gridx = 0;
		gbc_lblSoldItemsFormat.gridy = 7;
		frameGameoverScreen.getContentPane().add(lblSoldItemsFormat, gbc_lblSoldItemsFormat);

		JLabel lblUpgradeFormat = new JLabel("Upgrade Type | Number of Upgrades");
		lblUpgradeFormat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblUpgradeFormat = new GridBagConstraints();
		gbc_lblUpgradeFormat.insets = new Insets(0, 0, 5, 0);
		gbc_lblUpgradeFormat.gridx = 2;
		gbc_lblUpgradeFormat.gridy = 7;
		frameGameoverScreen.getContentPane().add(lblUpgradeFormat, gbc_lblUpgradeFormat);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		frameGameoverScreen.getContentPane().add(scrollPane, gbc_scrollPane);

		DefaultListModel soldItemsModel = new DefaultListModel();

		for (Item item : game.getShip().getReceipts()) {
			if (item.usedAsUpgrade()) {
				String itemString = item.getItemType().getName() + " | " + item.getPlaceOfPurchase() + " | "
						+ item.getPurchasedPrice() + " | " + "Applied to ship as upgrade";
				soldItemsModel.add(soldItemsListIndex, itemString);
			} else if (item.wasStolen()) {
				String itemString = item.getItemType().getName() + " | " + item.getPlaceOfPurchase().getName() + " | "
						+ item.getPurchasedPrice() + " | " + "Was stolen by pirates.";
			} else {
				String itemString = item.getItemType().getName() + " | " + item.getPlaceOfPurchase().getName() + " | "
						+ item.getPlaceOfSale().getName() + " | " + item.getPurchasedPrice() + " | "
						+ item.getSoldPrice();
				soldItemsModel.add(soldItemsListIndex, itemString);
			}

		}

		JList listItemsSold = new JList();
		listItemsSold.setModel(soldItemsModel);
		scrollPane.setViewportView(listItemsSold);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 8;
		frameGameoverScreen.getContentPane().add(scrollPane_1, gbc_scrollPane_1);

		DefaultListModel shipUpgradesModel = new DefaultListModel();

		shipUpgradesModel.add(0, "Cannons | " + game.getShip().getNumberOfCannons());
		shipUpgradesModel.add(1, "Mast Upgrades | " + game.getShip().getNumberOfMastUpgrades());
		shipUpgradesModel.add(2, "Cargo Hold Upgrades | " + game.getShip().getNumberOfCargoHoldUpgrades());
		shipUpgradesModel.add(3, "Bulkhead Upgrades | " + game.getShip().getNumberOfBulkheadUpgrades());

		JList listShipUpgrades = new JList();
		listShipUpgrades.setModel(shipUpgradesModel);
		scrollPane_1.setViewportView(listShipUpgrades);

		JButton btnEndGame = new JButton("END GAME");
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnEndGame.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnEndGame = new GridBagConstraints();
		gbc_btnEndGame.insets = new Insets(0, 0, 0, 5);
		gbc_btnEndGame.gridx = 0;
		gbc_btnEndGame.gridy = 9;
		frameGameoverScreen.getContentPane().add(btnEndGame, gbc_btnEndGame);

		JButton btnNewGame = new JButton("NEW GAME");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.gridx = 2;
		gbc_btnNewGame.gridy = 9;
		frameGameoverScreen.getContentPane().add(btnNewGame, gbc_btnNewGame);
	}

}
