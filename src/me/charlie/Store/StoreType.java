package me.charlie.Store;

import me.charlie.Item.Item;

public enum StoreType {

    JEWELER,
    ARTIFICER,
    SHIP_BUILDER,
    BLACKSMITH;

    public double getBuyModifier(Item item) {
        switch (this) {
            case JEWELER:
                switch (item.getItemType()) {
                    case UPGRADE:
                        return 1.2;
                    case JEWEL:
                        return 0.75;
                    case WEAPON:
                    case ARTIFACT:
                        return 1.1;
                }
            case ARTIFICER:
                switch (item.getItemType()) {
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
                switch (item.getItemType()) {
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
                switch (item.getItemType()) {
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

    public double getSellModifier(Item item) {
        switch (this) {
            case JEWELER:
                switch (item.getItemType()) {
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
                switch (item.getItemType()) {
                    case UPGRADE:
                        return 1.2;
                    case JEWEL:
                        return 0.75;
                    case WEAPON:
                        return 1.1;
                    case ARTIFACT:
                        return 1.1;
                }
            case BLACKSMITH:
                switch (item.getItemType()) {
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
                switch (item.getItemType()) {
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

    public String getName() {
        return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
    }
}
