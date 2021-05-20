package me.charlie.Gui.Popups;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Gui.GameManager;
import me.charlie.Gui.Main.ActivitySelectorScreen;

public class UnableToUpgradePopup {

	private JFrame frameUnableToUpgradePopup;
	private ActivitySelectorScreen activitySelectionWindow;
	
	public UnableToUpgradePopup(ActivitySelectorScreen activitySelectionWindow) {
		this.activitySelectionWindow = activitySelectionWindow;
		initialize();
		frameUnableToUpgradePopup.setVisible(true);
	}

	public void closeWindow() {
		
	}
	
	public void finishedWindow() {
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnableToUpgradePopup window = new UnableToUpgradePopup();
					window.frameUnableToUpgradePopup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UnableToUpgradePopup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameUnableToUpgradePopup = new JFrame();
		frameUnableToUpgradePopup.setBounds(100, 100, 450, 300);
		frameUnableToUpgradePopup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
