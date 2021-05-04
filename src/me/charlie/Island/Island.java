package me.charlie.Island;

import me.charlie.Store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Island {

    String name;
    Store store;
    Coordinate coordinate;
    List<Island> islands = new ArrayList<Island>();

    private Random random = new Random();

    public Island(Store store) {
        this.store = store;
        this.name = "The Origin";
        this.coordinate = new Coordinate();
    }

    public Island(String name, Store store, Coordinate coordinate) {
        this.coordinate = coordinate;
        this.name = name;
        this. store = store;
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
