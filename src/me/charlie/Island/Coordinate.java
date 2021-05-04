package me.charlie.Island;

import java.util.Random;

public class Coordinate {

    int xCoordinate;
    int yCoordinate;

    private Random random = new Random();

    public Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Coordinate() {
        this.xCoordinate = 0;
        this.yCoordinate = 0;
    }

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }
}