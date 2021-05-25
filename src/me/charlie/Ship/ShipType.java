package me.charlie.Ship;

public enum ShipType {
    SCHOONER,
    BRIGANTINE,
    BARQUENTINE,
    AIRCRAFT_CARRIER;

	/**
	 * 
	 * @return the ship type as a String.
	 */
    public String getName() {
        return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
    }
}