package me.charlie;

import me.charlie.Island.Island;
import java.util.ArrayList;

public class Route {

    Island islandA;
    Island islandB;
    double distance;

    public Route(Island islandA, Island islandB) {
        this.islandA = islandA;
        this.islandB = islandB;
        this.distance = islandA.getCoordinate().getDistance(islandB.getCoordinate());
    }

    public Island getIslandA() {
        return islandA;
    }

    public Island getIslandB() {
        return islandB;
    }


}
