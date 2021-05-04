package me.charlie;

import me.charlie.Island.Island;
import me.charlie.Ship.Ship;
import me.charlie.Store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {


    Trader trader;
    Ship ship;
    int gameDuration;
    int islandTotal;
    List<Island> islands = new ArrayList<Island>();
    List<Store> stores = new ArrayList<Store>();
    Store originStore;

    private Random random = new Random();

    public Game(String traderName, int gameDuration, Ship ship, int islandTotal) {

        while (stores.size() <= islandTotal) {
            stores.add(new Store());
        }

        originStore = stores.get(random.nextInt(5));
        stores.remove(originStore);
        islands.add(new Island(originStore));

        while (islands.size() <= islandTotal) {

        }

        int startingCash = 500;
        this.gameDuration = gameDuration;
        trader = new Trader(traderName, startingCash, ship);

    }
}