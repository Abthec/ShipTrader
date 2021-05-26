package me.charlie.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Creates locations for the Islands.
 * 
 * @author charlie
 *
 */
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

	/**
	 * 
	 * @return a List of the Locations of all the Islands.
	 */
	public List<Location> getIslandCoordinates() {
		return islandLocations;
	}

	/**
	 * 
	 * @return the Location of the first Island in the List.
	 */
	public Location getCoordinate() {
		location = this.islandLocations.get(0);
		this.islandLocations.remove(0);
		return location;
	}
}
