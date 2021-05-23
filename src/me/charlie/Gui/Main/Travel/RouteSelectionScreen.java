package me.charlie.Gui.Main.Travel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Gui.Popups.UnableToSailPopup;
import me.charlie.Island.Route;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.util.List;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class RouteSelectionScreen {

	private JFrame frameRouteSelectionScreen;
	private Game game;
	private GameManager gameManager;
	private List<Route> routes;
	private Route chosenRoute;
	
	public RouteSelectionScreen(GameManager gameManager, Game game) {
		this.game = game;
		this.gameManager = gameManager;
		this.routes = game.getRoutes();
		initialize();
		frameRouteSelectionScreen.setVisible(true);
	}
	
	public void closeWindow() {
		frameRouteSelectionScreen.dispose();
	}
	
	public void finishedWindow(Route chosenRoute) {
		if (chosenRoute.getRandomEvent().doesEventOccur()) {
			switch(chosenRoute.getRandomEvent().getRandomEventType()) {
				case STORMY_WEATHER:
					gameManager.launchStormyWeatherEventScreen(chosenRoute);
					closeWindow();
					break;
				case PIRATES:
					gameManager.launchPiratesEventScreen(chosenRoute);
					closeWindow();
					break;
				case DROWNING_SAILORS:
					gameManager.launchDrowningSailorsEventScreen(chosenRoute);
					closeWindow();
			}
		} else {
			gameManager.closeRouteSelectionScreen(this, chosenRoute);
		}
	}
	
	public void launchUnableToSailPopup() {
		UnableToSailPopup unableToSailPopup = new UnableToSailPopup(this, "Not enough days remaining");
	}
	
	public void goBack() {
		gameManager.launchActivitySelectorScreen();
		closeWindow();
	}

	public JFrame getJFrame() {
		return frameRouteSelectionScreen;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RouteSelectionScreen window = new RouteSelectionScreen();
					window.frameRouteSelectionScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RouteSelectionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameRouteSelectionScreen = new JFrame();
		frameRouteSelectionScreen.setBounds(100, 100, 800, 620);
		frameRouteSelectionScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frameRouteSelectionScreen.getContentPane().setLayout(gridBagLayout);
		
		DefaultListModel listModel = new DefaultListModel();

		for (int i=0 ; i < routes.size() ; i++) {
			Route route = routes.get(i);
			String routeString = "  Route from " + route.getIslandA().getName() + " to " + route.getIslandB().getName() + 
					" | " + "Route duration: " + route.getSailDuration(game.getShip()) + " | " +
					"Random Event Chance: " + (route.getRandomEvent().getRandomEventRarity().getChanceOfEventOccurring()*100) + " %";
			listModel.add(i, routeString);
		}
		
		JLabel lblNewLabel = new JLabel("Select A Route!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frameRouteSelectionScreen.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		frameRouteSelectionScreen.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JList listRoutes = new JList();
		listRoutes.setModel(listModel);
		scrollPane.setViewportView(listRoutes);
		
		JButton btnConfirmRouteSelection = new JButton("SET SAIL!");
		btnConfirmRouteSelection.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmRouteSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chosenRouteIndex = listRoutes.getSelectedIndex();
				chosenRoute = routes.get(chosenRouteIndex);
				if (chosenRoute.getSailDuration(game.getShip()) > game.getDaysRemaining()) {
					launchUnableToSailPopup();
				} else {
					finishedWindow(chosenRoute);
				}
			}
		});
		GridBagConstraints gbc_btnConfirmRouteSelection = new GridBagConstraints();
		gbc_btnConfirmRouteSelection.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmRouteSelection.gridx = 1;
		gbc_btnConfirmRouteSelection.gridy = 5;
		frameRouteSelectionScreen.getContentPane().add(btnConfirmRouteSelection, gbc_btnConfirmRouteSelection);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 1;
		gbc_btnBack.gridy = 6;
		frameRouteSelectionScreen.getContentPane().add(btnBack, gbc_btnBack);
	}

}
