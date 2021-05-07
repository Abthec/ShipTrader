package me.charlie.Store;

import me.charlie.Item.Item;
import me.charlie.Item.ItemType;

public enum StoreType {

    JEWELER,
    ARTIFICER,
    SHIP_BUILDER,
    BLACKSMITH;

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
                        return 0.75;
                    case WEAPON:
                        return 0.6;
                    case ARTIFACT:
                        return 1.1;
                }
            case BLACKSMITH:
                switch (itemType) {
                    case UPGRADE:
                        return 1.2;
                    case JEWEL:
                        return 0.75;
                    case WEAPON:
                        return 1.1;
                    case ARTIFACT:
                        return 1.1;
                }
            case SHIP_BUILDER:
                switch (itemType) {
                    case UPGRADE:
                        return 1.2;
                    case JEWEL:
                        return 0.75;
                    case WEAPON:
                        return 1.1;
                    case ARTIFACT:
                        return 1.1;
                }
            default:
                return 1.0;
        }
    }

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

    public String getName() {
        return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
    }
}
