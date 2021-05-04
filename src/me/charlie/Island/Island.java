package me.charlie.Island;

import me.charlie.Store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Island {

    String name;
    Store store;
    Coordinate coordinate;
    private List<Island> islands = new ArrayList<Island>();

    private Random random = new Random();

    public Island() {
        this("The Origin", new Coordinate());
    }

    public Island(String name, Coordinate coordinate) {
        this.coordinate = coordinate;
        this.name = name;
        this.store = new Store();
    }

    public String getName() {
        return name;
    }

    public Store getStore() {
        return store;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
