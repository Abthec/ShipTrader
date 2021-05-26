package me.charlie.Gui.Popups;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import me.charlie.Gui.Main.ActivitySelectorScreen;
import me.charlie.Gui.Main.ShipUpgradeScreen;

/**
 * A screen to block the player from upgrading their ship and tell them why they
 * cannot upgrade.
 * 
 * @author charlie
 *
 */
public class UnableToUpgradePopup {

	private JFrame frameUnableToUpgradePopup;
	private ActivitySelectorScreen activitySelectionWindow;
	private ShipUpgradeScreen shipUpgradeWindow;
	private int returnCode;
	private String reason;

	/**
	 * Opens an UnableToUpgradePopup from the ActivitySelectorScreen.
	 * 
	 * @param activitySelectionWindow the ActivitySelectorScreen the popup was
	 *                                opened from.
	 * @param reason                  the reason the popup was opened.
	 */
	public UnableToUpgradePopup(ActivitySelectorScreen activitySelectionWindow, String reason) {
		this.returnCode = 0;
		this.reason = reason;
		this.activitySelectionWindow = activitySelectionWindow;
		initialize();
		frameUnableToUpgradePopup.setVisible(true);
	}

	/**
	 * Opens an UnableToUpgradePopup from the ShipUpgradeScreen.
	 * 
	 * @param shipUpgradeWindow the ShipUpgradeScreen that the popup was opened
	 *                          from.
	 * @param reason            the reason the popup was opened.
	 */
	public UnableToUpgradePopup(ShipUpgradeScreen shipUpgradeWindow, String reason) {
		this.returnCode = 1;
		this.reason = reason;
		this.shipUpgradeWindow = shipUpgradeWindow;
		initialize();
		frameUnableToUpgradePopup.setVisible(true);
	}

	/**
	 * Unhides the ActivitySelectorScreen and calls to close the window.
	 */
	public void launchActivitySelectionWindow() {
		activitySelectionWindow.getJFrame().setVisible(true);
		closeWindow();
	}

	/**
	 * Unides the ShipUpgradeScreen and calls to close the window.
	 */
	public void launchShipUpgradeScreen() {
		shipUpgradeWindow.getJFrame().setVisible(true);
		closeWindow();
	}

	/**
	 * Closes the popup window.
	 */
	public void closeWindow() {
		frameUnableToUpgradePopup.dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnableToUpgradePopup window = new UnableToUpgradePopup();
					window.frameUnableToUpgradePopup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnableToUpgradePopup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUnableToUpgradePopup = new JFrame();
		frameUnableToUpgradePopup.setUndecorated(true);
		frameUnableToUpgradePopup.setBounds(100, 100, 470, 160);
		frameUnableToUpgradePopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUnableToUpgradePopup.getContentPane().setLayout(null);

		JLabel lblNoUpgradesAvailable = new JLabel("You do not currently posses any upgrades.");
		lblNoUpgradesAvailable.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNoUpgradesAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoUpgradesAvailable.setBounds(0, 0, 454, 32);
		frameUnableToUpgradePopup.getContentPane().add(lblNoUpgradesAvailable);

		JLabel lblReason = new JLabel(reason);
		lblReason.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReason.setHorizontalAlignment(SwingConstants.CENTER);
		lblReason.setBounds(0, 43, 454, 40);
		frameUnableToUpgradePopup.getContentPane().add(lblReason);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (returnCode == 0) {
					launchActivitySelectionWindow();
				} else if (returnCode == 1) {
					launchShipUpgradeScreen();
				}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(10, 94, 434, 54);
		frameUnableToUpgradePopup.getContentPane().add(btnBack);
	}
}
