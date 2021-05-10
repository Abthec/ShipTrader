package me.charlie.Ship;

import me.charlie.Island.Island;
import me.charlie.Item.Item;
import me.charlie.Store.Store;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    String name;
    ShipType shipType;
    double sailSpeed;
    double crewFullness;
    int maxCargoCapacity;
    int cargoSpaceRemaining;
    int maxCrewSize;
    int currentCrewSize;
    int cargoFullness;
    int shipId;
    double shipEndurance;
    double currentShipEndurance;
    double shipHealth;
    Island currentIsland;
    private List<Item> currentCargo;
    private ShipNameHandler shipNameHandler = new ShipNameHandler();

    public Ship(ShipType shipType, int shipId, double sailSpeed, int maxCargoCapacity, int maxCrewSize, double shipEndurance, Island currentIsland) {
        this.maxCargoCapacity = maxCargoCapacity;
        this.sailSpeed = sailSpeed;
        this.maxCrewSize = maxCrewSize;
        this.shipEndurance = shipEndurance;
        this.shipHealth = shipEndurance;
        this.shipType = shipType;
        this.currentIsland = currentIsland;
        this.currentCargo = new ArrayList<>();
        this.cargoSpaceRemaining = maxCargoCapacity;
        this.shipId = shipId;
        this.currentCrewSize = (int)Math.round(maxCrewSize * 0.5);
        this.name = shipNameHandler.getName();
        this.currentShipEndurance = shipEndurance;
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

    public boolean removeItemFromCargo(Item item) {
        if (currentCargo.size() == 0) {
            System.out.println("There are no items to remove.");
            return false;
        } else {
            this.currentCargo.remove(item);
            System.out.println("The item was removed from the cargo hold." +
                    "\nYou now have " + getCargoSpaceRemaining() + " cargo space left.");
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
        int id = 1;
        System.out.println("Total items in cargo: " + getCargoFullness() +
                "\nYou can fit " + getCargoSpaceRemaining() + " more items.");
        for (Item item : currentCargo) {
            System.out.println(id + ": " + item.getItemType().getName());
        }
    }

    public void viewCurrentCargo(Store store) {
        int id = 1;
        for (Item item : currentCargo) {
            int sellCost = item.getSellCost(store);
            System.out.println(id + ": " + item.getItemType().getName() + " | " + sellCost);
            id++;
        }
    }

    public int getMaxCrewSize() {
        return maxCrewSize;
    }

    public int getCurrentCrewSize() {
        return currentCrewSize;
    }

    public double getCrewFullness() {
        crewFullness = getCurrentCrewSize()/getMaxCrewSize();
        return crewFullness;
    }

    public String hireCrewMember() {
        this.currentCrewSize++;
        return "You hired a crew member, things brings your crew size to: " + this.getCurrentCrewSize() + "/" + this.getMaxCrewSize();
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

    public int getShipId() {
        return shipId;
    }

    public String getName() {
        return name;
    }

    public String getProperties() {
        return shipType.getName() + " | " + this.sailSpeed + " | " + this.getCargoFullness() + "/" + this.getMaxCargoCapacity() +
                " | " + this.getCurrentCrewSize() + "/" + this.getMaxCrewSize() + " | " + this.getShipHealth() + "/" + this.getShipEndurance();
    }

    public String toString() {
        return this.shipId + ": " + this.getShipType().getName() + " | " + this.getSailSpeed() + " | " + this.getMaxCargoCapacity() + " | "
                + this.getMaxCrewSize() + " | " + this.getShipEndurance();
    }
}