package me.charlie.RandomEvents;

public enum RandomEventType {

    PIRATES,
    STORMY_WEATHER,
    DROWNING_SAILORS;

    public String getRETDescription(RandomEventType randomEventType) {
        switch (randomEventType) {
            case PIRATES:
                return "";
            default:
                return "Whoops";
        }
    }

    public String getName() {
        return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
    }
}
