package me.charlie.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IslandNameHandler {

    private Random random = new Random();

    private List<String> names = new ArrayList<>();

    /**
     * Creates an instance of IslandNameHandler and adds names to a list.
     */
    public IslandNameHandler() {
        this.names.add("Turkmenistan");
        this.names.add("Kyrgyzstan");
        this.names.add("Kazakhstan");
        this.names.add("Tajikistan");
        this.names.add("Pakistan");
        this.names.add("Uzbekistan");
        this.names.add("Jerry");
        this.names.add("Jerry2 Electric Boogaloo");
    }

    /**
     * Gets a random name from the list and then removes it from the list.
     * 
     * @return a random name from the list.
     */
    public String getName() {
        String name = this.names.get(this.random.nextInt(this.names.size() - 1));
        this.names.remove(name);
        return name;
    }
}
