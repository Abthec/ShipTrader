package me.charlie;

import me.charlie.Island.Island;
import me.charlie.Ship.Ship;
import me.charlie.Store.Store;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Game {


    Trader trader;
    Ship ship;
    int gameDuration;
    int islandTotal;
    List<Island> islands = new ArrayList<Island>();
    List<Store> stores = new ArrayList<Store>();

    public Game(String traderName, int gameDuration, Ship ship, int islandTotal) {

        while (stores.size() <= islandTotal) {
            stores.add(new Store());
        }

        int startingCash = 500;
        this.gameDuration = gameDuration;
        trader = new Trader(traderName, startingCash, ship);

    }
}