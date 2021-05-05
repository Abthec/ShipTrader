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


    Trader trader;
    int gameDuration;
    int islandTotal;
    int daysRemaining;
    int daysSailed;

    public Game(String traderName, int gameDuration, Ship ship, int islandTotal) {

        int startingCash = 500;
        this.islandTotal = islandTotal;
        this.gameDuration = gameDuration;

        List<Island> islands = createIslands(islandTotal);
        List<Route> routes = createRoutes(islands);
        ship.setCurrentIsland(islands.get(0));
        trader = new Trader(traderName, startingCash, ship);

        System.out.println("You are on " + ship.getCurrentIsland().getName() + " island.");
        Activitiy chosenActivity = getChosenActivity(ship);

    }

    public int getGameDuration() {
        return gameDuration;
    }

    public int getDaysRemaining() {
        daysRemaining = getGameDuration() - daysSailed;
        return daysRemaining;
    }

    public List<Island> createIslands(int islandTotal) {

        IslandNameHandler islandNames = new IslandNameHandler();
        IslandCoordinateHandler islandCoordinates = new IslandCoordinateHandler(islandTotal);
        List<Island> islands = new ArrayList<>();
        islands.add(new Island());

        while (islands.size() <= islandTotal) {
            islands.add(new Island(islandNames.getName(),islandCoordinates.getCoordinate()));
        }
        return islands;
    }

    public List<Route> createRoutes(List<Island> islands) {

        List<Route> routes = new ArrayList<>();

        for (Island islandA : islands) {
            for (Island islandB : islands) {
                if (!islandA.equals(islandB)) {
                    Random random = new Random();
                    for (int i = 0; i < (1 + random.nextInt(2)); i++) {
                        routes.add(new Route(islandA, islandB));
                    }
                }
            }
        }
        return routes;
    }

    public Activitiy getChosenActivity(Ship ship) {

        Island currentIsland = ship.getCurrentIsland();
        Scanner scanner = new Scanner(System.in);
        Activitiy chosenActivity;

        System.out.println("You are currently on " + currentIsland.getName());
        System.out.println("""
                Which of the following activities would you like to do?
                1: Sail to another Island?
                2: Visit the store?
                3: Look for more crew to hire?
                4: Repair your ship?""");
        activityChooser:
        while (true) {
            int activityCode = Integer.parseInt(scanner.nextLine());
            switch (activityCode) {
                case 1:
                    if (ship.getShipHealth() < ship.getShipEndurance()) {
                        System.out.println("Cannot go sailing with a damaged ship.\nChoose again.");
                        continue activityChooser;
                    } else {
                        chosenActivity = Activitiy.SAIL;
                        break activityChooser;
                    }
                case 2:
                    chosenActivity = Activitiy.SHOP;
                    break activityChooser;
                case 3:
                    chosenActivity = Activitiy.HIRE;
                    break activityChooser;
                case 4:
                    if (ship.getShipHealth() == ship.getShipEndurance()) {
                        System.out.println("Ship is not in need of repairs.\nChoose again.");
                        continue activityChooser;
                    } else {
                        chosenActivity = Activitiy.REPAIR;
                        break activityChooser;
                    }
                default:
                    System.out.println("Sorry that is not a valid code please try again.");
            }
        }
        return chosenActivity;
    }

    public void shopping(Trader trader, Ship ship) {

        Scanner scanner = new Scanner(System.in);
        Island currentIsland = ship.getCurrentIsland();
        int cash = trader.getMoney();
        Store store = currentIsland.getStore();
        System.out.println("Welcome to " + store + ". How can I help you today?");
        while (true) {
            System.out.println("[Buy], [Sell], [Leave] - insert answer below:");
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("buy")) {
                if (ship.getCargoSpaceRemaining() == 0) {
                    System.out.println("""
                            You cannot fit anymore items sorry.
                            Would you like to do something else?""");
                } else {
                    System.out.println("Here are the items available");
                    int itemID = 0;
                    for (Item item : store.getStock()) {
                        System.out.println("ID: Item Type | Base Item Cost (May be changed at shopkeepers discretion)");
                        System.out.println(itemID + ": " + item);
                    }
                    System.out.println("Enter the ID of the item you'd like to purchase.");
                    int chosenItemID = Integer.parseInt(scanner.nextLine());
                    Item chosenItem = store.getStock().get(chosenItemID);
                    int itemCost = (int)Math.round(chosenItem.getBaseCost() * store.getStoreType().getBuyModifier(chosenItem.getItemType()));
                    System.out.println("After reviewing the item the shop has decided to sell it to you for " + itemCost + " schmeckles.");
                    if (itemCost == cash) {
                        System.out.println("Warning! Buying this item will bankrupt you. Would you like to proceed?");
                        String proceedToPurchase = scanner.nextLine();
                        if (proceedToPurchase.equalsIgnoreCase("yes")) {
                            trader.subtractMoney(itemCost);
                        }
                    }
                    break;
                }

            } else if (action.equalsIgnoreCase("sell")) {

                break;
            } else if (action.equalsIgnoreCase("leave")) {
                System.out.println("Goodbye. Thank you for shopping with us.");
                break;
            } else {
                System.out.println("That was not a valid option please try again.");
            }
        }
    }
}