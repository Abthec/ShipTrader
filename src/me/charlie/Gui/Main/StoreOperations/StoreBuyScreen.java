package me.charlie.Gui.Main.StoreOperations;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Store.Store;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreBuyScreen {

	private JFrame frame;
	private GameManager gameManager;
	private Store store;
	private Game game;
	
	public StoreBuyScreen(GameManager gameManager, Game game) {
		this.gameManager = gameManager;
		this.game = game;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreBuyScreen window = new StoreBuyScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoreBuyScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 913, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblStoreDetails = new JLabel("asdasd");
		
		lblStoreDetails.setText(store.getName() + " | " + store.getStoreType().getName());
		
		lblStoreDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblStoreDetails = new GridBagConstraints();
		gbc_lblStoreDetails.insets = new Insets(0, 0, 5, 0);
		gbc_lblStoreDetails.gridx = 1;
		gbc_lblStoreDetails.gridy = 1;
		frame.getContentPane().add(lblStoreDetails, gbc_lblStoreDetails);
		
		JLabel lblInsctruction = new JLabel("Select the item you would like to purchase or press back.");
		lblInsctruction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblInsctruction = new GridBagConstraints();
		gbc_lblInsctruction.insets = new Insets(0, 0, 5, 0);
		gbc_lblInsctruction.gridx = 1;
		gbc_lblInsctruction.gridy = 2;
		frame.getContentPane().add(lblInsctruction, gbc_lblInsctruction);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JList listItems = new JList();
		scrollPane.setViewportView(listItems);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		frame.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnBuy = new JButton("  BUY  ");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnBuy);
		
		JLabel lblSpacer = new JLabel("                                                     ");
		panel.add(lblSpacer);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnBack);
	}

}
