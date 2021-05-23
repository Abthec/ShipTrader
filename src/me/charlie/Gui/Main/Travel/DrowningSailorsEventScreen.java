package me.charlie.Gui.Main.Travel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Island.Route;
import me.charlie.Trader.Trader;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class DrowningSailorsEventScreen {

	private JFrame frameDrowningSailorsEventScreen;
	private GameManager gameManager;
	private Game game;
	private Route route;
	private Trader trader;
	private Random random = new Random();
	private int sailorsSaved;
	private JLabel lblOutcome;
	private JLabel lblUpdatedWalletAndCrewStatus;
	
	public DrowningSailorsEventScreen(GameManager gameManager, Game game, Route route) {
		this.gameManager = gameManager;
		this.game = game;
		this.route = route;
		this.trader = game.getTrader();
		this.sailorsSaved = 1 + random.nextInt(2);
		initialize();
		frameDrowningSailorsEventScreen.setVisible(true);
	}
	
	public void closeWindow() {
		frameDrowningSailorsEventScreen.dispose();
	}
	
	public void finishedWindow() {
		gameManager.closeDrowningSailorsEventScreen(this, route);
	}
	
	public int sailorsJoinCrew() {
		int crewHired = 0;
		for (int i=0; i<sailorsSaved; i++) {
			if (game.getShip().getCurrentCrewSize() < game.getShip().getMaxCrewSize()) {
				game.getShip().hireCrewMember();
				crewHired++;
			}
		}
		return crewHired;
	}
	
	public int giveReward() {
		trader.addMoney(sailorsSaved*100);
		return sailorsSaved*100;
	}
	
	public void setOutcomeText(int crewAquired, int moneyAquired) {
		lblOutcome.setText("The sailors gave you " + moneyAquired 
				+ " coins as a reward.\n" + crewAquired + " sailors also joined your crew.");
	}
	
	public void setUpdatedStatsText() {
		lblUpdatedWalletAndCrewStatus.setText("Current wallet is " + trader.getMoney() 
				+ " coins.\n" + "Current crew size is " + game.getShip().getCurrentCrewSize() + ".");
	}
	
	public void leaveToDrown() {
		lblOutcome.setText("You left the sailors!");
	}
	
	public JFrame getJFrame() {
		return frameDrowningSailorsEventScreen;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrowningSailorsEventScreen window = new DrowningSailorsEventScreen();
					window.frameDrowningSailorsEventScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DrowningSailorsEventScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameDrowningSailorsEventScreen = new JFrame();
		frameDrowningSailorsEventScreen.setBounds(100, 100, 667, 296);
		frameDrowningSailorsEventScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 32, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frameDrowningSailorsEventScreen.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("While sailing you encountered " + this.sailorsSaved + " drowning sailors!\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frameDrowningSailorsEventScreen.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblSpacer1 = new JLabel("                                       ");
		GridBagConstraints gbc_lblSpacer1 = new GridBagConstraints();
		gbc_lblSpacer1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer1.gridx = 1;
		gbc_lblSpacer1.gridy = 2;
		frameDrowningSailorsEventScreen.getContentPane().add(lblSpacer1, gbc_lblSpacer1);
		
		JLabel lblNewLabel_1 = new JLabel("The sailors say if you save them they will give you a reward and offer to join your crew.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		frameDrowningSailorsEventScreen.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblSpacer2 = new JLabel("                                       ");
		GridBagConstraints gbc_lblSpacer2 = new GridBagConstraints();
		gbc_lblSpacer2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpacer2.gridx = 1;
		gbc_lblSpacer2.gridy = 4;
		frameDrowningSailorsEventScreen.getContentPane().add(lblSpacer2, gbc_lblSpacer2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 5;
		frameDrowningSailorsEventScreen.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int moneyAquired = giveReward();
				int crewAquired = sailorsJoinCrew();
				setOutcomeText(crewAquired, moneyAquired);
				setUpdatedStatsText();
				finishedWindow();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnNewButton);
		
		JLabel lblSpacer3 = new JLabel("                                       ");
		panel.add(lblSpacer3);
		
		JButton btnNewButton_1 = new JButton("LEAVE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leaveToDrown();
				finishedWindow();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnNewButton_1);
		
		JLabel lblOutcome_1 = new JLabel("  ");
		lblOutcome_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.lblOutcome = lblOutcome_1;
		GridBagConstraints gbc_lblOutcome_1 = new GridBagConstraints();
		gbc_lblOutcome_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblOutcome_1.gridx = 1;
		gbc_lblOutcome_1.gridy = 6;
		frameDrowningSailorsEventScreen.getContentPane().add(lblOutcome_1, gbc_lblOutcome_1);
		
		JLabel lblUpdatedWalletAndCrewStatus = new JLabel("  ");
		lblUpdatedWalletAndCrewStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.lblUpdatedWalletAndCrewStatus = lblUpdatedWalletAndCrewStatus;
		GridBagConstraints gbc_lblUpdatedWalletAndCrewStatus = new GridBagConstraints();
		gbc_lblUpdatedWalletAndCrewStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblUpdatedWalletAndCrewStatus.gridx = 1;
		gbc_lblUpdatedWalletAndCrewStatus.gridy = 8;
		frameDrowningSailorsEventScreen.getContentPane().add(lblUpdatedWalletAndCrewStatus, gbc_lblUpdatedWalletAndCrewStatus);
	}

}
