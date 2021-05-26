package me.charlie.Item;

/**
 * Defines the types of potential ship upgrades and their characteristics.
 * 
 * @author charlie
 *
 */
public enum UpgradeType {
    CANNON,
    MAST,
    BULKHEAD,
    CARGO_HOLD;

	public String getDescription(UpgradeType upgradeType) {
		switch(upgradeType) {
			case CANNON:
				return "Adds one cannon to your ship. Cannons help when fighting pirates!";
			case MAST:
				return "Increases sailing speed by 10%!";
			case BULKHEAD:
				return "Increases ship endurance by 10%!";
			case CARGO_HOLD:
				return "Increases cargo space by 2!";
			default:
				return "If you're seeing this something is wrong. Well done!";
		}
	}
	
	/**
	 * 
	 * @return the UpgradeType converted to a formatted String.
	 */
    public String getName() {
        return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
    }
}
