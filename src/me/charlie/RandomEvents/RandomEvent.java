package me.charlie.RandomEvents;

import java.util.Random;

public class RandomEvent {

    RandomEventRarity randomEventRarity;
    RandomEventType randomEventType;
    private Random random = new Random();
    boolean eventOccurs;

    public RandomEvent() {
        this.randomEventRarity = RandomEventRarity.values()[random.nextInt(3)];
        this.randomEventType = RandomEventType.values()[random.nextInt(3)];
        this.eventOccurs = random.nextDouble() < this.getRandomEventRarity().getChanceOfEventOccurring();
    }

    public RandomEventRarity getRandomEventRarity() {
        return randomEventRarity;
    }

    public RandomEventType getRandomEventType() {
        return randomEventType;
    }

    public boolean doesEventOccur() {
        return eventOccurs;
    }

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