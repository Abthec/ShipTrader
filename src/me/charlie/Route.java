package me.charlie;

import me.charlie.Island.Island;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Route {

    Island currentIsland;
    ArrayList islands;

    public Route(Island currentIsland, ArrayList islands) {
        this.currentIsland = currentIsland;
        this.islands = islands;
    }


}
