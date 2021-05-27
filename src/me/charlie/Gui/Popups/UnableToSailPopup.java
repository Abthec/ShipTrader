package me.charlie.Gui.Popups;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Gui.Main.ActivitySelectorScreen;
import me.charlie.Gui.Main.Travel.RouteSelectionScreen;

/**
 * A screen to block the player from sailing and telling the player why they
 * cannot sail.
 * 
 * @author charlie
 *
 */
public class UnableToSailPopup {

	private JFrame frameUnableToSailPopup;
	private ActivitySelectorScreen activitySelectorWindow;
	private RouteSelectionScreen routeSelectionWindow;
	private String reason;
	private GameManager gameManager;
	private Game game;
	private boolean launchedByActivitySelector;

	/**
	 * Open an UnableToSailPopup from the ActivitySelectorScreen.
	 * 
	 * @param activitySelectorWindow the ActivitySelectorScreen that the popup was
	 *                               opened from.
	 * @param gameManager            where the ActivitySelectorScreen was opened.
	 * @param game                   the current instance of the Game.
	 * @param reason                 the reaosn the popup was launched.
	 */
	public UnableToSailPopup(ActivitySelectorScreen activitySelectorWindow, GameManager gameManager, Game game,
			String reason) {
		this.gameManager = gameManager;
		this.game = game;
		this.activitySelectorWindow = activitySelectorWindow;
		this.reason = reason;
		this.launchedByActivitySelector = true;
		initialize();
		frameUnableToSailPopup.setVisible(true);
	}

	/**
	 * Open an UnableToSailPopup from the RouteSelectionScreen.
	 * 
	 * @param routeSelectionWindow the RouteSelectionScreen that the popup was
	 *                             opened from.
	 * @param gameManager          where the RouteSelectionScreen was launched from.
	 * @param game                 the current instance of the Game.
	 * @param reason               the reaosn the popup was launched.
	 */
	public UnableToSailPopup(RouteSelectionScreen routeSelectionWindow, GameManager gameManager, Game game,
			String reason) {
		this.gameManager = gameManager;
		this.game = game;
		this.launchedByActivitySelector = false;
		this.routeSelectionWindow = routeSelectionWindow;
		this.reason = reason;
		initialize();
		frameUnableToSailPopup.setVisible(true);
	}

	/**
	 * Creates a new instance of ActivitySelectorScreen.
	 */
	public void launchActivitySelectorScreen() {
		ActivitySelectorScreen activitySelectorWindow = new ActivitySelectorScreen(gameManager, game);
		closeWindow();
	}

	/**
	 * Creates a new instance of RouteSelectionScreen.
	 */
	public void launchRouteSelectionWindow() {
		RouteSelectionScreen routeSelectionWindow = new RouteSelectionScreen(gameManager, game);
		closeWindow();
	}

	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		frameUnableToSailPopup.dispose();
	}

	/**
	 * Determines which of the two windows to open either RouteSelectionScreen or
	 * ActivitySelectorScreen.
	 */
	public void finishedWindow() {
		if (launchedByActivitySelector) {
			launchActivitySelectorScreen();
		} else {
			launchRouteSelectionWindow();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUnableToSailPopup = new JFrame();
		frameUnableToSailPopup.setUndecorated(true);
		frameUnableToSailPopup.setBounds(100, 100, 450, 200);
		frameUnableToSailPopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUnableToSailPopup.getContentPane().setLayout(null);

		JLabel lblUnableToSail = new JLabel("Unable To Sail.");
		lblUnableToSail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUnableToSail.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnableToSail.setBounds(10, 11, 424, 50);
		frameUnableToSailPopup.getContentPane().add(lblUnableToSail);

		JLabel lblUnableToSailReason = new JLabel("Reason");
		lblUnableToSailReason.setText(reason);
		lblUnableToSailReason.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUnableToSailReason.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnableToSailReason.setBounds(10, 72, 424, 50);
		frameUnableToSailPopup.getContentPane().add(lblUnableToSailReason);

		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setBounds(10, 133, 424, 50);
		frameUnableToSailPopup.getContentPane().add(btnBack);
	}

}
