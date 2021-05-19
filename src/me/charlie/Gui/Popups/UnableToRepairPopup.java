package me.charlie.Gui.Popups;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Gui.GameManager;
import me.charlie.Gui.Main.ActivitySelectorScreen;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnableToRepairPopup {

	private JFrame frameUnableToRepair;
	private ActivitySelectorScreen activitySelectorWindow;
	
	public UnableToRepairPopup(ActivitySelectorScreen activitySelectorWindow) {
		this.activitySelectorWindow = activitySelectorWindow;
		initialize();
		frameUnableToRepair.setVisible(true);
	}
	
	public void closeWindow() {
		frameUnableToRepair.dispose();
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
					UnableToRepairPopup window = new UnableToRepairPopup();
					window.frameUnableToRepair.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnableToRepairPopup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUnableToRepair = new JFrame();
		frameUnableToRepair.setResizable(false);
		frameUnableToRepair.setType(Type.POPUP);
		frameUnableToRepair.setBounds(100, 100, 450, 190);
		frameUnableToRepair.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameUnableToRepair.getContentPane().setLayout(null);
		
		JLabel lblUnableToRepair = new JLabel("Ship is already fully repaired.");
		lblUnableToRepair.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnableToRepair.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnableToRepair.setBounds(10, 11, 414, 46);
		frameUnableToRepair.getContentPane().add(lblUnableToRepair);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(10, 68, 414, 79);
		frameUnableToRepair.getContentPane().add(btnBack);
	}
}
