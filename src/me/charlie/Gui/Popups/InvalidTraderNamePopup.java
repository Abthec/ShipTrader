package me.charlie.Gui.Popups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import me.charlie.Gui.GameManager;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class InvalidTraderNamePopup {

	private JFrame frameInvalidTraderNamePopup;
	private GameManager gameManager;
	
	public InvalidTraderNamePopup(GameManager gameManager) {
		this.gameManager = gameManager;
		initialize();
		frameInvalidTraderNamePopup.setVisible(true);
	}
	
	public void closeWindow() {
		frameInvalidTraderNamePopup.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeInvalidTraderNamePopup(this);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvalidTraderNamePopup window = new InvalidTraderNamePopup();
					window.frameInvalidTraderNamePopup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InvalidTraderNamePopup() {
		initialize();
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
