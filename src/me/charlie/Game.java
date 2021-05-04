package me.charlie;

import me.charlie.Island.Island;
import me.charlie.Island.IslandCoordinateHandler;
import me.charlie.Island.IslandNameHandler;
import me.charlie.Ship.Ship;
import me.charlie.Store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {


    Trader trader;
    int gameDuration;
    int islandTotal;
    private List<Island> islands = new ArrayList<Island>();
    private List<Route> routes = new ArrayList<Route>();
    private IslandNameHandler islandNames = new IslandNameHandler();
    private IslandCoordinateHandler islandCoordinates = new IslandCoordinateHandler(islandTotal);

    private Random random = new Random();

    public Game(String traderName, int gameDuration, Ship ship, int islandTotal) {

        islands.add(new Island());

        while (islands.size() <= islandTotal) {
            islands.add(new Island(islandNames.getName(),islandCoordinates.getCoordinate()));
        }

        for (Island islandA : islands) {
            for (Island islandB : islands) {
                if (!islandA.equals(islandB)) {
                    for (int i = 0; i < (1 + random.nextInt(3)); i++) {
                        routes.add(new Route(islandA, islandB));
                    }
                }
            }
        }

        int startingCash = 500;
        this.gameDuration = gameDuration;
        trader = new Trader(traderName, startingCash, ship);
    }
}