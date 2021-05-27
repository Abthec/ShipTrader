package me.charlie.Gui.Popups;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import me.charlie.Gui.Main.StoreOperations.StoreBuyScreen;

/**
 * A screen to block the player from buying an item and let them know why they
 * are being blocked.
 * 
 * @author charlie
 *
 */
public class UnableToBuyPopup {

	private JFrame frameUnableToBuyPopup;
	private StoreBuyScreen storeBuyWindow;
	private String reason;

	/**
	 * Opens an UnableToBuy popup.
	 * 
	 * @param storeBuyWindow the window the popup was opened from.
	 * @param reason         the reason the popup was opened.
	 */
	public UnableToBuyPopup(StoreBuyScreen storeBuyWindow, String reason) {
		this.storeBuyWindow = storeBuyWindow;
		this.reason = reason;
		initialize();
		frameUnableToBuyPopup.setVisible(true);
	}

	/**
	 * Closes the popup window.
	 */
	public void closeWindow() {
		frameUnableToBuyPopup.dispose();
	}

	/**
	 * Calls to close the window and unhides the StoreBuyScreen.
	 */
	public void finishedWindow() {
		closeWindow();
		storeBuyWindow.getJFrame().setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUnableToBuyPopup = new JFrame();
		frameUnableToBuyPopup.setUndecorated(true);
		frameUnableToBuyPopup.setBounds(100, 100, 450, 211);
		frameUnableToBuyPopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUnableToBuyPopup.getContentPane().setLayout(null);

		JLabel lblHeading = new JLabel("Unable To Purchase Item");
		lblHeading.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setBounds(10, 11, 430, 60);
		frameUnableToBuyPopup.getContentPane().add(lblHeading);

		JLabel lblReason = new JLabel("Reason");

		lblReason.setText(reason);

		lblReason.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReason.setHorizontalAlignment(SwingConstants.CENTER);
		lblReason.setBounds(10, 68, 430, 60);
		frameUnableToBuyPopup.getContentPane().add(lblReason);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(10, 139, 430, 60);
		frameUnableToBuyPopup.getContentPane().add(btnBack);
	}

}
