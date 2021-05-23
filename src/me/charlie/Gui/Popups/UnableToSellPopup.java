package me.charlie.Gui.Popups;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Gui.Main.StoreOperations.StoreOptionsScreen;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnableToSellPopup {

	private JFrame frameUnableToSellPopup;
	private StoreOptionsScreen storeOptionsWindow;
	
	public UnableToSellPopup(StoreOptionsScreen storeOptionsWindow) {
		this.storeOptionsWindow = storeOptionsWindow;
		initialize();
		frameUnableToSellPopup.setVisible(true);
	}
	
	public void closeWindow() {
		frameUnableToSellPopup.dispose();
	}
	
	public void finishedWindow() {
		storeOptionsWindow.getJFrame().setVisible(true);
		closeWindow();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnableToSellPopup window = new UnableToSellPopup();
					window.frameUnableToSellPopup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnableToSellPopup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUnableToSellPopup = new JFrame();
		frameUnableToSellPopup.setUndecorated(true);
		frameUnableToSellPopup.setType(Type.POPUP);
		frameUnableToSellPopup.setBounds(100, 100, 450, 236);
		frameUnableToSellPopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUnableToSellPopup.getContentPane().setLayout(null);
		
		JLabel lblUnableToSell = new JLabel("Unable To Sell.");
		lblUnableToSell.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUnableToSell.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnableToSell.setBounds(10, 11, 430, 69);
		frameUnableToSellPopup.getContentPane().add(lblUnableToSell);
		
		JLabel lblReason = new JLabel("No items in cargo.");
		lblReason.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReason.setHorizontalAlignment(SwingConstants.CENTER);
		lblReason.setBounds(10, 91, 430, 55);
		frameUnableToSellPopup.getContentPane().add(lblReason);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(10, 157, 430, 69);
		frameUnableToSellPopup.getContentPane().add(btnBack);
	}
}