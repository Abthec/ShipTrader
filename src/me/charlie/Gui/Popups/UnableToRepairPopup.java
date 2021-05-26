package me.charlie.Gui.Popups;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import me.charlie.Gui.Main.ActivitySelectorScreen;
import me.charlie.Gui.Main.ShipRepairScreen;

/**
 * A screen to block the player from repairing their ship and telling them why
 * they are being blocked.
 * 
 * @author charlie
 *
 */
public class UnableToRepairPopup {

	private JFrame frameUnableToRepair;
	private ActivitySelectorScreen activitySelectorWindow;
	private ShipRepairScreen shipRepairWindow;
	private String reason;
	private boolean launchedFromActivitySelectorScreen;

	/**
	 * Opens an UnableToRepairPopup from the ActivitySelectorScreen.
	 * 
	 * @param activitySelectorWindow the ActivitySelectorScreen that the popup was
	 *                               opened from.
	 * @param reason                 the reson the popup was opened.
	 */
	public UnableToRepairPopup(ActivitySelectorScreen activitySelectorWindow, String reason) {
		this.launchedFromActivitySelectorScreen = true;
		this.reason = reason;
		this.activitySelectorWindow = activitySelectorWindow;
		initialize();
		frameUnableToRepair.setVisible(true);
	}

	/**
	 * Opens an UnableToRepairPopup from the ShipRepairScreen.
	 * 
	 * @param shipRepairWindow the ShipRepairScreen that the popup was opened from.
	 * @param reason           the reason the popup was opened.
	 */
	public UnableToRepairPopup(ShipRepairScreen shipRepairWindow, String reason) {
		this.launchedFromActivitySelectorScreen = false;
		this.reason = reason;
		this.shipRepairWindow = shipRepairWindow;
		initialize();
		frameUnableToRepair.setVisible(true);
	}

	/**
	 * Closes the popup window.
	 */
	public void closeWindow() {
		frameUnableToRepair.dispose();
	}

	/**
	 * Calls to close the popup and also unhide the window that the popup was
	 * launched from.
	 */
	public void finishedWindow() {
		if (launchedFromActivitySelectorScreen) {
			activitySelectorWindow.getJFrame().setVisible(true);

		} else {
			shipRepairWindow.getJFrame().setVisible(true);
		}
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
