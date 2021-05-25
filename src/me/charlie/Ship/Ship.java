package me.charlie.Ship;

import me.charlie.Island.Island;
import me.charlie.Item.Item;
import me.charlie.Item.UpgradeType;
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
    int numberOfCannons;
    int numberOfMastUpgrades;
    int numberOfCargoHoldUpgrades;
    int numberOfBulkheadUpgrades;
    double shipEndurance;
    double currentShipEndurance;
    double shipHealth;
    Island currentIsland;
    private List<Item> currentCargo;
    private List<Item> receipts;

    /**
     * Creates an instance of Ship.
     * 
     * @param shipType the type of ship, of type ShipType.
     * @param shipId the shipId, as an int, used for the console application.
     * @param sailSpeed the sail speed of the ship, as an int, in km/day.
     * @param maxCargoCapacity the maximum amount of cargo the ship can hold as an int.
     * @param maxCrewSize the maximum amount of crew members that can be on the ship, as an int.
     * @param shipEndurance the damage the ship can take before sinking, ship health starts at maximum.
     * @param currentIsland the Island object the ship is currently docked at.
     * @param shipName the name of the ship, as a string, randomly selected from a list of names.
     */
    public Ship(ShipType shipType, int shipId, double sailSpeed, int maxCargoCapacity, int maxCrewSize, double shipEndurance, Island currentIsland, String shipName) {
        this.maxCargoCapacity = maxCargoCapacity;
        this.sailSpeed = sailSpeed;
        this.maxCrewSize = maxCrewSize;
        this.shipEndurance = shipEndurance;
        this.shipHealth = shipEndurance;
        this.shipType = shipType;
        this.currentIsland = currentIsland;
        this.currentCargo = new ArrayList<>();
        this.receipts = new ArrayList<>();
        this.cargoSpaceRemaining = maxCargoCapacity;
        this.shipId = shipId;
        this.currentCrewSize = (int)Math.round(maxCrewSize * 0.5);
        this.currentShipEndurance = shipEndurance;
        this.name = shipName;
    }

    /**
     * 
     * @return returns the Island object that the ship is currently docked at.
     */
    public Island getCurrentIsland() {
        return currentIsland;
    }

    /**
     * changes the Island object that the ship is docked at, used whenever the ship travels to a new island.
     * 
     * @param currentIsland the Island object that the ship is currently docked at.
     */
    public void setCurrentIsland(Island currentIsland) {
        this.currentIsland = currentIsland;
    }

    /**
     * 
     * @return returns the maximum amount of cargo the ship can hold, as an int.
     */
    public int getMaxCargoCapacity() {
        return maxCargoCapacity;
    }

    /**
     * 
     * @return returns a list of all the Item objects currently on the ship.
     */
    public List<Item> getCurrentCargo() {
        return currentCargo;
    }
    
    /**
     * Adds an item to a list of Item objects, this is a list of all the items that have been sold by the player.
     * 
     * @param item an Item object representing an item sold by the player.
     */
    public void addReceipt(Item item) {
    	receipts.add(item);
    }
    
    /**
     * 
     * @return returns a list of all Item objects sold by the player.
     */
    public List<Item> getReceipts() {
    	return receipts;
    }

    /**
     * Attempts to add an Item object to the list of Item objects currently stored on the ship.
     * 
     * @param item a Item object purchased by the player
     * @return returns true if the Item was added, false if it was not.
     */
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

    /**
     * calculates the amount of space remaining before reaching max cargo capacity.
     * 
     * @return returns the amount of space remaining as an int.
     */
    public int getCargoSpaceRemaining() {
        int cargoSpaceTaken = 0;
        for (Item item : this.currentCargo) {
            cargoSpaceTaken += item.getSize();
        }
        this.cargoSpaceRemaining = getMaxCargoCapacity() - cargoSpaceTaken;
        return cargoSpaceRemaining;
    }

    /**
     * calculates how much of the max cargo space is taken up.
     * 
     * @return returns the amount of cargo spaces taken up as an int.
     */
    public int getCargoFullness() {
        cargoFullness = getMaxCargoCapacity() - getCargoSpaceRemaining();
        return cargoFullness;
    }

    /**
     * checks if the space remaining is equal to the total space.
     * 
     * @return returns true if there is 0 cargo on the ship.
     */
    public boolean isCargoEmpty() {
        return (getCargoSpaceRemaining() == maxCargoCapacity);
    }

    /**
     * Prints a list of the all the Item objects on the ship.
     */
    public void viewCurrentCargo() {
        int id = 1;
        System.out.println("Total items in cargo: " + getCargoFullness() +
                "\nYou can fit " + getCargoSpaceRemaining() + " more items.");
        for (Item item : currentCargo) {
            System.out.println(id + ": " + item.getItemType().getName());
        }
    }

    /**
     * Prints a list of the current cargo with the price that you can sell it to the current store for.
     * 
     * @param store the Store object on the current Island.
     */
    public void viewCurrentCargo(Store store) {
        int id = 1;
        for (Item item : currentCargo) {
            int sellCost = item.getSellCost(store);
            System.out.println(id + ": " + item.getItemType().getName() + " | " + sellCost);
            id++;
        }
    }

    /**
     * 
     * @return returns the maximum amount of crew members a ship can have as an int.
     */
    public int getMaxCrewSize() {
        return maxCrewSize;
    }

    /**
     * 
     * @return returns the current number of crew members on the ship as an int.
     */
    public int getCurrentCrewSize() {
        return currentCrewSize;
    }

    /**
     * 
     * @return returns how full your crew is as a decimal out of 1.
     */
    public double getCrewFullness() {
        crewFullness = getCurrentCrewSize()/getMaxCrewSize();
        return crewFullness;
    }

    /**
     * adds a member to the currentCrewSize.
     */
    public void hireCrewMember() {
        this.currentCrewSize++;
    }

    /**
     * 
     * @return returns the sail speed of the ship, as an int, in km/day.
     */
    public double getSailSpeed() {
        return sailSpeed;
    }

    /**
     * 
     * @return returns the ships endurance (max health) as a double.
     */
    public double getShipEndurance() {
        return shipEndurance;
    }

    /**
     * 
     * @return returns the ships current health as a double.
     */
    public double getShipHealth() {
        return shipHealth;
    }

    public double addShipHealth() {
        shipHealth += shipEndurance/10;
        if (shipHealth > shipEndurance) {
            shipHealth = shipEndurance;
        }
        return shipHealth;
    }

    public double repairFull() {
        shipHealth = shipEndurance;
        return shipHealth;
    }

    public double removeShipHealth(double amountRemoved) {
        shipHealth -= amountRemoved;
        if (shipHealth < 0) {
            shipHealth = 0;
        }
        return shipHealth;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public int getShipId() {
        return shipId;
    }

    public void upgradeSailSpeed() {
        sailSpeed += 2.5;
        numberOfMastUpgrades++;
    }

    public void upgradeShipEndurance() {
        shipEndurance += 50;
        shipHealth += 50;
        numberOfBulkheadUpgrades++;
    }

    public void upgradeCargoCapacity() {
        maxCargoCapacity += 2;
        numberOfCargoHoldUpgrades++;
    }
    
    public void addCannon() {
    	numberOfCannons++;
    }
    
    public int getNumberOfCannons() {
    	return numberOfCannons;
    }
    
    public int getNumberOfMastUpgrades() {
    	return numberOfMastUpgrades;
    }
    
    public int getNumberOfCargoHoldUpgrades() {
    	return numberOfCargoHoldUpgrades;
    }
    
    public int getNumberOfBulkheadUpgrades() {
    	return numberOfBulkheadUpgrades;
    }

    public boolean canUpgrade(UpgradeType upgradeType) {
    	switch(upgradeType) {
    		case CANNON:
    			return numberOfCannons < 5;
    		case MAST:
    			return numberOfMastUpgrades < 5;
    		case CARGO_HOLD:
    			return true;
    		case BULKHEAD:
    			return true;
    		default:
    			return false;
    	}
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