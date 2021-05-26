package me.charlie.Game;

/**
 * The game the player must play during a pirate encounter.
 * 
 * @author josef.
 *
 */
public class DiceGame {

	int playerScore;
	int pirateScore;
	int handicap;
	int[] dice;

	public DiceGame(int Handicap) {
		playerScore = Handicap;
		pirateScore = 0;
		handicap = Handicap;
	}

	public void Roll() {
		int[] Dice = new int[2];
		Dice[0] = (int) (Math.random() * 6 + 1);
		Dice[1] = (int) (Math.random() * 6 + 1);
		this.dice = Dice;
	}

	public int[] getDice() {
		return dice;
	}

	/**
	 * rolls the dice and returns a string based on the outcome
	 */
	public String PlayerTurn(int PlayerScore, int HC, int turnScore) {
		int TurnValue = turnScore;
		int total = PlayerScore;
		int handicap = HC;

		Roll();

		if (total < handicap) {/** ensures the starting total is not less than the handicap */
			total = handicap;
		}
		int[] Dice = this.dice;
		if ((Dice[0] == 1) && (Dice[1] == 1)) {
			/**
			 * Player rolled two ones, turn fails total score is reset to zero
			 */
			System.out.println("You rolled Snake Eyes, your score is now " + handicap + "!");
			TurnValue = 0;
			total = handicap; // returns the player total to the handicap value
			return "Snake Eyes";
		} else if ((Dice[0] == 1) || (Dice[1] == 1)) {
			/**
			 * Player rolled at least one one and the turn is over
			 */
			System.out.println("You rolled a " + Dice[0] + " and " + Dice[1]);
			System.out.println("You rolled a one, your turn is over. You get zero points points this turn.");
			TurnValue = 0;
			return "Rolled One";
		} else {
			/**
			 * Roll is added to turn score
			 */
			TurnValue = TurnValue + Dice[0] + Dice[1];
			System.out.println("You rolled a " + Dice[0] + " and " + Dice[1]);
			System.out.println("Your score this turn so far is: " + TurnValue);
			System.out.println("Your total is: " + total);
			if (TurnValue + total > 100) {
				return "Victory";
			} else {
				return "Good Roll";
			}
		}
	}

	/**
	 * Pirates rolls the dice, if the roll is good, a random number between 0 and
	 * 0.99 is generated. this is used to randomly decide if the pirates roll again
	 * or lock in their score.
	 **/
	public int PirateTurn(int PirateScore) {
		int total = PirateScore;
		int turnValue = 0;
		boolean F = false;
		while (F == false) {
			Roll();
			System.out.println(String.format("The pirates roll is: %d, %d", dice[0], dice[1]));
			int[] Dice = this.dice;
			if ((Dice[0] == 1)
					&& (Dice[1] == 1)) {/** Pirate rolled two ones, turn fails total score is reset to zero */
				total = 0;
				F = true;
			} else if ((Dice[0] == 1) || (Dice[1] == 1)) {
				/**
				 * Pirate rolled at least one one and the turn is over
				 */
				turnValue = 0;
				total += turnValue;
				F = true;
			} else {
				turnValue = turnValue + Dice[0] + Dice[1];
				total += turnValue;
				double coinflip = Math.random();
				if ((total >= 100) || (coinflip < 0.5)) {/**
															 * ensures the pirate doesn't accidentally go over 50 points
															 * and decides randomly to roll again or not
															 */
					F = true;
				}
				System.out.println(String.format("Pirate turn value is : %d", turnValue));
			}
		}
		return total;
	}
}
