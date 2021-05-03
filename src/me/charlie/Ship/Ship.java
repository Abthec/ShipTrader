package me.charlie.Ship;

import me.charlie.Item.Item;

public class Ship {

    ShipType shipType;
    double sailSpeed;
    int maxCargoCapacity;
    int maxCrewSize;
    double shipEndurance;


    public Ship(ShipType shipType, double sailSpeed, int maxCargoCapacity, int maxCrewSize, double shipEndurance) {
        this.maxCargoCapacity = maxCargoCapacity;
        this.sailSpeed = sailSpeed;
        this.maxCrewSize = maxCrewSize;
        this.shipEndurance = shipEndurance;
        this.shipType = shipType;
    }

    public int getMaxCargoCapacity() {
        return maxCargoCapacity;
    }

    public int getMaxCrewSize() {
        return maxCrewSize;
    }

    public double getSailSpeed() {
        return sailSpeed;
    }

    public double getShipEndurance() {
        return shipEndurance;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public int getRemainingCargoCapacity() {
        int capacityUsed = 0;
        int capacityRemaining = getMaxCargoCapacity() - capacityUsed;
        return capacityRemaining;
    }

    public String toString() {
        return this.getShipType().getName() + " | " + this.getSailSpeed() + " | " + this.getMaxCargoCapacity() + " | "
                + this.getMaxCrewSize() + " | " + this.getShipEndurance();
    }
}
