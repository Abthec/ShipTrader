package me.charlie.Gui.Popups;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Gui.GameManager;
import me.charlie.Gui.Main.ActivitySelectorScreen;
import me.charlie.Gui.Main.ShipRepairScreen;

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
	private ShipRepairScreen shipRepairWindow;
	private String reason;
	
	public UnableToRepairPopup(ActivitySelectorScreen activitySelectorWindow, String reason) {
		this.reason = reason;
		this.activitySelectorWindow = activitySelectorWindow;
		initialize();
		frameUnableToRepair.setVisible(true);
	}
	
	public UnableToRepairPopup(ShipRepairScreen shipRepairWindow, String reason) {
		this.reason = reason;
		this.shipRepairWindow = shipRepairWindow;
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
		frameUnableToRepair.setUndecorated(true);
		frameUnableToRepair.setResizable(false);
		frameUnableToRepair.setType(Type.POPUP);
		frameUnableToRepair.setBounds(100, 100, 439, 240);
		frameUnableToRepair.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameUnableToRepair.getContentPane().setLayout(null);
		
		JLabel lblUnableToRepair = new JLabel("Ship is already fully repaired.");
		lblUnableToRepair.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnableToRepair.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUnableToRepair.setBounds(10, 11, 414, 60);
		frameUnableToRepair.getContentPane().add(lblUnableToRepair);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(10, 153, 414, 79);
		frameUnableToRepair.getContentPane().add(btnBack);
		
		JLabel lblReason = new JLabel("reason");
		lblReason.setText(reason);
		lblReason.setHorizontalAlignment(SwingConstants.CENTER);
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReason.setBounds(10, 82, 414, 60);
		frameUnableToRepair.getContentPane().add(lblReason);
	}
}
