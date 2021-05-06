package me.charlie.Island;

import me.charlie.Island.Island;
import me.charlie.RandomEvents.RandomEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Route {

    Island islandA;
    Island islandB;
    double distance;
    RandomEvent randomEvent;
    int travelTime;

    public Route(Island islandA, Island islandB) {
        this.islandA = islandA;
        this.islandB = islandB;
        this.randomEvent = new RandomEvent();
        this.distance = islandA.getCoordinate().getDistance(islandB.getCoordinate()) * randomEvent.getRandomEventRarity().getEventDistanceModifier();
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

    public String toString() {
        return "Route from " + this.islandA.getName() + " to " + this.islandB.getName() + ". This route is %.2f".formatted(this.getDistance()) +
                " km long.\n";
    }
}