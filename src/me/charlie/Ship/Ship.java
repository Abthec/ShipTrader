package me.charlie.Ship;

import me.charlie.Island.Island;
import me.charlie.Item.Item;
import me.charlie.Store.Store;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    ShipType shipType;
    double sailSpeed;
    int maxCargoCapacity;
    int cargoSpaceRemaining;
    int maxCrewSize;
    int cargoFullness;
    double shipEndurance;
    double shipHealth;
    Island currentIsland;
    private List<Item> currentCargo;

    public Ship(ShipType shipType, double sailSpeed, int maxCargoCapacity, int maxCrewSize, double shipEndurance, Island currentIsland) {
        this.maxCargoCapacity = maxCargoCapacity;
        this.sailSpeed = sailSpeed;
        this.maxCrewSize = maxCrewSize;
        this.shipEndurance = shipEndurance;
        this.shipHealth = shipEndurance;
        this.shipType = shipType;
        this.currentIsland = currentIsland;
        this.currentCargo = new ArrayList<>();
        this.cargoSpaceRemaining = maxCargoCapacity;
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

    public boolean addItemToCargo(Item item) {
        if (item.getSize() > getCargoSpaceRemaining()) {
            System.out.println("You don't have enough space for that item.");
            return false;
        } else {
            this.currentCargo.add(item);
            System.out.println("The item was deposited in the cargo hold." +
                    "\nYou have " + getCargoSpaceRemaining() + " cargo space left.");
            return true;
        }
    }

    public int getCargoSpaceRemaining() {
        int cargoSpaceTaken = 0;
        for (Item item : this.currentCargo) {
            cargoSpaceTaken += item.getSize();
        }
        this.cargoSpaceRemaining = getMaxCargoCapacity() - cargoSpaceTaken;
        return cargoSpaceRemaining;
    }

    public int getCargoFullness() {
        cargoFullness = getMaxCargoCapacity() - getCargoSpaceRemaining();
        return cargoFullness;
    }

    public boolean isCargoEmpty() {
        return (getCargoSpaceRemaining() == maxCargoCapacity);
    }

    public void viewCurrentCargo() {
        System.out.println("Total items in cargo: " + getCargoFullness() +
                "\nYou can fit " + getCargoSpaceRemaining() + " more items.");
        for (Item item : currentCargo) {
            System.out.println(item.getItemType().getName());
        }
    }

    public void viewCurrentCargo(Store store) {
        for (Item item : currentCargo) {
            int sellCost = item.getSellCost(store);
            System.out.println(item.getItemType().getName() + " | " + sellCost);
        }
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
