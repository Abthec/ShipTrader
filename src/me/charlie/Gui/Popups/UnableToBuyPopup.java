package me.charlie.Gui.Popups;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Gui.Main.StoreOperations.StoreBuyScreen;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnableToBuyPopup {

	private JFrame frameUnableToBuyPopup;
	private StoreBuyScreen storeBuyWindow;
	private String reason;
	
	public UnableToBuyPopup(StoreBuyScreen storeBuyWindow, String reason) {
		this.storeBuyWindow = storeBuyWindow;
		this.reason = reason;
		initialize();
		frameUnableToBuyPopup.setVisible(true);
	}
	
	public void closeWindow() {
		frameUnableToBuyPopup.dispose();
	}
	
	public void finishedWindow() {
		closeWindow();
		storeBuyWindow.getJFrame().setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnableToBuyPopup window = new UnableToBuyPopup();
					window.frameUnableToBuyPopup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnableToBuyPopup() {
		initialize();
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
