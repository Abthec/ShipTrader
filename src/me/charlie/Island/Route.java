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

    /**
     * Creates a Route between two Islands.
     * 
     * @param islandA the first Island on the Route.
     * @param islandB the destination Island on the Route.
     */
    public Route(Island islandA, Island islandB) {
        this.islandA = islandA;
        this.islandB = islandB;
        this.randomEvent = new RandomEvent();
        this.distance = islandA.getCoordinate().getDistance(islandB.getCoordinate()) * randomEvent.getRandomEventRarity().getEventDistanceModifier();
    }

    /**
     * 
     * @return the first Island on the Route.
     */
    public Island getIslandA() {
        return islandA;
    }

    /**
     * 
     * @return the second Island on the Route.
     */
    public Island getIslandB() {
        return islandB;
    }

    /**
     * 
     * @return the RandomEvent associated with the Route.
     */
    public RandomEvent getRandomEvent() {
        return randomEvent;
    }

    /**
     * 
     * @return the distance from the first Island to the second Island on the Route.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Calculates how many days should be deducted from the days remaining in the game.
     * 
     * @param ship the Ship chosen by the player.
     * @return the amount of days to remove from the remaining days.
     */
    public int getSailDuration(Ship ship) {
        double shipSpeed = ship.getSailSpeed() + ship.getCrewFullness() - ship.getCargoFullness();
        sailDuration = (int)Math.round(this.getDistance() / shipSpeed);
        if (sailDuration == 0) {
            sailDuration = 1;
        }
        return sailDuration;
    }

    /**
     * Calculates how much it will cost to pay the crew for one day.
     * 
     * @param ship the Ship the player chose.
     * @return the coins to be deducted from the Traders current total.
     */
    public int getSailCost(Ship ship) {
        sailCost = ship.getCurrentCrewSize() * 10;
        return sailCost;
    }

    /**
     * Convert a Route object to a String
     * 
     * @param ship the Ship chosen by the player.
     * @return the Route object converted to a String.
     */
    public String toString(Ship ship) {
        return "Route to " + this.islandB.getName() + ". This route is %.2f".formatted(this.getDistance()) +
                " km long and will take you " + this.getSailDuration(ship) + " days to sail.";
    }
}