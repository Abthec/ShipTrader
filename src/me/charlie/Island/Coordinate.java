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

    public double getDistance(Coordinate location) {
        int deltaX = this.getX() - location.getX();
        int deltaY = this.getY() - location.getY();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }
}