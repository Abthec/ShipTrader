package me.charlie.Gui.Main.StoreOperations;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Gui.Popups.UnableToSellPopup;
import me.charlie.Ship.Ship;
import me.charlie.Store.Store;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreOptionsScreen {

	private JFrame frameStoreOptionsScreen;
	private GameManager gameManager;
	private Store store;
	private Game game;
	private Ship ship;
	
	public StoreOptionsScreen(GameManager gameManager, Game game) {
		this.gameManager = gameManager;
		this.game = game;
		this.ship = game.getShip();
		this.store = ship.getCurrentIsland().getStore();
	}
	
	public void closeWindow() {
		frameStoreOptionsScreen.dispose();
	}
	
	public void launchStoreBuyScreen() {
		
	}
	
	public void launchStoreSellScreen() {
		
	}
	
	public void launchUnableToSellpopup() {
		frameStoreOptionsScreen.setVisible(false);
		UnableToSellPopup unableToSellPopup = new UnableToSellPopup(this);
	}

	public void finishedWindow() {
		gameManager.closeStoreOptionsScreen(this);
	}
	
	public JFrame getJFrame() {
		return frameStoreOptionsScreen;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreOptionsScreen window = new StoreOptionsScreen();
					window.frameStoreOptionsScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoreOptionsScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameStoreOptionsScreen = new JFrame();
		frameStoreOptionsScreen.setBounds(100, 100, 524, 246);
		frameStoreOptionsScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frameStoreOptionsScreen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome to store.");
		
		lblWelcome.setText("Welcome to " + store.getName() + " we are a specialist " + store.getStoreType().getName() + ".");
		
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 1;
		frameStoreOptionsScreen.getContentPane().add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblSpacer1 = new JLabel(" ");
		lblSpacer1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSpacer1 = new GridBagConstraints();
		gbc_lblSpacer1.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer1.gridx = 1;
		gbc_lblSpacer1.gridy = 2;
		frameStoreOptionsScreen.getContentPane().add(lblSpacer1, gbc_lblSpacer1);
		
		JButton btnBuy = new JButton("BUY");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnBuy = new GridBagConstraints();
		gbc_btnBuy.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuy.gridx = 1;
		gbc_btnBuy.gridy = 3;
		frameStoreOptionsScreen.getContentPane().add(btnBuy, gbc_btnBuy);
		
		JLabel lblSpacer2 = new JLabel(" ");
		lblSpacer2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSpacer2 = new GridBagConstraints();
		gbc_lblSpacer2.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer2.gridx = 1;
		gbc_lblSpacer2.gridy = 4;
		frameStoreOptionsScreen.getContentPane().add(lblSpacer2, gbc_lblSpacer2);
		
		JButton btnSell = new JButton("SELL");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ship.getCargoFullness() == 0) {
					
				} else {
					launchStoreSellScreen();
				}
			}
		});
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnSell = new GridBagConstraints();
		gbc_btnSell.insets = new Insets(0, 0, 5, 0);
		gbc_btnSell.gridx = 1;
		gbc_btnSell.gridy = 5;
		frameStoreOptionsScreen.getContentPane().add(btnSell, gbc_btnSell);
		
		JLabel lblSpacer3 = new JLabel(" ");
		lblSpacer3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSpacer3 = new GridBagConstraints();
		gbc_lblSpacer3.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer3.gridx = 1;
		gbc_lblSpacer3.gridy = 6;
		frameStoreOptionsScreen.getContentPane().add(lblSpacer3, gbc_lblSpacer3);
		
		JButton btnLeave = new JButton("LEAVE");
		btnLeave.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnLeave = new GridBagConstraints();
		gbc_btnLeave.insets = new Insets(0, 0, 5, 0);
		gbc_btnLeave.gridx = 1;
		gbc_btnLeave.gridy = 7;
		frameStoreOptionsScreen.getContentPane().add(btnLeave, gbc_btnLeave);
		
		JLabel lblSpacer4 = new JLabel(" ");
		lblSpacer4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSpacer4 = new GridBagConstraints();
		gbc_lblSpacer4.gridx = 1;
		gbc_lblSpacer4.gridy = 8;
		frameStoreOptionsScreen.getContentPane().add(lblSpacer4, gbc_lblSpacer4);
	}

}
