package me.charlie;

import me.charlie.Exceptions.IllegalDurationException;
import me.charlie.Exceptions.IllegalNameException;
import me.charlie.Island.Island;
import me.charlie.Ship.Ship;
import me.charlie.Ship.ShipType;
import me.charlie.Store.Store;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Ship schooner = new Ship(ShipType.SCHOONER, 0.5, 10, 10, 100);
//    Ship brigantine = new Ship();
//    Ship barquentine = new Ship();
//    Ship aircraft_carrier = new Ship();

        Island starterIsland = new Island("First", );

        String traderName = "";
        int gameDuration = 0;
        int islandTotal = 5;
        int islandCount = 0;
        ArrayList<Island> islands;
        islands = new ArrayList<Island>();

        Scanner scanner = new Scanner(System.in);

        while (traderName.length() < 3 || traderName.length() > 15) {
            System.out.println("Enter Trader Name");
            traderName = scanner.nextLine();
            if (traderName.length() < 3 || traderName.length() > 15) {
                throw new IllegalNameException("Length of trader name must be 3-15 characters.");
            }
        }

        while (gameDuration < 20 || gameDuration > 50) {
            System.out.println("Enter desired amount of days");
            gameDuration = Integer.parseInt(scanner.nextLine());

            if (gameDuration < 20 || gameDuration > 50) {
                throw new IllegalDurationException("Game duration must be 20-50 days.");
            }
        }

        Game game = new Game(traderName, gameDuration, schooner);
    }
}