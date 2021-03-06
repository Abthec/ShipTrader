package me.charlie.Gui.Popups;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import me.charlie.Gui.GameManager;

/**
 * A screen to tell the player they entered an invalid name.
 * 
 * @author charlie
 *
 */
public class InvalidTraderNamePopup {

	private JFrame frameInvalidTraderNamePopup;
	private GameManager gameManager;

	/**
	 * Opens an InvalidTraderNamePopup.
	 * 
	 * @param gameManager controls the launching and closing of the popup.
	 */
	public InvalidTraderNamePopup(GameManager gameManager) {
		this.gameManager = gameManager;
		initialize();
		frameInvalidTraderNamePopup.setVisible(true);
	}

	/**
	 * Closes the popup window.
	 */
	public void closeWindow() {
		frameInvalidTraderNamePopup.dispose();
	}

	/**
	 * Calls gameManager to close the window.
	 */
	public void finishedWindow() {
		gameManager.closeInvalidTraderNamePopup(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameInvalidTraderNamePopup = new JFrame();
		frameInvalidTraderNamePopup.setUndecorated(true);
		frameInvalidTraderNamePopup.setType(Type.POPUP);
		frameInvalidTraderNamePopup.setBounds(100, 100, 273, 170);
		frameInvalidTraderNamePopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInvalidTraderNamePopup.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Invalid Trader Name.");
		lblNewLabel.setBounds(31, 17, 215, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		frameInvalidTraderNamePopup.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Please Try Again.");
		lblNewLabel_1.setBounds(87, 47, 113, 17);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frameInvalidTraderNamePopup.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewButton.setBounds(87, 101, 95, 33);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		frameInvalidTraderNamePopup.getContentPane().add(btnNewButton);
	}

}
