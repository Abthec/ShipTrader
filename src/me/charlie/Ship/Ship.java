package me.charlie.Ship;

import me.charlie.Island.Island;
import me.charlie.Item.Item;

public class Ship {

    ShipType shipType;
    double sailSpeed;
    int maxCargoCapacity;
    int maxCrewSize;
    double shipEndurance;
    double shipHealth;
    Island currentIsland;


    public Ship(ShipType shipType, double sailSpeed, int maxCargoCapacity, int maxCrewSize, double shipEndurance, Island currentIsland) {
        this.maxCargoCapacity = maxCargoCapacity;
        this.sailSpeed = sailSpeed;
        this.maxCrewSize = maxCrewSize;
        this.shipEndurance = shipEndurance;
        this.shipHealth = shipEndurance;
        this.shipType = shipType;
        this.currentIsland = currentIsland;
    }

    public Island getCurrentIsland() {
        return currentIsland;
    }

    public void setCurrentIsland(Island currentIsland) {
        this.currentIsland = currentIsland;
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

    public double getShipHealth() {
        return shipHealth;
    }

    public double shipTakeDamage(double damageTaken) {
        shipHealth = getShipHealth() - damageTaken;
        return shipHealth;
    }

    public double repairShip(double amountRepaired) {
        shipHealth = getShipHealth() + amountRepaired;
        if (shipHealth > shipEndurance) {
            shipHealth = shipEndurance;
        }
        return shipHealth;
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
