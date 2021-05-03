package me.charlie;

import me.charlie.Island.Island;
import me.charlie.Ship.Ship;
import me.charlie.Ship.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Ship schooner = new Ship(ShipType.SCHOONER, 0.5, 10, 10, 100);

//    Ship brigantine = new Ship();
//    Ship barquentine = new Ship();
//    Ship aircraft_carrier = new Ship();

        Ship selectedShip = new Ship(ShipType.SCHOONER, 1, 1, 1, 1);
//        Island starterIsland = new Island("First", store, 0, 0);

        String traderName = "";
        int gameDuration = 0;
        int islandTotal = 5;
        int islandCount = 0;
        boolean shipSelected = false;

        List<Island> islands = new ArrayList<Island>();
        List<Ship> ships = new ArrayList<Ship>();

        ships.add(schooner);

        Scanner scanner = new Scanner(System.in);

        while (traderName.length() < 3 || traderName.length() > 15) {
            System.out.println("Enter Trader Name");
            traderName = scanner.nextLine();
            if (traderName.length() < 3 || traderName.length() > 15) {
                System.out.println("Length of trader name must be 3-15 characters.");
            }
        }

        while (gameDuration < 20 || gameDuration > 50) {
            System.out.println("Enter desired amount of days");
            gameDuration = Integer.parseInt(scanner.nextLine());

            if (gameDuration < 20 || gameDuration > 50) {
            	gameDuration = 0;
            	System.out.println("Game duration must be between 20 and 50 days");
            }
        }

        System.out.println("Choose your ship!");
        System.out.println("Name | Speed | Max Cargo Capacity | Max Crew Size | Ship Health");
        for (Ship ship : ships) {
            System.out.println(ship.toString());
        }

        while (shipSelected == false) {
            String selectedShipType = scanner.nextLine();
            for (Ship shipB : ships) {
                if (shipB.getShipType().getName().equalsIgnoreCase(selectedShipType)) {
                    selectedShip = shipB;
                    shipSelected = true;
                } else {
                    System.out.println("Invalid ship name, choose again");
                }
            }
        }

        Game game = new Game(traderName, gameDuration, selectedShip);
    }
}