package me.charlie.RandomEvents;

import java.util.Random;

/**
 * Stores information about random events that occur on Routes.
 * 
 * @author charlie
 *
 */
public class RandomEvent {

	private RandomEventRarity randomEventRarity;
	private RandomEventType randomEventType;
	private Random random = new Random();
	private boolean eventOccurs;

	/**
	 * Creates an instance of RandomEvent. Assigns randomEventRarity to a random
	 * randomEventRarity. Assigns randomEventType to a random randomEventType.
	 */
	public RandomEvent() {
		this.randomEventRarity = RandomEventRarity.values()[random.nextInt(3)];
		this.randomEventType = RandomEventType.values()[random.nextInt(3)];
	}

	/**
	 * 
	 * @return the rarity of the given RandomEvent.
	 */
	public RandomEventRarity getRandomEventRarity() {
		return randomEventRarity;
	}

	/**
	 * 
	 * @return the type of a given RandomEvent.
	 */
	public RandomEventType getRandomEventType() {
		return randomEventType;
	}

	/**
	 * Gets a random double between 0 and 1 and checks if it is smaller than the
	 * RandomEvent's RandomEventRarity.
	 * 
	 * @return true if the RandomEvent occurs and false otherwise.
	 */
	public boolean doesEventOccur() {
		this.eventOccurs = random.nextDouble() < this.getRandomEventRarity().getChanceOfEventOccurring();
		return eventOccurs;
	}

	/**
	 * Prints a different string depending on the RandomEventType.
	 */
	public void eventOccurs() {
		switch (this.getRandomEventType()) {
		case PIRATES:
			System.out.println("You are attacked by pirates!");
		case STORMY_WEATHER:
			System.out.println("You encounter bad weather!");
		case DROWNING_SAILORS:
			System.out.println("You encounter sailors in the water!");
		}
	}

	/**
	 * Converts a RandomEvent object to a String depending on RandomEventType.
	 */
	public String toString() {
		switch (this.getRandomEventType()) {
		case STORMY_WEATHER:
			return "You may encounter bad weather on this route.";
		case DROWNING_SAILORS:
			return "You may encounter sailors in the water on this route.";
		case PIRATES:
			return "You may encounter pirates on this route.";
		}
		return "This route seems perfectly normal.";
	}
}