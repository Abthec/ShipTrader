package me.charlie.Game;

import me.charlie.Island.Island;
import me.charlie.Item.Item;
import me.charlie.Ship.Ship;
import me.charlie.Ship.ShipType;
import me.charlie.Store.Store;
import me.charlie.Trader.Trader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {

    private Scanner scanner;
    String traderName;
    Ship selectedShip;
    int gameDuration;

    public ConsoleApp() {
        this.scanner = new Scanner(System.in);
    }

    public Game Start() {

        String traderName = chooseTraderName();
        int gameDuration = chooseGameDuration();
        Ship selectedShip = chooseShip();
        int islandTotal = 5;

        Game game = new Game(traderName, gameDuration, selectedShip, islandTotal);
        return game;
    }

    public int getNumberCode() {
        while (true) {
            try {
                int numberCode = Integer.parseInt(scanner.nextLine());
                return numberCode;
            } catch (Exception e) {

            }
            System.out.println("Please input a number");
        }
    }

    public void chooseActivity(Trader trader) {
        Ship ship = trader.getShip();
        Island currentIsland = ship.getCurrentIsland();
        Scanner scanner = new Scanner(System.in);

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

                    }
                case 2:
                    visitStore(trader);
                    break activityChooser;
                case 3:
                    break activityChooser;
                case 4:
                    if (ship.getShipHealth() == ship.getShipEndurance()) {
                        System.out.println("Ship is not in need of repairs.\nChoose again.");
                        continue activityChooser;
                    } else {
                        break activityChooser;
                    }
                default:
                    System.out.println("Sorry that is not a valid code please try again.");
            }
        }
    }

    public void visitStore(Trader trader) {

        Scanner scanner = new Scanner(System.in);
        Ship ship = trader.getShip();
        Island currentIsland = ship.getCurrentIsland();
        Store store = currentIsland.getStore();
        System.out.println("Welcome to " + store);

        shopActions:
        while (true) {
            System.out.println("1: [Buy], 2: [Sell], 3: [Leave] - insert answer code below:");
            int action = getNumberCode();
            if (action == 1) {
                purchaseItems(trader);
                continue shopActions;
            } else if (action == 2) {
                sellItems(trader);
                break;
            } else if (action == 3) {
                System.out.println("Goodbye. Thank you for shopping with us.");
                break;
            } else {
                System.out.println("That was not a valid option please try again.");
            }
        }
    }

    public void purchaseItems(Trader trader) {
        Ship ship = trader.getShip();
        Store store = ship.getCurrentIsland().getStore();
        int cash = trader.getMoney();
        int chosenItemID;

        if (ship.getCargoSpaceRemaining() == 0) {
            System.out.println("""
                            You cannot fit anymore items sorry.
                            Would you like to do something else?""");
        } else {
            buyWindow:
            while (true) {
                viewStock(ship);
                System.out.println(cash + "\nEnter the ID of the item you'd like to purchase.\nOr if you have changed your mind enter 0");

                while (true) {
                    chosenItemID = getNumberCode() - 1;
                    if (chosenItemID == -1) {
                        break buyWindow;
                    } else if (chosenItemID >= store.getStock().size() || chosenItemID < -1) {
                        System.out.println("That is not a valid item ID. Please try again.");
                        continue;
                    } else {
                        break;
                    }
                }

                Item chosenItem = store.getStock().get(chosenItemID);
                if (chosenItem.getBuyCost() == cash) {
                    System.out.println("Warning! Buying this item will leave you with 0 coins. Would you like to proceed?" +
                            "\n1: [Yes] | 2: [No]");
                    int proceedToPurchase = getNumberCode();
                    if (proceedToPurchase == 1) {
                        if (ship.addItemToCargo(chosenItem)) {
                            ship.getCurrentIsland().getStore().buyItem(chosenItem);
                            trader.subtractMoney(chosenItem.getBuyCost());
                        }
                        System.out.println("Is there anything else I can help you with?");
                        break;
                    }
                } else if (chosenItem.getBuyCost() < cash) {
                    if (ship.addItemToCargo(chosenItem)) {
                        ship.getCurrentIsland().getStore().buyItem(chosenItem);
                        trader.subtractMoney(chosenItem.getBuyCost());
                    }
                    System.out.println("Is there anything else I can help you with?");
                    break;
                } else {
                    System.out.println("You cannot afford this item.\nWould you like to chose another?\n" +
                            "\n1: [Yes] | 2: [No]");
                    int retryBuy = getNumberCode();
                    while (true) {
                        if (retryBuy == 1) {
                            continue;
                        } else if (retryBuy == 2) {
                            break;
                        } else {
                            System.out.println("Please enter - 1: [Yes] | 2: [No].");
                            retryBuy = getNumberCode();
                        }
                    }
                }
            }
        }
    }

    public void sellItems(Trader trader) {
        Ship ship = trader.getShip();

        if (ship.isCargoEmpty()) {
            System.out.println("You do not have any items to sell.");
        } else {

        }
    }

    public void viewStock(Ship ship) {

        Store store = ship.getCurrentIsland().getStore();

        System.out.println("Here are the items available");
        int itemID = 1;
        System.out.println("You currently have " + ship.getCargoSpaceRemaining() + " cargo space remaining.");
        for (Item item : store.getStock()) {
            System.out.println("ID: Item Type | Item Cost | Item Size");
            System.out.println(itemID + ": " + item + item.getBuyCost() + " | " + item.getSize());
            itemID++;
        }
    }

    public String chooseTraderName() {
        while (true) {
            System.out.println("Enter Trader Name");
            traderName = scanner.nextLine();
            if (traderName.length() < 3 || traderName.length() > 15) {
                System.out.println("Length of trader name must be 3-15 characters.");
            } else if (!traderName.matches("^[a-zA-Z]*$")) {
                System.out.println("You may only use alphabetical characters.");
            } else {
                System.out.println("Welcome Captain " + traderName);
                break;
            }
        }
        return traderName;
    }

    public int chooseGameDuration() {
        while (true) {
            System.out.println("Enter desired amount of days");
            gameDuration = Integer.parseInt(scanner.nextLine());
            if (gameDuration < 20 || gameDuration > 50) {
                System.out.println("Game duration must be between 20 and 50 days");
            } else {
                System.out.println("Game will last " + gameDuration + " days.");
                break;
            }
        }
        return gameDuration;
    }

    public Ship chooseShip() {

        List<Ship> ships = new ArrayList<Ship>();

        ships.add(new Ship(ShipType.SCHOONER, 1.5, 3, 10, 100, null));
        ships.add(new Ship(ShipType.BARQUENTINE, 1.25, 10, 10, 100, null));
        ships.add(new Ship(ShipType.BRIGANTINE, 1.0, 10, 10, 100, null));
        ships.add(new Ship(ShipType.AIRCRAFT_CARRIER, 0.75, 200, 100, 1000, null));

        System.out.println("Choose your ship!");
        System.out.println("Name | Speed | Max Cargo Capacity | Max Crew Size | Ship Health");
        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        shipSelector:
        while (true) {
            String selectedShipType = scanner.nextLine();
            for (Ship ship : ships) {
                if (ship.getShipType().getName().equalsIgnoreCase(selectedShipType)) {
                    selectedShip = ship;
                    break shipSelector;
                }
            }
            System.out.println("Invalid ship name, choose again.");
        }
        return selectedShip;
    }

    public void gameover() {
        System.out.println("Gameover!");
    }

    public static void main(String[] args) {

        ConsoleApp consoleApp = new ConsoleApp();
        Game game = consoleApp.Start();
        while (true) {
            consoleApp.chooseActivity(game.getTrader());
        }

    }
}