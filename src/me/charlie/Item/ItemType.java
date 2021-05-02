package me.charlie.Item;

public enum ItemType {

    UPGRADE,
    WEAPON,
    JEWEL,
    ARTIFACT;

    public int getSize() {
        switch (this) {
            case JEWEL:
                return 1;
            case WEAPON:
                return 2;
            case UPGRADE:
                return 3;
            case ARTIFACT:
                return 4;
            default:
                return 5;
        }
    }

    public String getDescription() {
        switch (this) {
            default:
                return "This is a " + getName();
        }
    }

    public String getName() {
        return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
    }
}
