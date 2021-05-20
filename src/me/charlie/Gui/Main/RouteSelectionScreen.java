package me.charlie.Gui.Main;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class RouteSelectionScreen {

	private JFrame frameRouteSelectionScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RouteSelectionScreen window = new RouteSelectionScreen();
					window.frameRouteSelectionScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RouteSelectionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameRouteSelectionScreen = new JFrame();
		frameRouteSelectionScreen.setBounds(100, 100, 450, 300);
		frameRouteSelectionScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
