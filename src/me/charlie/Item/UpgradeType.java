package me.charlie.Item;

public enum UpgradeType {
    CANNON,
    MAST,
    BULKHEAD,
    CARGO_HOLD;

    public String getName() {
        return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
    }
}
