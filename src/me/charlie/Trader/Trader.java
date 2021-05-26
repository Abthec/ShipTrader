package me.charlie.Trader;

import me.charlie.Ship.Ship;

/**
 * Stores information about the trader.
 * 
 * @author charlie
 *
 */
public class Trader {

    private String name;
    private int money;
    private Ship ship;

    /**
     * Create an instance of the Trader class.
     * 
     * @param name the name of the trader.
     * @param money the amount of money possessed by the trader.
     * @param ship the ship owned by the trader.
     */
    public Trader(String name, int money, Ship ship) {
        this.name = name;
        this.money = money;
        this.ship = ship;
    }

    /**
     * 
     * @return the ship owned by the trader.
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * 
     * @return the name of the trader.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return the amount of money possessed by the trader.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Remove a specified amount of money from the current money.
     * 
     * @param moneyToRemove the amount of money to be removed from the traders current amount of money.
     * @return the amount of money left after subtracting the specified amount.
     */
    public int subtractMoney(int moneyToRemove) {
        this.money = this.getMoney() - moneyToRemove;
        System.out.println("You have " + getMoney() + " coins left.");
        return money;
    }

    /**
     * Add a specified amount of money to the traders current money.
     * 
     * @param moneyEarned the amount of money to be added to the traders current amount of money.
     * @return the amount of money after adding the specified amount.
     */
    public int addMoney(int moneyEarned) {
     this.money = getMoney() + moneyEarned;
     System.out.println("You now have " + getMoney() + " coins in your stash!");
     return money;
    }
}
