package me.charlie.Game;

public class DiceGame {
	
	int playerScore;
	int pirateScore;
	int handicap;
	int[] dice;

	public DiceGame(int Handicap, int upgrades) {
		playerScore = Handicap;
		pirateScore = 0;
		handicap = Handicap;
	}
	public void Roll() {
		int [] Dice = new int[2];
		Dice[0] = (int)(Math.random()*6 +1);
		Dice[1] = (int)(Math.random()*6 +1);
		this.dice = Dice;
	}
	public int[] getDice() {
		return dice;
	}
	public String PlayerTurn(int PlayerScore, int HC) {
		/** Checks if the player wants to roll again, rolls and adds the sum to the turn total
		 */
		int TurnValue = 0;
		int total = PlayerScore;
		int handicap = HC;
		
		Roll();
		
		if (total < handicap) {/** ensures the starting total is not less than the handicap*/
			total = handicap;
		}
		int[] Dice = this.dice;
			if ((Dice[0] ==1) &&(Dice[1] ==1)) {
			/** Player rolled two ones, turn fails total score is reset to zero 
			*/
				System.out.println("You rolled Snake Eyes, your score is now Zero!");
				TurnValue = 0;
				total = handicap; //returns the player total to the handicap value
				return "Snake Eyes";
			} else if ((Dice[0] ==1) || (Dice[1] ==1)) {
			/** Player rolled at least one one and the turn is over
			 */
				System.out.println("You rolled a " + Dice[0] + " and " + Dice[1] );
				System.out.println("You rolled a one, your turn is over. You got " + TurnValue + " points this turn.");
				TurnValue = 0;
				return "Rolled One";
			} else {
			/** Roll is added to turn score
			*/
				TurnValue = TurnValue + Dice[0] + Dice[1];
				total = total + Dice[0] + Dice[1];
				System.out.println("You rolled a " + Dice[0] + " and " + Dice[1] );
				System.out.println("Your score this turn so far is: " + TurnValue);
				System.out.println("Your total is: " + total);
				if (total >= 100) { // makes sure the player doesn't get another turn once they reach 50 
					return "Vicotry";
				}	else {
					return "Good Roll";
				}
		}
	}
	public int PirateTurn(int PirateScore) {
		int total = PirateScore;
		int turnValue = 0;
		boolean F = false;
		while (F == false) {
			Roll();
			int[] Dice = this.dice;
			if ((Dice[0] ==1) &&(Dice[1] ==1)) {/** Pirate rolled two ones, turn fails total score is reset to zero */
				 total = 0;
				 F = true;
			}else if ((Dice[0] ==1) || (Dice[1] ==1)) {
				/** Pirate rolled at least one one and the turn is over
				 */
				turnValue = turnValue + Dice[0] + Dice[1];
				total += turnValue;
				F = true;
			} else {
				turnValue = turnValue + Dice[0] + Dice[1];
				total += turnValue;
				double coinflip = Math.random();
				if ((total >= 50) || (coinflip <0.5)) {/** ensures the pirate doesn't accidentally go over 50 points and
				decides randomly to roll again or not */
					F = true;
				}
			}
		}
		return total;
	}
}
