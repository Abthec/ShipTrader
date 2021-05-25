package me.charlie.Store;

import me.charlie.Item.ItemType;

public enum StoreType {

    JEWELER,
    ARTIFICER,
    SHIP_BUILDER,
    BLACKSMITH;

	/**
	 * gets the purchasing coefficient depending on StoreType and ItemType.
	 * 
	 * @param itemType the type of an item in the store.
	 * @return the purchasing coefficient of a given ItemType.
	 */
    public double getBuyModifier(ItemType itemType) {
        switch (this) {
            case JEWELER:
                switch (itemType) {
                    case UPGRADE:
                        return 1.2;
                    case JEWEL:
                        return 0.75;
                    case WEAPON:
                    case ARTIFACT:
                        return 1.1;
                }
            case ARTIFICER:
                switch (itemType) {
                    case UPGRADE:
                        return 1.6;
                    case JEWEL:
                        return 1.2;
                    case WEAPON:
                        return 1.1;
                    case ARTIFACT:
                        return 0.7;
                }
            case  BLACKSMITH:
                switch (itemType) {
                    case UPGRADE:
                        return 1.0;
                    case JEWEL:
                        return 1.3;
                    case WEAPON:
                        return 0.6;
                    case ARTIFACT:
                        return 1.5;
                }
            case SHIP_BUILDER:
                switch (itemType) {
                    case UPGRADE:
                        return 0.9;
                    case JEWEL:
                        return 1.5;
                    case WEAPON:
                        return 1.1;
                    case ARTIFACT:
                        return 1.4;
                }
            default:
                return 1.0;
        }
    }

    /**
     * get the selling coefficient of a given ItemType depending on the Store at which it is being sold.
     * 
     * @param itemType the type of an item in the players inventory within the Store sell window.
     * @return the selling coefficient of a a given ItemType at a given StoreType.
     */
    public double getSellModifier(ItemType itemType) {
        switch (this) {
            case JEWELER:
                switch (itemType) {
                    case UPGRADE:
                        return 1.2;
                    case JEWEL:
                        return 0.4;
                    case WEAPON:
                        return 1.1;
                    case ARTIFACT:
                        return 1.1;
                }
            case ARTIFICER:
                switch (itemType) {
                    case UPGRADE:
                        return 1.2;
                    case JEWEL:
                        return 1.1;
                    case WEAPON:
                        return 1.6;
                    case ARTIFACT:
                        return 0.5;
                }
            case BLACKSMITH:
                switch (itemType) {
                    case UPGRADE:
                        return 1.7;
                    case JEWEL:
                        return 0.75;
                    case WEAPON:
                        return 0.1;
                    case ARTIFACT:
                        return 1.3;
                }
            case SHIP_BUILDER:
                switch (itemType) {
                    case UPGRADE:
                        return 0.9;
                    case JEWEL:
                        return 1.3;
                    case WEAPON:
                        return 1.7;
                    case ARTIFACT:
                        return 1.2;
                }
            default:
                return 1.0;
        }
    }

    /**
     * get the maximum amount of items a given StoreType can have within their stock.
     * 
     * @return the maximum size of a Store's stock list given their StoreType.
     */
    public int getMaxStockBound() {
        switch (this) {
            case BLACKSMITH:
                return 40;
            case SHIP_BUILDER:
                return 35;
            case JEWELER:
                return 32;
            case ARTIFICER:
                return 34;
            default:
                return 0;
        }
    }

    /**
     * get the minimum amount of items a given StoreType can have within their stock.
     * 
     * @return the minimum size of a Store's stock list given their StoreType.
     */
    public int getMinStockBound() {
        switch (this) {
            case BLACKSMITH:
                return 20;
            case SHIP_BUILDER:
                return  15;
            case JEWELER:
                return 12;
            case ARTIFICER:
                return 10;
            default:
                return 0;
        }
    }

    /**
     * 
     * @return a StoreType converted to a string.
     */
    public String getName() {
        return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
    }
}
