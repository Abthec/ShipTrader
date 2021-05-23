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
	private DiceGameRollWindow diceGameRollWindow;
	private DiceGameLossWindow diceGameLossWindow;
	private DiceGameVictoryWindow diceGameVictoryWindow;
	private SnakeEyesWindow snakeEyesWindow;
	private RolledOneWindow rolledOneWindow;
	private int penalty;
	
	public DiceGameManager(int handiCap) {
		playScore = handiCap;
		this.handicap = handiCap;
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
		this.dice = Rolled;
		
	}
	public int[] getDice() {
		return dice;
	}
	private int determineRoll() {
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
	public void playerRoll() {
		Roll();
		switch (determineRoll()) {
		case 1:
			playScore = handicap;
			playerTurnScore = 0;
			launchSnakeEyesWindow();
			break;
		case 2:
			playerTurnScore = 0;
			launchRolledOneWindow();
			break;
		case 3:
			playerTurnScore = playerTurnScore + dice[0] + dice[1];
			playScore = playScore +dice[0] +dice[1];
			if (playScore >= 100) {
				launchDiceGameVictoryWindow();
			} else {
			launchDiceGameRollWindow();}
			break;
		}
	}
	public void pirateTurn() {
		Roll();
		switch(determineRoll()) {
		case 1:
			this.pirateScore = 0;
			this.pirateTurnScore = 0;
			launchDiceGameRollWindow();
			break;
		case 2:
			this.pirateTurnScore = 0;
			launchDiceGameRollWindow();
			break;
		case 3:
			this.pirateTurnScore = this.pirateTurnScore + dice[0] + dice[1];
			this.pirateScore = this.pirateScore + dice[0] + dice[1];
			double coinflip = Math.random();
			if ((this.pirateScore <= 100) || (coinflip < 0.5)) {/** ensures the pirate doesn't accidentally go over 50 points and
			decides randomly to roll again or not */
			pirateTurn();
			} else if (this.pirateScore >= 100) {
				launchDiceGameLossWindow();
			} else { launchDiceGameRollWindow();
			}
			break;
		}
	}
	public void makePenalty() {
		int penalty = (int)(Math.random()*(750 - 250) + 250);
		this.penalty = penalty;
	}
	public int getPenalty() {
		return penalty;
	}
	public void launchDiceGameRulesWindow() {
		DiceGameRulesWindow rulesWindow = new DiceGameRulesWindow(this);
		this.diceGamesRulesWindow = rulesWindow;
	}	
	public void closeRulesWindow(DiceGameRulesWindow diceGameRulesWindow) {
		diceGamesRulesWindow.closeWindow();
		playerRoll();
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
	public void launchDiceGameLossWindow() {
		DiceGameLossWindow lossWindow = new DiceGameLossWindow(this);
		this.diceGameLossWindow = lossWindow;
	}
	public void closeLossWindow(DiceGameLossWindow diceGameLossWindow) {
		makePenalty();
		diceGameLossWindow.closeWindow();
	}
	public void launchSnakeEyesWindow() {
		SnakeEyesWindow snakeEyesWindow = new SnakeEyesWindow(this);
		this.snakeEyesWindow = snakeEyesWindow;
	}
	public void closeSnakeEyesWindow() {
		snakeEyesWindow.closeWindow();
		pirateTurn();
	}
	public void launchRolledOneWindow() {
		RolledOneWindow rolledOneWindow = new RolledOneWindow(this);
		this.rolledOneWindow = rolledOneWindow;
	}
	public void closeRolledOneWindow() {
		rolledOneWindow.closeWindow();
		pirateTurn();
	}
	private void launchDiceGameVictoryWindow() {
		penalty = 0;
		DiceGameVictoryWindow victoryWindow = new DiceGameVictoryWindow(this);
		this.diceGameVictoryWindow = victoryWindow;
	}
	public void closeVictoryWindow() {
		diceGameVictoryWindow.closeWindow();
	}
}
