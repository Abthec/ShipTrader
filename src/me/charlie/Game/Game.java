package me.charlie.Game;

import me.charlie.Island.Island;
import me.charlie.Island.IslandCoordinateHandler;
import me.charlie.Island.IslandNameHandler;
import me.charlie.Island.Route;
import me.charlie.Item.Item;
import me.charlie.Ship.Ship;
import me.charlie.Store.Store;
import me.charlie.Trader.Trader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	int gameDuration;
    int islandTotal;
    int daysRemaining;
    int daysSailed;
    int sailDuration;
    int startingCash;
    private List<Route> routes;
    private List<Island> islands;
    private Trader trader;
    private Ship ship;
    private DiceGame diceGame;
    
    /**
     * Creates an instance of the game, this is where all the data about the game is stored.
     * 
     * @param traderName the name the player chooses for their character.
     * @param gameDuration the the duration the player chooses to play the game.
     * @param ship the ship the player chooses to use.
     * @param islandTotal the amount of islands that will be generated. (5 is in specifications).
     */
    public Game(String traderName, int gameDuration, Ship ship, int islandTotal) {
        this.startingCash = 10000;
        this.islandTotal = islandTotal;
        this.gameDuration = gameDuration;
        this.islands = createIslands(islandTotal);
        this.routes = createRoutes(islands);
        this.trader = new Trader(traderName, startingCash, ship);
        this.ship = ship;
        this.daysRemaining = gameDuration;

        ship.setCurrentIsland(islands.get(0));
    }

    /**
     * 
     * @return returns the duration chosen during game setup.
     */
    public int getGameDuration() {
        return gameDuration;
    }

    /**
     * Sets the amount of days remaining in the game.
     * Used to determine if there is enough days remaining to sail chosen routes/continue the game.
     * 
     * @param daysSailed the amount of days, as an int,` taken to sail the chosen route.
     */
    public void setDaysRemaining(int daysSailed) {
        daysRemaining = daysRemaining - daysSailed;
    }

    /**
     * 
     * @return returns the amount of days, as an int, remaining before the game should end.
     */
    public int getDaysRemaining() {
        return daysRemaining;
    }

    /**
     * Checks to see if it is possible to sail to another island.
     * Used to check whether or not the game should be ended.
     * 
     * @return returns a boolean true if you can sail and false if you cannot.
     */
    public boolean canSailToAnotherIsland() {
        Island island = ship.getCurrentIsland();
        for (Route route : getRoutes()) {
            if (route.getIslandA().equals(island) && route.getSailDuration(ship) <= getDaysRemaining()) {
                return true;
            }
        }
        return false;
    }

    public Ship getShip() {
        return ship;
    }

    public Trader getTrader() {
        return trader;
    }

    public List<Island> createIslands(int islandTotal) {

        IslandNameHandler islandNames = new IslandNameHandler();
        IslandCoordinateHandler islandCoordinates = new IslandCoordinateHandler(islandTotal);
        this.islands = new ArrayList<>();
        islands.add(new Island());

        while (islands.size() < islandTotal) {
            islands.add(new Island(islandNames.getName(), islandCoordinates.getCoordinate()));
        }
        return islands;
    }

    public List<Route> createRoutes(List<Island> islands) {

        List<Route> routes = new ArrayList<>();

        for (Island islandA : islands) {
            for (Island islandB : islands) {
                if (!islandA.equals(islandB)) {
                    Random random = new Random();
                    for (int i = 0; i < 1 + (random.nextInt(3)); i++) {
                        routes.add(new Route(islandA, islandB));
                    }
                }
            }
        }

        return routes;
    }

    public List<Island> getIslands() {
        return islands;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public Island sailing(Trader trader, List<Route> routes) {
        Ship ship = trader.getShip();
        ;
        Island currentIsland = ship.getCurrentIsland();
        List<Route> usableRoutes = new ArrayList<>();

        System.out.println("These are the routes you may take to get to other islands:");
        for (Route route : routes) {
            if (currentIsland.equals(route.getIslandA())) {
                usableRoutes.add(route);
                System.out.println(route);
            }
        }
        return currentIsland;
    }
}