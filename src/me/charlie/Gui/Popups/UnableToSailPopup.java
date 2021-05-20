package me.charlie.Gui.Popups;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Gui.Main.ActivitySelectorScreen;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnableToSailPopup {

	private JFrame frameUnableToSailPopup;
	private ActivitySelectorScreen activitySelectorWindow;
	
	public UnableToSailPopup(ActivitySelectorScreen activitySelectorWindow) {
		this.activitySelectorWindow = activitySelectorWindow;
		initialize();
		frameUnableToSailPopup.setVisible(true);
	}
	
	public void closeWindow() {
		frameUnableToSailPopup.dispose();
	}

	public void finishedWindow() {
		activitySelectorWindow.getJFrame().setVisible(true);
		closeWindow();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnableToSailPopup window = new UnableToSailPopup();
					window.frameUnableToSailPopup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnableToSailPopup() {
		initialize();
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
		lblUnableToSail.setBounds(0, 11, 434, 50);
		frameUnableToSailPopup.getContentPane().add(lblUnableToSail);
		
		JLabel lblYouMustRepair = new JLabel("You must repair your ship before setting out.");
		lblYouMustRepair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYouMustRepair.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouMustRepair.setBounds(0, 72, 434, 50);
		frameUnableToSailPopup.getContentPane().add(lblYouMustRepair);
		
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