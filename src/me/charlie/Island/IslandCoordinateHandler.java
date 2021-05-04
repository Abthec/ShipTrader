package me.charlie.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IslandCoordinateHandler {

    private List<Location> islandLocations = new ArrayList<Location>();
    Location location;
    private Random random = new Random();
    int islandTotal;

    public IslandCoordinateHandler(int islandTotal) {
        this.islandTotal = islandTotal;
        while (islandLocations.size() <= islandTotal - 1) {
            Location newLocation = new Location(random.nextInt(11), random.nextInt(11));
            if (!islandLocations.contains(newLocation)) {
                islandLocations.add(newLocation);
            }
        }
    }

    public List<Location> getIslandCoordinates() {
        return islandLocations;
    }

    public Location getCoordinate() {
        location = islandLocations.get(0);
        islandLocations.remove(0);
        return location;
    }
}
