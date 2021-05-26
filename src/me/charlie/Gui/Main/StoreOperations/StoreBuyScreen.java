package me.charlie.Gui.Main.StoreOperations;

import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Gui.Popups.UnableToBuyPopup;
import me.charlie.Item.Item;
import me.charlie.Store.Store;

/**
 * A screen for the player to buy items.
 * 
 * @author charlie
 *
 */
public class StoreBuyScreen {

	private JFrame frameStoreBuyWindow;
	private Store store;
	private GameManager gameManager;
	private Game game;
	private StoreOptionsScreen storeOptionsWindow;
	private int listIndex = 0;

	/**
	 * Opens the buy window in the Store.
	 * 
	 * @param gameManager        controls the launching and closing of the window.
	 * @param game               the current instance of the Game.
	 * @param storeOptionsWindow the window that this window was opened from.
	 */
	public StoreBuyScreen(GameManager gameManager, Game game, StoreOptionsScreen storeOptionsWindow) {
		this.game = game;
		this.gameManager = gameManager;
		this.store = game.getShip().getCurrentIsland().getStore();
		this.storeOptionsWindow = storeOptionsWindow;
		initialize();
		frameStoreBuyWindow.setVisible(true);
	}

	/**
	 * Refreshes the window to update labels and lists with new information
	 */
	public void refresh() {
		closeWindow();
		storeOptionsWindow.launchStoreBuyScreen();
	}

	/**
	 * Stops the player from buying an item.
	 */
	public void launchUnableToBuyPopup(String reason) {
		UnableToBuyPopup unableToBuyPopup = new UnableToBuyPopup(this, reason);
		frameStoreBuyWindow.setVisible(false);
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frameStoreBuyWindow.dispose();
	}

	/**
	 * Calls gameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.launchStoreOptionsScreen();
		closeWindow();
	}

	/**
	 * 
	 * @return the frame of the current window.
	 */
	public JFrame getJFrame() {
		return frameStoreBuyWindow;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameStoreBuyWindow = new JFrame();
		frameStoreBuyWindow.setBounds(100, 100, 559, 539);
		frameStoreBuyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		frameStoreBuyWindow.getContentPane().setLayout(gridBagLayout);

		JLabel lblStoreDetails = new JLabel("asdasd");

		lblStoreDetails.setText(store.getName() + " | " + store.getStoreType().getName());

		lblStoreDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblStoreDetails = new GridBagConstraints();
		gbc_lblStoreDetails.insets = new Insets(0, 0, 5, 0);
		gbc_lblStoreDetails.gridx = 0;
		gbc_lblStoreDetails.gridy = 1;
		frameStoreBuyWindow.getContentPane().add(lblStoreDetails, gbc_lblStoreDetails);

		JLabel lblInsctruction = new JLabel("Select the item you would like to purchase or press back.");
		lblInsctruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInsctruction = new GridBagConstraints();
		gbc_lblInsctruction.insets = new Insets(0, 0, 5, 0);
		gbc_lblInsctruction.gridx = 0;
		gbc_lblInsctruction.gridy = 2;
		frameStoreBuyWindow.getContentPane().add(lblInsctruction, gbc_lblInsctruction);

		JLabel lblFormat = new JLabel("Item Type | Item Cost | Item Size");
		lblFormat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFormat = new GridBagConstraints();
		gbc_lblFormat.insets = new Insets(0, 0, 5, 0);
		gbc_lblFormat.gridx = 0;
		gbc_lblFormat.gridy = 3;
		frameStoreBuyWindow.getContentPane().add(lblFormat, gbc_lblFormat);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		frameStoreBuyWindow.getContentPane().add(scrollPane, gbc_scrollPane);

		DefaultListModel defaultListModel = new DefaultListModel();

		for (Item item : store.getStock()) {
			String itemString = item.getItemType().getName() + " | " + item.getBuyCost() + " | "
					+ item.getItemType().getSize();
			defaultListModel.add(listIndex, itemString);
			listIndex++;
		}

		JList listItems = new JList();
		listItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listItems.setFont(new Font("Tahoma", Font.ITALIC, 14));
		listItems.setModel(defaultListModel);
		scrollPane.setViewportView(listItems);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		frameStoreBuyWindow.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnBuy = new JButton("  BUY  ");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chosenItemIndex = listItems.getSelectedIndex();
				Item chosenItem = store.getStock().get(chosenItemIndex);
				int itemCost = chosenItem.getBuyCost();
				if (itemCost <= game.getTrader().getMoney() && game.getShip().addItemToCargo(chosenItem)) {
					game.getTrader().subtractMoney(itemCost);
					store.getStock().remove(chosenItem);
					chosenItem.setPurchasedPrice(itemCost);
					chosenItem.setPlaceOfPurchase(game.getShip().getCurrentIsland());
					refresh();
				} else {
					if (itemCost <= game.getTrader().getMoney()) {
						launchUnableToBuyPopup("You do not have enough coins to purchase that item.");
					} else {
						launchUnableToBuyPopup("You do not have enough cargo space remaining to purchase that item.");
					}
				}
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnBuy);

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
		frameStoreBuyWindow.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblCurrentWallet = new JLabel("New label");
		lblCurrentWallet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentWallet.setText("Current Wallet: " + game.getTrader().getMoney() + " Coins.");
		panel_1.add(lblCurrentWallet);

		JLabel lblSpacer_1 = new JLabel("                                                     ");
		panel_1.add(lblSpacer_1);

		JLabel lblCurrentCargoCapacity = new JLabel("New label");
		lblCurrentCargoCapacity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentCargoCapacity.setText("Cargo Space Remaining: " + game.getShip().getCargoFullness() + "/"
				+ game.getShip().getMaxCargoCapacity() + ".");
		panel_1.add(lblCurrentCargoCapacity);
	}

}
