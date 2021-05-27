package DiceGame;

import me.charlie.Game.DiceGame;
import me.charlie.Game.Game;
import me.charlie.Gui.GameManager;
import me.charlie.Island.Route;
import me.charlie.Item.Item;

/**DiceGameManager controls and stores the variables required to play the dice game
 * It launches each of the corresponding windows in accordance to what is required
 * when the game is over it will carry on the game if the player wins or enact the penalty if they lose
 * if they can't afford the penalty it will launch the gameOver screen.
 * @author Josef
 */
public class DiceGameManager {
	int playScore;
	int playerTurnScore;
	int handicap;
	int pirateScore;

	private GameManager gameManager;
	private Game game;
	private Route route;
	private DiceGame diceGame;

	private DiceGameRulesWindow diceGamesRulesWindow;
	private DiceGameRollWindow diceGameRollWindow;
	private DiceGameLossWindow diceGameLossWindow;
	private DiceGameVictoryWindow diceGameVictoryWindow;
	private SnakeEyesWindow snakeEyesWindow;
	private RolledOneWindow rolledOneWindow;
	private PirateSummaryWindow pirateSummaryWindow;
	private int penalty;
	
	/** creates an instance of DiceGameManger
	 * @param gameManager the gameManager this belongs to
	 * @param game the game this belongs to
	 * @param route the route the player was on when they were attacked
	 * @param handiCap sets the floor of the player score
	 * @param diceGame the dice game instance that belongs to this one
	 */
	public DiceGameManager(GameManager gameManager, Game game, Route route, int handiCap, DiceGame diceGame) {
		this.game = game;
		this.gameManager = gameManager;
		this.route = route;
		this.diceGame = diceGame;
		this.playerTurnScore = 0;
		this.playScore = handiCap;
		this.handicap = handiCap;
		this.pirateScore = 0;
		launchDiceGameRulesWindow();
	} 
	/** returns the handicap
	 * @return int, handicap
	 */
	public int getHandicap() {
		return handicap;
	 }
	/**returns the players current total score
	 * @return int players total score
	 */
	public int getPlayerScore() {
		return playScore;
	}
	/** returns the players current turn score
	 * @return int, turn score
	 */
	public int getPlayerTurnScore() {
		return playerTurnScore;
	}
	/** returns the pirates current total score
	 * @return int, pirates  score
	 */
	public int getPirateScore() {
		return pirateScore;
	}
	/**
	 * Calls to the DiceGame.then alters the players turn and total values based on
	 * the string returned. it then calls the next function
	 */
	public void playerTurn() {
		int playerTotal = this.playScore;
		int handicap = this.handicap;
		switch (diceGame.PlayerTurn(playerTotal, handicap, this.playerTurnScore)) {
		case "Snake Eyes":
			this.playerTurnScore = 0;
			this.playScore = this.handicap;
			launchSnakeEyesWindow();
			break;
		case "Rolled One":
			this.playerTurnScore = 0;
			launchRolledOneWindow();
			break;
		case "Good Roll":
			int[] dice = diceGame.getDice();
			this.playerTurnScore += dice[0] + dice[1];
			playerTotal = playerTotal + dice[0] + dice[1];
			if (playerTotal >= 100) {
				launchDiceGameVictoryWindow();
			} else {
				launchDiceGameRollWindow();
			}
			break;
		case "Victory":
			launchDiceGameVictoryWindow();
			break;
		}
	}

	/**
	 * calls to the DiceGame.PirateTurn to create a new pirate score based on the
	 * one input into the function then passes back to the players turn unless the
	 * pirate has reached the score threshold
	 */
	public void pirateTurn() {
		int pirateTotal = this.pirateScore;
		int newScore = diceGame.PirateTurn(pirateTotal);
		this.pirateScore = newScore;
		if (newScore >= 100) {
			launchDiceGameLossWindow();
		} else {
			launchPirateSummaryWindow();
		}
	}

	/**
	 * generates a random number between 750 and 250 this is used as the gold taken
	 * if the player loses the dice game
	 */
	public void makePenalty() {
		int penalty = (int) (Math.random() * (250) + 250);
		this.penalty = penalty;
	}
	/** returns the penalty that is enacted if the player loses
	 * @return int, value of goods stolen if the player loses
	 */
	public int getPenalty() {
		return penalty;
	}
	/** launches the rules window
	 */
	public void launchDiceGameRulesWindow() {
		DiceGameRulesWindow rulesWindow = new DiceGameRulesWindow(this);
		this.diceGamesRulesWindow = rulesWindow;
	}	
	/**closes the rules window then starts the playerTurn function
	 * @param diceGameRulesWindow instance of the rulesWindow it is starting
	 */
	public void closeRulesWindow(DiceGameRulesWindow diceGameRulesWindow) {
		diceGamesRulesWindow.closeWindow();
		playerTurn();
	}
	/** launches the RollWindow
	 */
	public void launchDiceGameRollWindow() {
		DiceGameRollWindow rollWindow = new DiceGameRollWindow(this, diceGame);
		this.diceGameRollWindow = rollWindow;
	}
	/** closes the roll window and starts the playerTurn function again
	 */
	public void reRoll() {
		diceGameRollWindow.closeWindow();
		playerTurn();
	}
	/**
	 * this is the only time the players total score increases as you must lock in
	 * your turn score by ending your turn
	 * starts the pirates turn
	 */
	public void passTurn() {
		int playerTotal = this.playScore;
		this.playScore = playerTotal + this.playerTurnScore;
		this.playerTurnScore = 0;
		diceGameRollWindow.closeWindow();
		pirateTurn();
	}
	/** launches the pirate summary window
	 */
	public void launchPirateSummaryWindow() {
		PirateSummaryWindow pirateSummaryWindow = new PirateSummaryWindow(this);
		this.pirateSummaryWindow = pirateSummaryWindow;
	}
	/** closes the pirate summary window then starts playerTurn()
	 */
	public void closePirateSummaryWindow() {
		pirateSummaryWindow.closeWindow();
		playerTurn();
	}
	/** launches the lossWindow
	 */
	public void launchDiceGameLossWindow() {
		DiceGameLossWindow lossWindow = new DiceGameLossWindow(this);
		this.diceGameLossWindow = lossWindow;
	}
	/** applies the penalty, if the penalty is too great, the player loses the game
	 * closes the loss window
	 * if the player loses the game the game over screen is launched
	 * if the can afford the penalty they lose their items and arrive at the destination
	 * @param diceGameLossWindow, the window that belongs to this instance of diceGameManage 
	 */
	public void closeLossWindow(DiceGameLossWindow diceGameLossWindow) {
		makePenalty();
		int itemWeatlh = 0;

		for (Item item : game.getShip().getCurrentCargo()) {
			itemWeatlh += item.getBuyCost();
			item.setAsStolen();
			game.getShip().getReceipts().add(item);
		}

		if (itemWeatlh < penalty) {
			gameManager.launchGameoverScreen("Your items didn't satisfy the pirates!", true);
		} else {
			game.getShip().getCurrentCargo().clear();
			gameManager.launchArrivalScreen(route);
		}
		diceGameLossWindow.closeWindow();
	}
	/** launches the snake eyes Window
	 */
	public void launchSnakeEyesWindow() {
		SnakeEyesWindow snakeEyesWindow = new SnakeEyesWindow(this);
		this.snakeEyesWindow = snakeEyesWindow;
	}
	/** closes the snake eyes window
	 * starts the pirates turn
	 */
	public void closeSnakeEyesWindow() {
		snakeEyesWindow.closeWindow();
		pirateTurn();
	}
	/** launches the rolled one window
	 */
	public void launchRolledOneWindow() {
		RolledOneWindow rolledOneWindow = new RolledOneWindow(this);
		this.rolledOneWindow = rolledOneWindow;
	}
	/** closes the rolled one window
	 * starts the pirates turn
	 */
	public void closeRolledOneWindow() {
		rolledOneWindow.closeWindow();
		pirateTurn();
	}
	/** launches the victory window
	 */
	private void launchDiceGameVictoryWindow() {
		penalty = 0;
		DiceGameVictoryWindow victoryWindow = new DiceGameVictoryWindow(this, diceGame);
		this.diceGameVictoryWindow = victoryWindow;
	}
	/** closes the victory window
	 * arrives the player at their location
	 */
	public void closeVictoryWindow() {
		diceGameVictoryWindow.closeWindow();
		gameManager.launchArrivalScreen(route);
	}
}
