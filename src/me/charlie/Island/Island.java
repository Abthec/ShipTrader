package me.charlie.Island;

import me.charlie.Store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Island {

    private String name;
    private Store store;
    private Location location;

    /**
     * The default instance of Island.
     */
    public Island() {
        this("The Origin", new Location());
    }

    /**
     * Creates an instance of Island.
     * 
     * @param name the name of the Island.
     * @param location the Location of the Island.
     */
    public Island(String name, Location location) {
        this.location = location;
        this.name = name;
        this.store = new Store();
    }

    /**
     * 
     * @return the name of the Island.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return the Store on the Island.
     */
    public Store getStore() {
        return store;
    }

    /**
     * 
     * @return the location of the Island.
     */
    public Location getCoordinate() {
        return location;
    }

    /**
     * Converts an Island object to a String.
     */
    public String toString() {
        return "Welcome to " + this.getName() + ", on this island we have a " + this.getStore().getStoreType().getName() + ".\nPlease enjoy your stay.";
    }
}
