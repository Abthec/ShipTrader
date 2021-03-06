package me.charlie.Game;

import me.charlie.Island.Island;
import me.charlie.Island.Route;
import me.charlie.Item.Item;
import me.charlie.Item.ItemType;
import me.charlie.Item.UpgradeType;
import me.charlie.RandomEvents.RandomEventType;
import me.charlie.Ship.Ship;
import me.charlie.Ship.ShipNameHandler;
import me.charlie.Ship.ShipType;
import me.charlie.Store.Store;
import me.charlie.Trader.Trader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Runs a command line application to play the game.
 * 
 * @author charlie
 *
 */
public class ConsoleApp {

    private Scanner scanner;
    private Route chosenRoute;
    private String traderName;
    private Ship selectedShip;
    private int gameDuration;

    /**
     * Creates an instance of ConsoleApp
     * Creates an instance of Scanner.
     */
    public ConsoleApp() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Creates an instance of the Game class.
     * 
     * @return an instance of the Game class.
     */
    public Game Start() {

        String traderName = chooseTraderName();
        int gameDuration = chooseGameDuration();
        Ship selectedShip = chooseShip();
        int islandTotal = 5;

        Game game = new Game(traderName, gameDuration, selectedShip, islandTotal);
        return game;
    }

    /**
     * Takes a maximum number and gets a numerical input from the player.
     * 
     * @param maxNumberCode the maximum accepted number.
     * @return a numerical value corresponding to some ID system.
     */
    public int getNumberCode(int maxNumberCode) {
        while (true) {
            try {
                int numberCode = Integer.parseInt(scanner.nextLine());
                if (numberCode > maxNumberCode || numberCode < 0) {
                    System.out.println("Please enter a number within the required range");
                    continue;
                }
                return numberCode;
            } catch (Exception e) {
            }
            System.out.println("Please input a number");
        }
    }

    /**
     * Acts as a pause point so the flow of the game can be controlled by the player.
     */
    public void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue.");
        scanner.nextLine();
    }

    /**
     * Asks the player what activity they would like to carry out.
     * Executes the chosen activity.
     * 
     * @param game the current instance of the game.
     */
    public void chooseActivity(Game game) {
        Trader trader = game.getTrader();
        Ship ship = trader.getShip();
        Island currentIsland = ship.getCurrentIsland();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which of the following activities would you like to do?"+
                "/n1: Sail to another Island?"+
                "/n2: Visit the store?"+
                "/n3: Look for more crew to hire?"+
                "/n4: Repair your ship?"+
                "/n5: View ship properties.");
        activityChooser:
        while (true) {
            int activityCode = getNumberCode(5);
            switch (activityCode) {
                case 1:
                    if (ship.getShipHealth() < ship.getShipEndurance()) {
                        System.out.println("Cannot go sailing with a damaged ship.\nChoose again.");
                    } else {
                        sail(game);
                    }
                    break activityChooser;
                case 2:
                    visitStore(trader);
                    break activityChooser;
                case 3:
                    hireCrew(ship);
                    break activityChooser;
                case 4:
                    if (ship.getShipHealth() == ship.getShipEndurance()) {
                        System.out.println("Ship is not in need of repairs.\nChoose again.");
                        continue activityChooser;
                    } else {
                        repairShip(game.getTrader());
                        break activityChooser;
                    }
                case 5:
                    viewShipProperties(ship);
                    break activityChooser;
                default:
                    continue;
            }
        }
    }

    /**
     * The menu dialogue for ship repairing.
     * Displays costs to repair.
     * Displays the properties of a repair.
     * 
     * @param trader the instance of the players character the Trader.
     */
    public void repairShip(Trader trader) {
        Ship ship = trader.getShip();
        System.out.println("Current ship health is: " + ship.getShipHealth() + "/" + ship.getShipEndurance() +
                ".\nThe cost to repair your ship is 100 coins." +
                "\nRepairing your ship will increase your ship health by " + ship.getShipEndurance() / 10 +
                "\nTo repair to full health it will cost " + getFullRepairCost(ship) +
                "\n0: [Leave] 1: [Repair Once] 2: [Full Repair]");
        int action = getNumberCode(3);
        if (action == 1) {
            trader.subtractMoney(100);
            ship.addShipHealth();
            System.out.println("New ship health is " + ship.getShipHealth());
        } else if (action == 2) {
            trader.subtractMoney(getFullRepairCost(ship));
            ship.repairFull();
            System.out.println("New ship health is " + ship.getShipHealth());
        }
    }

    /**
     * Calculates the cost to fully repair the players ship.
     * 
     * @param ship the current instance of the Ship class for the given game.
     * @return the cost to fully repair the ship as an int.
     */
    public int getFullRepairCost(Ship ship) {
        double eachRepair = ship.getShipEndurance() / 10;
        double healthMissing = ship.getShipEndurance() - ship.getShipHealth();
        int numberOfRepairs = (int) Math.ceil(healthMissing / eachRepair);
        int fullRepairCost = numberOfRepairs * 100;
        return fullRepairCost;
    }

    /**
     * Provides information about hiring crew members.
     * 
     * @param ship the current instance of the Ship class for the given game.
     */
    public void hireCrew(Ship ship) {
        System.out.println("Hiring a crew member will add 10 coins extra wages per day sailed." +
                "\nCurrent crew wages are " + ship.getCurrentCrewSize() * 10 + "." +
                "\nWould you like to hire a new member - 1: [Yes] 2: [No]");
        int response = getNumberCode(2);
        if (response == 1) {
            ship.hireCrewMember();
        }
    }

    /**
     * Displays the ships properties.
     * 
     * @param ship the current instance of the Ship class for the given game.
     */
    public void viewShipProperties(Ship ship) {

        System.out.println("Ship name: " + ship.getName());
        System.out.println("Ship Type | Sail Speed | Current Cargo | Current Crew Size | Current Ship Health");
        System.out.println(ship.getProperties());

        upgradeShip(ship);

        System.out.println("Would you like to view your current cargo?" +
                "\n1: [Yes] 2: [No]");
        int action = getNumberCode(2);
        if (action == 1) {
            ship.viewCurrentCargo();
        }

        pressAnyKeyToContinue();
    }

    /**
     * Prints a list of the upgrades possessed by the player.
     * Asks the player which upgrade they would like to apply.
     * 
     * @param ship the current instance of the Ship class for the given game.
     */
    public void upgradeShip(Ship ship) {
        List<Item> upgrades = new ArrayList<>();

        for (Item item : ship.getCurrentCargo()) {
            if (item.getItemType().equals(ItemType.UPGRADE)) {
                upgrades.add(item);
            }
        }

        if (upgrades.size() == 0) {
            System.out.println("You do not currently have any upgrades for your ship. You can purchase upgrades from the shop.");
        } else {
            System.out.println("You currently have " + upgrades.size() + " upgrades available." +
                    "\nWould you like to view them? 1: [Yes] 2: [No]");
            int view = getNumberCode(2);
            if (view == 1) {
                int upgradeId = 1;
                System.out.println("Available upgrades are:" +
                        "\nID: | Upgrade Type");
                for (Item item : upgrades) {
                    System.out.println(upgradeId + item.getUpgradeType().getName());
                    upgradeId++;
                }
                System.out.println("Would you like to apply an upgrade to your ship?" +
                        "\n If [Yes] enter the ID of the upgrade you would like to apply. If [No] enter 0.");
                int upgrade = getNumberCode(upgradeId);
                if (!(upgrade == 0)) {
                    applyUpgrade(upgrades.get(upgrade - 1).getUpgradeType(), ship);
                }
            }

        }
    }

    /**
     * Applies a chosen upgrade to the ship.
     * 
     * @param upgrade the upgrade the player has purchased and chosen to apply.
     * @param ship he current instance of the Ship class for the given game.
     */
    public void applyUpgrade(UpgradeType upgrade, Ship ship) {
        switch (upgrade) {
            case MAST:
                ship.upgradeSailSpeed();
                break;
            case CANNON:
                System.out.println("A cannon was added.");
            case BULKHEAD:
                System.out.println("The ships endurance went up.");
                ship.upgradeShipEndurance();
                break;
            case CARGO_HOLD:
                System.out.println("The ships max cargo capacity went up.");
                ship.upgradeCargoCapacity();
                break;
        }
    }

    /**
     * Prints the options for the store interface.
     * 
     * @param trader the current isntance of the Trader class for the given Game.
     */
    public void visitStore(Trader trader) {

        Scanner scanner = new Scanner(System.in);
        Ship ship = trader.getShip();
        Island currentIsland = ship.getCurrentIsland();
        Store store = currentIsland.getStore();
        System.out.println("Welcome to " + store);

        while (true) {
            System.out.println("1: [Buy], 2: [Sell], 3: [Leave] - insert answer code below:");
            int action = getNumberCode(3);
            if (action == 1) {
                purchaseItems(trader);
                continue;
            } else if (action == 2) {
                sellItems(trader);
                continue;
            } else if (action == 3) {
                System.out.println("Goodbye. Thank you for shopping with us.");
                break;
            } else {
                System.out.println("That was not a valid option please try again.");
            }
        }
    }

    /**
     * Asks the player which item they would like to purchase.
     * 
     * @param trader the current instance of the Trader class for the Given game.
     */
    public void purchaseItems(Trader trader) {
        Ship ship = trader.getShip();
        Store store = ship.getCurrentIsland().getStore();
        int cash = trader.getMoney();
        int chosenItemID;

        if (ship.getCargoSpaceRemaining() == 0) {
            System.out.println("You cannot fit anymore items sorry."+
                    "/nWould you like to do something else?");
        } else {
            buyWindow:
            while (true) {
                viewStock(ship);
                System.out.println(cash + "\nEnter the ID of the item you'd like to purchase.\nOr if you have changed your mind enter 0");

                while (true) {
                    chosenItemID = getNumberCode(store.getStock().size()) - 1;
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
                    int proceedToPurchase = getNumberCode(2);
                    if (proceedToPurchase == 1) {
                        if (ship.addItemToCargo(chosenItem)) {
                            ship.getCurrentIsland().getStore().buyItem(chosenItem);
                            trader.subtractMoney(chosenItem.getBuyCost());
                            pressAnyKeyToContinue();
                        }
                        System.out.println("Is there anything else I can help you with?");
                        break;
                    }
                } else if (chosenItem.getBuyCost() < cash) {
                    if (ship.addItemToCargo(chosenItem)) {
                        ship.getCurrentIsland().getStore().buyItem(chosenItem);
                        trader.subtractMoney(chosenItem.getBuyCost());
                        pressAnyKeyToContinue();
                    }
                    System.out.println("Is there anything else I can help you with?");
                    break;
                } else {
                    System.out.println("You cannot afford this item."+
                            "/nWould you like to chose another?" +
                            "/n1: [Yes] | 2: [No]");
                    int retryBuy = getNumberCode(2);
                    while (true) {
                        if (retryBuy == 1) {
                            continue;
                        } else if (retryBuy == 2) {
                            break;
                        } else {
                            System.out.println("Please enter - 1: [Yes] | 2: [No].");
                            retryBuy = getNumberCode(2);
                        }
                    }
                }
            }
        }
    }

    /**
     * Prints a list of all the items possessed by the player and asks if/what they would like to sell.
     * 
     * @param trader the current given of the Trader class for the current game.
     */
    public void sellItems(Trader trader) {
        Ship ship = trader.getShip();
        Store store = ship.getCurrentIsland().getStore();

        while (true) {
            if (ship.isCargoEmpty()) {
                System.out.println("You do not have any items to sell.");
                pressAnyKeyToContinue();
                break;
            } else {
                System.out.println("These are the items you have available to sell."+
                        "/nID: Item Type | Sell Price");
                ship.viewCurrentCargo(store);
                System.out.println("Would you like to sell one of these items? - 1: [Yes] 2: [No]");
                int chooseToSell = getNumberCode(2);
                if (chooseToSell == 1) {
                    System.out.println("Enter the ID of the item you would like to sell.");
                    int chosenItemId = getNumberCode(ship.getCargoFullness());
                    Item chosenItem = ship.getCurrentCargo().get(chosenItemId - 1);
                    ship.getCurrentCargo().remove(chosenItemId);
                    System.out.println("The item was removed from the cargo hold." +
                            "\nYou now have " + ship.getCargoSpaceRemaining() + " cargo space left.");
                    trader.addMoney(chosenItem.getSellCost(store));
                    if (ship.isCargoEmpty()) {
                        System.out.println("You do not have any items to sell.");
                        pressAnyKeyToContinue();
                        break;
                    } else {
                        System.out.println("Would you like to sell another item? - 1: [Yes] or 2: [No].");
                        int nextAction = getNumberCode(2);
                        if (nextAction == 1) {
                            continue;
                        } else {
                            break;
                        }
                    }
                } else if (chooseToSell == 2) {
                    System.out.println("Is there anything else I can help you with?");
                    break;
                }
            }


        }
    }

    /**
     * Prints a list of all the available Item's for the current Island's Store.
     * 
     * @param ship the given instance of Ship for the current game.
     */
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

    /**
     * Relocates the Ship and Trader to a new Island based on a chosen route.
     * 
     * @param game the current instance of the Game.
     */
    public void sail(Game game) {
        chooseRoute(game);
        if (chosenRoute == null) {
            return;
        }
        if (chosenRoute.getRandomEvent().doesEventOccur()) {
            applyRandomEvent(chosenRoute.getRandomEvent().getRandomEventType(), game.getShip());
        }
        game.getShip().setCurrentIsland(chosenRoute.getIslandB());
        System.out.println("You have arrived. " + chosenRoute.getIslandB());
        game.setDaysRemaining(chosenRoute.getSailDuration(game.getShip()));
        game.getTrader().subtractMoney(chosenRoute.getSailCost(game.getShip()));
        System.out.println("After paying your crew you now have: " + game.getTrader().getMoney() + " coins left.");
        System.out.println("There is " + game.getDaysRemaining() + " days left.");
        pressAnyKeyToContinue();
    }

    /**
     * Applies a RandomEvent that occurs on a given Route.
     * 
     * @param randomEventType the RandomEvent's RandomEventType which determines what consequences there are.
     * @param ship the current instance of the Ship given the current Game.
     */
    public void applyRandomEvent(RandomEventType randomEventType, Ship ship) {
        Random random = new Random();

        switch (randomEventType) {
            case PIRATES:
                System.out.println("You see pirates on the horizon");
                break;
            case DROWNING_SAILORS:
                System.out.println("You see sailors drowning in the water."+
                        "/nIf you save them they may join your crew or give you a reward!"+
                        "/nWill you save them?"+
                        "/n1: [Yes] 2: [No]");
                int saveSailors = getNumberCode(2);

                if (saveSailors == 1) {
                    int sailorsSaved = 1 + random.nextInt(2);
                    System.out.println("You saved " + sailorsSaved + " sailors." +
                            "\nThey have given you 100 coins each as a reward.");
                    if (ship.getCurrentCrewSize() < ship.getMaxCrewSize()) {
                        System.out.println("The rescued sailors have offered to join your crew will you accept" +
                                "\n1: [Yes] 2: [No]");
                        int yesOrNo = getNumberCode(2);
                        if (yesOrNo == 1) {
                            for (int i=0; i < sailorsSaved; i++) {
                                if (ship.getCurrentCrewSize() < ship.getMaxCrewSize()) {
                                    ship.hireCrewMember();
                                    System.out.println("A member was added to your crew.");
                                } else {
                                    System.out.println("Your crew is full you cannot get any more members.");
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case STORMY_WEATHER:
                double healthRemoved = 25 + random.nextInt(25);
                ship.removeShipHealth(healthRemoved);
                System.out.println("While sailing you encountered stormy weather." +
                        "\nUnfortunately due to the bad weather your ship took some damage." +
                        "\nYour ship took " + healthRemoved + " damage." +
                        "\nYour ship has " + ship.getShipHealth() + "/" + ship.getShipEndurance() +
                        "\nYou must repair it at the next island before you can sail again.");
                break;
        }
    }

    /**
     * Asks a player to choose a Route to sail on to get to another Island.
     * 
     * @param game the current instance of the Game.
     */
    public void chooseRoute(Game game) {
        Ship ship = game.getShip();
        Island currentIsland = ship.getCurrentIsland();
        int count = 1;

        List<Route> routes = game.getRoutes();
        List<Route> availableRoutes = new ArrayList<>();
        System.out.println("Please select the route you would like to take." +
                "\nRoute ID: Island From | Island To | Distance | Description");

        for (Route route : routes) {
            if (route.getIslandA().equals(currentIsland)) {
                System.out.println(count + ": " + route.toString(ship));
                availableRoutes.add(route);
                count++;
            }
        }

        while (true) {
            System.out.println("Enter the route ID of your chosen route. Or enter [0] to exit.");
            int chosenRouteId = getNumberCode(availableRoutes.size()) - 1;
            if (chosenRouteId == -1) {
                break;
            } else {
                Route route = availableRoutes.get(chosenRouteId);
                if (game.getDaysRemaining() >= route.getSailDuration(ship)) {
                    this.chosenRoute = route;
                    break;
                } else {
                    System.out.println("There is not enough time remaining to sail to that island." +
                            "\nPlease choose another.");
                }
            }
        }
    }

    /**
     * Asks the player what they would like their Trader to be called.
     * 
     * @return the name as a String, selected by the player.
     */
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

    /**
     * Asks the player how long they would like the game to last.
     * 
     * @return the gameDuration as an int that the player chose.
     */
    public int chooseGameDuration() {
        while (true) {
            System.out.println("Enter desired amount of days");
            gameDuration = getNumberCode(50);
            if (gameDuration < 20 || gameDuration > 50) {
                System.out.println("Game duration must be between 20 and 50 days");
            } else {
                System.out.println("Game will last " + gameDuration + " days.");
                break;
            }
        }
        return gameDuration;
    }

    /**
     * Presents the player with four options for ships.
     * Asks the player what Ship they would like to use in the Game.
     * 
     * @return the Ship chosen by the player.
     */
    public Ship chooseShip() {

        List<Ship> ships = new ArrayList<Ship>();
        ShipNameHandler shipNameHandler = new ShipNameHandler();

        ships.add(new Ship(ShipType.SCHOONER, 1, 17.5, 10, 15, 250, null, shipNameHandler.getName()));
        ships.add(new Ship(ShipType.BARQUENTINE, 2, 20, 8, 12, 150, null, shipNameHandler.getName()));
        ships.add(new Ship(ShipType.BRIGANTINE, 3, 16, 18, 24, 310, null, shipNameHandler.getName()));
        ships.add(new Ship(ShipType.AIRCRAFT_CARRIER, 4, 15, 30, 50, 750, null, shipNameHandler.getName()));

        System.out.println("Choose your ship!");
        System.out.println("ID: Name | Speed | Max Cargo Capacity | Max Crew Size | Ship Health");
        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        System.out.println("Enter your chosen ship ID.");
        shipSelector:
        while (true) {
            int shipId = getNumberCode(4);
            for (Ship ship : ships) {
                if (ship.getShipId() == shipId) {
                    selectedShip = ship;
                    break shipSelector;
                }
            }
        }
        return selectedShip;
    }

    /**
     * Ends the game and tells the player how much money they ended with.
     * 
     * @param trader the instance of Trader for the current Game.
     */
    public void gameover(Trader trader) {
        System.out.println("Gameover!");
        System.out.println("You finished with " + trader.getMoney());
    }

    /**
     * Where the Game is executed.
     * 
     * @param args.
     */
    public static void main(String[] args) {

        ConsoleApp consoleApp = new ConsoleApp();
        Game game = consoleApp.Start();
        List<Route> routes = game.getRoutes();
        while (game.canSailToAnotherIsland() || game.getShip().getCurrentCargo().size() > 0) {
            consoleApp.chooseActivity(game);
        }
        consoleApp.gameover(game.getTrader());
    }
}