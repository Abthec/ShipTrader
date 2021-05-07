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
    List<Route> routes;

    public Game(String traderName, int gameDuration, Ship ship, int islandTotal) {

        int startingCash = 500;
        this.islandTotal = islandTotal;
        this.gameDuration = gameDuration;

        List<Island> islands = createIslands(islandTotal);
        this.routes = createRoutes(islands);
        ship.setCurrentIsland(islands.get(0));
        trader = new Trader(traderName, startingCash, ship);

        System.out.println("You are on " + ship.getCurrentIsland().getName() + " island.");
        Island currentIsland = ship.getCurrentIsland();
        while (true) {
            if (!ship.getCurrentIsland().equals(currentIsland)) {
                break;
            }
            Activitiy chosenActivity = getChosenActivity(ship);
            executeActivity(chosenActivity, trader);
        }


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
                    for (int i = 0; i < (random.nextInt(3)); i++) {
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

    public void executeActivity(Activitiy activitiy, Trader trader) {
        switch (activitiy) {
            case REPAIR:
                break;
            case SHOP:
                shopping(trader);
                break;
            case SAIL:
                break;
            case HIRE:
                break;
        }
    }

    public void shopping(Trader trader) {

        Scanner scanner = new Scanner(System.in);
        Ship ship = trader.getShip();
        Island currentIsland = ship.getCurrentIsland();
        int cash = trader.getMoney();
        Store store = currentIsland.getStore();
        System.out.println("Welcome to " + store);

        shopActions:
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
                    System.out.println("You currently have " + ship.getCargoSpaceRemaining() + " cargo space remaining.");
                    for (Item item : store.getStock()) {
                        System.out.println("ID: Item Type | Item Cost | Item Size");
                        System.out.println(itemID + ": " + item + item.getBuyCost() + " | " + item.getSize());
                        itemID++;
                    }
                    System.out.println("Enter the ID of the item you'd like to purchase.");
                    int chosenItemID = Integer.parseInt(scanner.nextLine());
                    Item chosenItem = store.getStock().get(chosenItemID);
                    if (chosenItem.getBuyCost() == cash) {
                        System.out.println("Warning! Buying this item will leave you with 0 coins. Would you like to proceed?");
                        String proceedToPurchase = scanner.nextLine();
                        if (proceedToPurchase.equalsIgnoreCase("yes")) {
                            if (ship.addItemToCargo(chosenItem)) {
                                ship.getCurrentIsland().getStore().buyItem(chosenItem);
                                trader.subtractMoney(chosenItem.getBuyCost());
                            }
                            System.out.println("Is there anything else I can help you with?");
                            continue shopActions;
                        }
                    } else if (chosenItem.getBuyCost() < cash) {
                        if (ship.addItemToCargo(chosenItem)) {
                            ship.getCurrentIsland().getStore().buyItem(chosenItem);
                            trader.subtractMoney(chosenItem.getBuyCost());
                        }
                        System.out.println("Is there anything else I can help you with?");
                        continue shopActions;
                    } else {
                        System.out.println("This item cost " + chosenItem.getBuyCost() + " coins.\nWould you like to chose another? - [Yes] or [No]");
                        String retryBuy = scanner.nextLine();
                        while (true) {
                            if (retryBuy.equalsIgnoreCase("Yes")) {
                                continue shopActions;
                            } else if (retryBuy.equalsIgnoreCase("No")){
                                break shopActions;
                            } else {
                                System.out.println("Please enter [Yes] or [No].");
                                retryBuy = scanner.nextLine();
                            }
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

    public Island sailing(Trader trader, List<Route> routes) {
        Ship ship = trader.getShip();;
        Island currentIsland = ship.getCurrentIsland();
        List<Route> usableRoutes = new ArrayList<>();

        System.out.println("These are the routes you may take to get to other islands:");
        for (Route route : this.routes) {
            if (currentIsland.equals(route.getIslandA())) {
                usableRoutes.add(route);
                System.out.println(route);
            }
        }
        return currentIsland;
    }

    public void repairShip() {

    }

    public void hireCrew() {

    }
}