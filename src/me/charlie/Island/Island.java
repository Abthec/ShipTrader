package me.charlie.Island;

import me.charlie.Store.Store;

import java.util.Random;

public class Island {

    int xPosition;
    int yPosition;
    String name;
    Store store;
    private Random random = new Random();

    public Island() {
        this.name = "The Origin";
        this.xPosition = 0;
        this.yPosition = 0;
    }

    public Island(String name, Store store) {
        this.name = name;
        this. store = store;
    }

    public int getxPosition() {
        return getxPosition();
    }

    public int getyPosition() {
        return getyPosition();
    }
}
