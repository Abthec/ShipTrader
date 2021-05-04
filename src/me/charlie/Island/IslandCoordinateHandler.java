package me.charlie.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IslandCoordinateHandler {

    List<Coordinate> islandCoordinates = new ArrayList<Coordinate>();
    private Random random = new Random();
    int islandTotal;

    public IslandCoordinateHandler(int islandTotal) {
        this.islandTotal = islandTotal;
        while (islandCoordinates.size() <= islandTotal - 1) {
            Coordinate newCoordinate = new Coordinate(random.nextInt(11), random.nextInt(11));
            if (!islandCoordinates.contains(newCoordinate)) {
                islandCoordinates.add(newCoordinate);
            }
        }
    }

    public List<Coordinate> getIslandCoordinates() {
        return islandCoordinates;
    }
}
