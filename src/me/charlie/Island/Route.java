package me.charlie.Island;

import me.charlie.Island.Island;
import me.charlie.RandomEvents.RandomEvent;

import java.util.ArrayList;

public class Route {

    Island islandA;
    Island islandB;
    double distance;
    RandomEvent randomEvent;

    public Route(Island islandA, Island islandB) {
        this.islandA = islandA;
        this.islandB = islandB;
        this.distance = islandA.getCoordinate().getDistance(islandB.getCoordinate());
        this.randomEvent = new RandomEvent();
    }

    public Island getIslandA() {
        return islandA;
    }

    public Island getIslandB() {
        return islandB;
    }

    public RandomEvent getRandomEvent() {
        return randomEvent;
    }

    public double getDistance() {
        return distance;
    }
}
