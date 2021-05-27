package me.charlie.RandomEvents;

/**
 * Controls what kind of random events will be encountered.
 * 
 * @author charl
 *
 */
public enum RandomEventType {

	PIRATES, STORMY_WEATHER, DROWNING_SAILORS;

	/**
	 * 
	 * @return the the RandomEventType as a formatted string.
	 */
	public String getName() {
		return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
	}
}
