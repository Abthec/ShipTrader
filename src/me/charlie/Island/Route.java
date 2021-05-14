package me.charlie.Island;

import me.charlie.Island.Island;
import me.charlie.RandomEvents.RandomEvent;
import me.charlie.Ship.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Route {

    Island islandA;
    Island islandB;
    double distance;
    RandomEvent randomEvent;
    int sailDuration;
    int sailCost;

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

    public int getSailDuration(Ship ship) {
        double shipSpeed = ship.getSailSpeed() + ship.getCrewFullness() - ship.getCargoFullness();
        sailDuration = (int)Math.round(this.getDistance() / shipSpeed);
        if (sailDuration == 0) {
            sailDuration = 1;
        }
        return sailDuration;
    }

    public int getSailCost(Ship ship) {
        sailCost = ship.getCurrentCrewSize() * 10;
        return sailCost;
    }

    public String toString(Ship ship) {
        return "Route to " + this.islandB.getName() + ". This route is %.2f".formatted(this.getDistance()) +
                " km long and will take you " + this.getSailDuration(ship) + " days to sail.";
    }
}