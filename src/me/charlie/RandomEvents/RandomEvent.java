package me.charlie.RandomEvents;

import java.util.Random;

public class RandomEvent {

    RandomEventRarity randomEventRarity;
    RandomEventType randomEventType;
    private Random random = new Random();

    public RandomEvent() {
        this.randomEventRarity = RandomEventRarity.values()[random.nextInt(3)];
        this.randomEventType = RandomEventType.values()[random.nextInt(3)];
    }

    public RandomEventRarity getRandomEventRarity() {
        return randomEventRarity;
    }

    public RandomEventType getRandomEventType() {
        return randomEventType;
    }
}
