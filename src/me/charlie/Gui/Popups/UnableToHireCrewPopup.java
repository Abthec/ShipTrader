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

public class UnableToHireCrewPopup {

	private JFrame frameUnableToHireCrewPopup;
	private ActivitySelectorScreen activitySelectorWindow;
	
	public UnableToHireCrewPopup( ActivitySelectorScreen activitySelectorWindow) {
		this.activitySelectorWindow = activitySelectorWindow;
		initialize();
		frameUnableToHireCrewPopup.setVisible(true);
	}
	
	public void closeWindow() {
		frameUnableToHireCrewPopup.dispose();
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
					UnableToHireCrewPopup window = new UnableToHireCrewPopup();
					window.frameUnableToHireCrewPopup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnableToHireCrewPopup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUnableToHireCrewPopup = new JFrame();
		frameUnableToHireCrewPopup.setUndecorated(true);
		frameUnableToHireCrewPopup.setBounds(100, 100, 450, 192);
		frameUnableToHireCrewPopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameUnableToHireCrewPopup.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Unable To Hire Crew.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 48);
		frameUnableToHireCrewPopup.getContentPane().add(lblNewLabel);
		
		JLabel lblCrewSizeMaxed = new JLabel("Crew size at capacity.");
		lblCrewSizeMaxed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrewSizeMaxed.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewSizeMaxed.setBounds(10, 70, 414, 48);
		frameUnableToHireCrewPopup.getContentPane().add(lblCrewSizeMaxed);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(10, 129, 414, 48);
		frameUnableToHireCrewPopup.getContentPane().add(btnBack);
	}

}
