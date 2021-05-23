package me.charlie.Gui.Main.Travel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Island.Island;
import me.charlie.Island.Route;
import me.charlie.Store.Store;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArrivalScreen {

	private JFrame frameArrivalScreen;
	private GameManager gameManager;
	private Route route;
	private Game game;
	private Island currentIsland;
	private Store store;
	
	public ArrivalScreen(GameManager gameManager, Route route, Game game) {
		this.gameManager = gameManager;
		this.route = route;
		this.game = game;
		this.currentIsland = route.getIslandB();
		this.store = currentIsland.getStore();
		game.getShip().setCurrentIsland(currentIsland);
		game.setDaysRemaining(route.getSailDuration(game.getShip()));
		initialize();
		frameArrivalScreen.setVisible(true);
	}
	
	public void closeWindow() {
		frameArrivalScreen.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeArrivalScreen(this);
	}
	
	public JFrame getJFrame() {
		return frameArrivalScreen;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrivalScreen window = new ArrivalScreen();
					window.frameArrivalScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArrivalScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameArrivalScreen = new JFrame();
		frameArrivalScreen.setBounds(100, 100, 469, 277);
		frameArrivalScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frameArrivalScreen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome to");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcome.setText("  Welcome " + game.getTrader().getName() + " to " + currentIsland.getName() + ". Enjoy your stay!");
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 1;
		frameArrivalScreen.getContentPane().add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblSpacer1 = new JLabel("         ");
		GridBagConstraints gbc_lblSpacer1 = new GridBagConstraints();
		gbc_lblSpacer1.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer1.gridx = 0;
		gbc_lblSpacer1.gridy = 2;
		frameArrivalScreen.getContentPane().add(lblSpacer1, gbc_lblSpacer1);
		
		JLabel lblCrewPay = new JLabel("  You pay your crew <10*numDays> coins for their hard work.");
		
		int moneySpent = route.getSailDuration(game.getShip())*10*game.getShip().getCurrentCrewSize();
		lblCrewPay.setText("  You pay your crew " + moneySpent + " coins each for their hard work.  ");
		game.getTrader().subtractMoney(moneySpent);
		
		lblCrewPay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCrewPay = new GridBagConstraints();
		gbc_lblCrewPay.insets = new Insets(0, 0, 5, 0);
		gbc_lblCrewPay.gridx = 0;
		gbc_lblCrewPay.gridy = 3;
		frameArrivalScreen.getContentPane().add(lblCrewPay, gbc_lblCrewPay);
		
		JLabel lblSpacer2 = new JLabel("         ");
		GridBagConstraints gbc_lblSpacer2 = new GridBagConstraints();
		gbc_lblSpacer2.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer2.gridx = 0;
		gbc_lblSpacer2.gridy = 4;
		frameArrivalScreen.getContentPane().add(lblSpacer2, gbc_lblSpacer2);
		
		JLabel lblMoneyStatus = new JLabel("You now have <trader.getMoney> coins.");
		
		lblMoneyStatus.setText("You now have " + game.getTrader().getMoney() + " coins.");
		
		lblMoneyStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMoneyStatus = new GridBagConstraints();
		gbc_lblMoneyStatus.insets = new Insets(0, 0, 5, 0);
		gbc_lblMoneyStatus.gridx = 0;
		gbc_lblMoneyStatus.gridy = 5;
		frameArrivalScreen.getContentPane().add(lblMoneyStatus, gbc_lblMoneyStatus);
		
		JLabel lblSpacer3 = new JLabel("         ");
		GridBagConstraints gbc_lblSpacer3 = new GridBagConstraints();
		gbc_lblSpacer3.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer3.gridx = 0;
		gbc_lblSpacer3.gridy = 6;
		frameArrivalScreen.getContentPane().add(lblSpacer3, gbc_lblSpacer3);
		
		JLabel lblStoreDetails = new JLabel("On this island there is a <storeType> called <storeName>.");
		
		lblStoreDetails.setText("On this island there is a " + store.getStoreType().getName() + " called " + store.getName() + ".");
		
		lblStoreDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStoreDetails = new GridBagConstraints();
		gbc_lblStoreDetails.insets = new Insets(0, 0, 5, 0);
		gbc_lblStoreDetails.gridx = 0;
		gbc_lblStoreDetails.gridy = 7;
		frameArrivalScreen.getContentPane().add(lblStoreDetails, gbc_lblStoreDetails);
		
		JLabel lblSpacer4 = new JLabel("         ");
		GridBagConstraints gbc_lblSpacer4 = new GridBagConstraints();
		gbc_lblSpacer4.insets = new Insets(0, 0, 5, 0);
		gbc_lblSpacer4.gridx = 0;
		gbc_lblSpacer4.gridy = 8;
		frameArrivalScreen.getContentPane().add(lblSpacer4, gbc_lblSpacer4);
		
		JButton btnContinue = new JButton("CONTINUE");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.gridx = 0;
		gbc_btnContinue.gridy = 9;
		frameArrivalScreen.getContentPane().add(btnContinue, gbc_btnContinue);
	}

}
