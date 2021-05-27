package me.charlie.RandomEvents;

/**
 * Gives the random events characteristics depending on rarity.
 * 
 * @author charl
 *
 */
public enum RandomEventRarity {

	COMMON, UNCOMMON, RARE;

	/**
	 * 
	 * @return the coefficient of distance depending on the rarity of the event.
	 */
	public double getEventDistanceModifier() {
		switch (this) {
		case RARE:
			return 1.0;
		case UNCOMMON:
			return 0.75;
		case COMMON:
			return 0.5;
		}
		return 1.0;
	}

	/**
	 * 
	 * @return the chance of an event occurring for each RandomEventRarity.
	 */
	public double getChanceOfEventOccurring() {
		switch (this) {
		case RARE:
			return 0.1;
		case UNCOMMON:
			return 0.6;
		case COMMON:
			return 0.8;
		}
		return 1.0;
	}
}
