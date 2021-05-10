package me.charlie.Island;

public class Location {

    int xCoordinate;
    int yCoordinate;

    public Location(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Location() {
        this(50, 50);
    }

    public double getDistance(Location location) {
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