package me.charlie.Trader;

import me.charlie.Ship.Ship;

public class Trader {

    String name;
    int money;
    Ship ship;

    public Trader(String name, int money, Ship ship) {
        this.name = name;
        this.money = money;
        this.ship = ship;
    }

    public Ship getShip() {
        return ship;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int subtractMoney(int moneySpent) {
        this.money = this.getMoney() - moneySpent;
        System.out.println("You have " + getMoney() + " coins left.");
        return this.money;
    }
}
