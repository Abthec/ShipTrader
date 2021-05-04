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
            Location newLocation = new Location(random.nextInt(101), random.nextInt(101));
            if (!islandLocations.contains(newLocation)) {
                islandLocations.add(newLocation);
            }
        }
    }

    public List<Location> getIslandCoordinates() {
        return islandLocations;
    }

    public Location getCoordinate() {
        location = this.islandLocations.get(0);
        this.islandLocations.remove(0);
        return location;
    }
}
