package me.charlie.Ship;

import me.charlie.Island.Island;

public class Ship {

    ShipType shipType;
    double sailSpeed;
    int maxCargoCapacity;
    int currentCargo;
    int cargoSpaceRemaining;
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
        this.currentCargo = 0;
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

    public int getCurrentCargo() {
        return currentCargo;
    }

    public int setCurrentCargo(int cargoChange) {
        this.currentCargo = getCurrentCargo() + cargoChange;
        return cargoChange;
    }

    public int getCargoSpaceRemaining() {
        cargoSpaceRemaining = getMaxCargoCapacity() - getCurrentCargo();
        return cargoSpaceRemaining;
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

    public String toString() {
        return this.getShipType().getName() + " | " + this.getSailSpeed() + " | " + this.getMaxCargoCapacity() + " | "
                + this.getMaxCrewSize() + " | " + this.getShipEndurance();
    }
}
