package me.charlie.RandomEvents;

public enum RandomEventRarity {

    COMMON,
    UNCOMMON,
    RARE;

    public double getEventDistanceModifier() {
        switch (this) {
            case RARE:
                return 1.0;
            case UNCOMMON:
                return 0.75;
            case COMMON:
                return 0.5;
        }
        return 1.0;
    }

    public double getChanceOfEventOccurring() {
        switch (this) {
            case RARE:
                return 0.1;
            case UNCOMMON:
                return 0.6;
            case COMMON:
                return 0.8;
        }
        return 1.0;
    }
}
