package me.charlie.Game;

import me.charlie.Island.Island;
import me.charlie.Island.IslandCoordinateHandler;
import me.charlie.Island.IslandNameHandler;
import me.charlie.Island.Route;
import me.charlie.Item.Item;
import me.charlie.Ship.Ship;
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
    private List<Island> islands = new ArrayList<Island>();
    private List<Route> routes = new ArrayList<Route>();



    private Random random = new Random();

    public Game(String traderName, int gameDuration, Ship ship, int islandTotal) {

        Scanner scanner = new Scanner(System.in);

        IslandNameHandler islandNames = new IslandNameHandler();
        IslandCoordinateHandler islandCoordinates = new IslandCoordinateHandler(islandTotal);
        islands.add(new Island());
        ship.setCurrentIsland(islands.get(0));

        while (islands.size() <= islandTotal) {
            islands.add(new Island(islandNames.getName(),islandCoordinates.getCoordinate()));
        }

        for (Island islandA : islands) {
            for (Island islandB : islands) {
                if (!islandA.equals(islandB)) {
                    for (int i = 0; i < (1 + random.nextInt(2)); i++) {
                        routes.add(new Route(islandA, islandB));
                    }
                }
            }
        }

        int startingCash = 500;
        this.islandTotal = islandTotal;
        this.gameDuration = gameDuration;
        trader = new Trader(traderName, startingCash, ship);
//        for (Route route : routes) {
//            System.out.println(route);
//        }

//        for (Island tempIsland : islands) {
//            System.out.println(tempIsland.getStore());
//        }

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

    public Activitiy getChosenActivity(Ship ship) {

        Island currentIsland = ship.getCurrentIsland();
        Scanner scanner = new Scanner(System.in);
        Activitiy chosenActivity;

        System.out.println("You are currently on " + currentIsland.getName());
        System.out.println("Which of the following activities would you like to do?" +
                "\n1: Sail to another Island?" +
                "\n2: Visit the store?" +
                "\n3: Look for more crew to hire?" +
                "\n4: Repair your ship?");
        activityChooser:
        while (true) {
            int activityCode = Integer.parseInt(scanner.nextLine());
            switch (activityCode) {
                case 1:
                    if (ship.getShipHealth() < ship.getShipEndurance()) {
                        System.out.println("Cannot go sailing with a damaged ship.\nChoose again.");
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
                    } else {
                        chosenActivity = Activitiy.REPAIR;
                        break activityChooser;
                    }
            }
        }
        return chosenActivity;
    }

    public void shopping(Ship ship) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("On this island there is a store called " + ship.getCurrentIsland().getStore().getName());
        System.out.println("It is a(n) " + ship.getCurrentIsland().getStore().getStoreType().getName());
        System.out.println("This store has these items for sale:");
        int counter = 0;
        System.out.println("Code : ItemType | Cost");
        for (Item item : ship.getCurrentIsland().getStore().getStock()) {
            System.out.println(counter + " : " + item);
            counter += 1;
        }
        System.out.println("Would you like to purchase an item? [Yes] or [No]");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Select the item you would like to buy by inputting its code.");
            int itemCode = Integer.parseInt(scanner.nextLine());
            Item itemForPurchase = ship.getCurrentIsland().getStore().getStock().get(itemCode);
            int itemCost = itemForPurchase.getCost();
            double costModifier = ship.getCurrentIsland().getStore().getStoreBuyModifier(itemForPurchase);
            int itemTrueCost = (int)Math.round(itemCost * costModifier);
            if (trader.getMoney() >= itemTrueCost) {
                System.out.println("You purchased " + ship.getCurrentIsland().getStore().getStock().get(itemCode).getItemType().getName());
                trader.subtractMoney(itemTrueCost);
                System.out.println("You now have " + trader.getMoney() + " schmeckles");
            }
        }
    }
}