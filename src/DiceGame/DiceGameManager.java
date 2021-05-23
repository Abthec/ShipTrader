package DiceGame;

import java.util.Arrays;

;

public class DiceGameManager {
	int playScore;
	int handicap;
	int pirateScore;
	int playerTurnScore;
	int pirateTurnScore;
	int[] dice;
	
	private DiceGameRulesWindow diceGamesRulesWindow;
	private DiceGameSummaryWindow diceGameSummaryWindow;
	private DiceGameRollWindow diceGameRollWindow;
	
	public DiceGameManager(int handiCap) {
		playScore = handiCap;
		handicap = handiCap;
		pirateScore = 0;
		playerTurnScore = 0;
		pirateTurnScore = 0;
	}
	public int getHandicap() {
		return handicap;
	 }
	
	public int getPlayerScore() {
		return playScore;
	}
	
	public int getPlayerTurnScore() {
		return playerTurnScore;
	}
	
	public int getPirateScore() {
		return pirateScore;
	}
	public void Roll() {
		int [] Rolled = new int[2];
		Rolled[0] = (int)(Math.random()*6 +1);
		Rolled[1] = (int)(Math.random()*6 +1);
		dice = Rolled;
		
	}
	public int[] getDice() {
		return dice;
	}
	private int determineCase() {
		switch (Arrays.toString(this.dice)) {
			case "[1, 1]":
				return 1;
			case "[1, 2]": case "[1, 3]": case "[1, 4]": case "[1, 5]": case "[1, 6]": 
			case "[2, 1]": case "[3, 1]": case "[4, 1]": case "[5, 1]": case "[6, 1]":
				return 2;
			default:
				return 3;
		}
	}
	public void launchDiceGameRulesWindow() {
		DiceGameRulesWindow rulesWindow = new DiceGameRulesWindow(this);
		this.diceGamesRulesWindow = rulesWindow;
	}	
	public void closeRulesWindow(DiceGameRulesWindow diceGameRulesWindow) {
		diceGameRulesWindow.closeWindow();
		Roll();
		switch (determineCase()) {
		case 1:
			launchSnakeEyesWindow();
			break;
		case 2:
			launchRolledOneWindow();
			break;
		case 3:
			launchDiceGameRollWindow();
			break;
		}
	}
	public void launchDiceGameRollWindow() {
		DiceGameRollWindow rollWindow = new DiceGameRollWindow(this);
		this.diceGameRollWindow = rollWindow;
	}
	public void reRoll() {
		diceGameRollWindow.closeWindow();
		launchDiceGameRollWindow();
	}
	public void passTurn() {
		diceGameRollWindow.closeWindow();
		pirateTurn();
	}
	public void pirateTurn() {
		Roll();
		switch(determineCase()) {
		case 1:
			this.pirateScore = 0;
			this.pirateTurnScore = 0;
			break;
		case 2:
			this.pirateTurnScore = 0;
			break;
		case 3:
			this.pirateTurnScore = this.pirateTurnScore + dice[0] + dice[1];
			pirateScore = pirateScore + dice[0] + dice[1];
			double coinflip = Math.random();
			if ((pirateScore >= 50) || (coinflip <0.5)) {/** ensures the pirate doesn't accidentally go over 50 points and
			decides randomly to roll again or not */
			pirateTurn();
			}
			break;
		
		}
	}
	public void checkScore() {
		
	}
	public void launchDiceGameSummaryWindow() {
		DiceGameSummaryWindow summaryScreen = new DiceGameSummaryWindow(this);
		this.diceGameSummaryWindow = summaryScreen;
	}
	public void closeSummaryWindow(DiceGameSummaryWindow diceGameSummaryWindow) {
		diceGameSummaryWindow.closeWindow();
	}
	public void launchSnakeEyesWindow() {
		
	}
	private void launchRolledOneWindow() {
		
	}
}
