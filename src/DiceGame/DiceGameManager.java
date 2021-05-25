package DiceGame;

import java.util.Arrays;

import me.charlie.Game.DiceGame;
import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Island.Route;
import me.charlie.Trader.Trader;

;

public class DiceGameManager {
	int playScore;
	int playerTurnScore;
	int handicap;
	int pirateScore;
	int[] dice;
	
	private GameManager gameManager;
	private Game game;
	private Route route;
	private Trader trader;
	private DiceGame diceGame;
	
	private DiceGameRulesWindow diceGamesRulesWindow;
	private DiceGameRollWindow diceGameRollWindow;
	private DiceGameLossWindow diceGameLossWindow;
	private DiceGameVictoryWindow diceGameVictoryWindow;
	private SnakeEyesWindow snakeEyesWindow;
	private RolledOneWindow rolledOneWindow;
	private PirateSummaryWindow pirateSummaryWindow;
	private int penalty
	;
	
	public DiceGameManager(GameManager gameManager, Game game, Route route,int handiCap, DiceGame diceGame) {
		this.game = game;
		this.gameManager = gameManager;
		this.route = route;
		this.trader = game.getTrader();
		this.diceGame = diceGame;
		
		this.playScore = handiCap;
		this.handicap = handiCap;
		this.pirateScore = 0;
		launchDiceGameRulesWindow();
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
	public int getPirateScore(){
		return pirateScore;
	}
	private void playerTurn() {
		int playerTotal = this.playScore;
		int handicap = this.handicap;
		switch (diceGame.PlayerTurn(playerTotal, handicap)) {
			case "Snake Eyes":
				launchSnakeEyesWindow();
				break;
			case "Rolled One": 
				launchRolledOneWindow();
			case "Vicotry":
				launchDiceGameVictoryWindow();
			case "Good Roll":
				int turnScore = this.playerTurnScore;
				int[] dice = diceGame.getDice();
				this.playerTurnScore = turnScore + dice[0] +dice[1];
				launchDiceGameRollWindow();
		}
	}
	private void pirateTurn() {
		int pirateTotal = this.pirateScore;
		int newScore = diceGame.PirateTurn(pirateTotal);
		this.pirateScore = newScore;
		if (this.pirateScore >= 100) {
			launchDiceGameLossWindow();
		} else { launchPirateSummaryWindow();
		}
	}
	public void makePenalty() {
		int penalty = (int)(Math.random()*(500) + 250);
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
		playerTurn();
	}
	public void launchDiceGameRollWindow() {
		DiceGameRollWindow rollWindow = new DiceGameRollWindow(this, diceGame);
		this.diceGameRollWindow = rollWindow;
	}
	public void reRoll() {
		diceGameRollWindow.closeWindow();
		playerTurn();
	}
	public void passTurn() {
		diceGameRollWindow.closeWindow();
		pirateTurn();
	}
	public void launchPirateSummaryWindow() {
		PirateSummaryWindow pirateSummaryWindow = new PirateSummaryWindow(this);
		this.pirateSummaryWindow = pirateSummaryWindow;
	}
	public void closePirateSummaryWindow() {
		pirateSummaryWindow.closeWindow();
		playerTurn();
	}
	public void launchDiceGameLossWindow() {
		DiceGameLossWindow lossWindow = new DiceGameLossWindow(this);
		this.diceGameLossWindow = lossWindow;
	}
	public void closeLossWindow(DiceGameLossWindow diceGameLossWindow) {
		makePenalty();
		if (game.getTrader().getMoney() < this.penalty) {
			//Game Over
		} else {
			game.getTrader().subtractMoney(this.penalty);
		}
		diceGameLossWindow.closeWindow();
		gameManager.launchArrivalScreen(route);

	}
	public void launchSnakeEyesWindow() {
		SnakeEyesWindow snakeEyesWindow = new SnakeEyesWindow(this);
		this.snakeEyesWindow = snakeEyesWindow;
	}
	public void closeSnakeEyesWindow() {
		snakeEyesWindow.closeWindow();
		int pirateTotal = this.pirateScore;
		diceGame.PirateTurn(pirateTotal);
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
		DiceGameVictoryWindow victoryWindow = new DiceGameVictoryWindow(this, diceGame);
		this.diceGameVictoryWindow = victoryWindow;
	}
	public void closeVictoryWindow() {
		diceGameVictoryWindow.closeWindow();
		gameManager.launchArrivalScreen(route);
	}
}
