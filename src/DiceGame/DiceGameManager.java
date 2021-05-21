package DiceGame;
;

public class DiceGameManager {
	int playScore;
	int handicap;
	int pirateScore;
	int playerTurnScore;
	int pirateTurnScore;
	private DiceGameRulesWindow diceGamesRulesWindow;
	private DiceGameSummaryWindow diceGameSummaryWindow;
	
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
	
	public void launchDiceGameRulesWindow() {
		DiceGameRulesWindow rulesWindow = new DiceGameRulesWindow(this);
		this.diceGamesRulesWindow = rulesWindow;
	}
	
	public void closeRulesWindow(DiceGameRulesWindow diceGameRulesWindow) {
		diceGameRulesWindow.closeWindow();
		launchDiceGameSummaryWindow();
	}
	
	public void launchDiceGameSummaryWindow() {
		DiceGameSummaryWindow.summaryWindow = new DiceGameSummaryWindow(this);
		this.diceGameSummaryWindow = summaryWindow;
		
	}
	public void closeSummaryWindow(DiceGameSummaryWindow diceGameSummaryWindow) {
		diceGameSummaryWindow.closeWindow();
	}
	public void rollDice() {
		
	}
	public void passTurn() {
		
	}
}
