package me.charlie.Island;

/**
 * Stores information about locations on the game grid.
 * 
 * @author charlie
 *
 */
public class Location {

	int xCoordinate;
	int yCoordinate;

	/**
	 * Creates a set of coordinates for an Island.
	 * 
	 * @param xCoordinate the desired xCoordinate for the island.
	 * @param yCoordinate the desired yCoordinate for the island.
	 */
	public Location(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	/**
	 * Creates a set Location at 50, 50.
	 */
	public Location() {
		this(50, 50);
	}

	/**
	 * Calculates the diagonal distance between two Locations.
	 * 
	 * @param otherLocation the point you would like to calculate the distance to.
	 * @return the distance from this point to another.
	 */
	public double getDistance(Location otherLocation) {
		int deltaX = this.getX() - otherLocation.getX();
		int deltaY = this.getY() - otherLocation.getY();
		return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
	}

	/**
	 * 
	 * @return the x coordinate of this Location.
	 */
	public int getX() {
		return xCoordinate;
	}

	/**
	 * 
	 * @return the y coordinate of this Location.
	 */
	public int getY() {
		return yCoordinate;
	}
}