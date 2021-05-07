package me.charlie.Game;

import me.charlie.Game.Game;
import me.charlie.Ship.Ship;
import me.charlie.Ship.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Ship selectedShip;
        String traderName = "";
        int gameDuration = 0;
        int islandTotal = 5;

        List<Ship> ships = new ArrayList<Ship>();

        ships.add(new Ship(ShipType.SCHOONER, 1.5, 3, 10, 100, null));
        ships.add(new Ship(ShipType.BARQUENTINE, 1.25, 10, 10, 100, null));
        ships.add(new Ship(ShipType.BRIGANTINE, 1.0, 10, 10, 100, null));
        ships.add(new Ship(ShipType.AIRCRAFT_CARRIER, 0.75, 200, 100, 1000, null));

        Scanner scanner = new Scanner(System.in);

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

        while (true) {
            System.out.println("Enter desired amount of days");
            gameDuration = Integer.parseInt(scanner.nextLine());

            if (gameDuration < 20 || gameDuration > 50) {
            	gameDuration = 0;
            	System.out.println("Game duration must be between 20 and 50 days");
            } else {
                System.out.println("Game will last " + gameDuration + " days.");
                break;
            }
        }

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

        Game game = new Game(traderName, gameDuration, selectedShip, islandTotal);
    }
}