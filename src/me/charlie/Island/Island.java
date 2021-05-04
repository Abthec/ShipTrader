package me.charlie.Island;

import me.charlie.Store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Island {

    String name;
    Store store;
    Location location;
    private List<Island> islands = new ArrayList<Island>();

    private Random random = new Random();

    public Island() {
        this("The Origin", new Location());
    }

    public Island(String name, Location location) {
        this.location = location;
        this.name = name;
        this.store = new Store();
    }

    public String getName() {
        return name;
    }

    public Store getStore() {
        return store;
    }

    public Location getCoordinate() {
        return location;
    }
}
