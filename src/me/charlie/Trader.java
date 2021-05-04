package me.charlie;

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
}
