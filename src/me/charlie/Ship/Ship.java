package me.charlie.Ship;

import me.charlie.Island.Island;
import me.charlie.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    ShipType shipType;
    double sailSpeed;
    int maxCargoCapacity;
    int cargoSpaceRemaining;
    int maxCrewSize;
    double shipEndurance;
    double shipHealth;
    Island currentIsland;

    private List<Item> currentCargo = new ArrayList<Item>();

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

    public List<Item> getCurrentCargo() {
        return currentCargo;
    }

    public void addItemToCargo(Item item) {
        if (getCargoSpaceRemaining() + item.getSize() > getMaxCargoCapacity()) {
            System.out.println("You don't have enough space for that item.");
        } else {
            currentCargo.add(item);
            System.out.println("The item was deposited in the cargo hold.");
        }
    }

    public int getCargoSpaceRemaining() {
        int cargoSpaceTaken = 0;
        for (Item item : currentCargo) {
            cargoSpaceTaken += item.getSize();
        }
        cargoSpaceRemaining = getMaxCargoCapacity() - cargoSpaceTaken;
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
