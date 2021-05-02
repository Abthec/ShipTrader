package me.charlie;

import me.charlie.Ship.Ship;

public class Game {


    Trader trader;
    Ship ship;
    int gameDuration;

    public Game(String traderName, int gameDuration, Ship ship) {

        int startingCash = 500;
        this.gameDuration = gameDuration;
        trader = new Trader(traderName, startingCash);
        this.ship = ship;

    }
}