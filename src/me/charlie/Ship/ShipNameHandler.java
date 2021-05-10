package me.charlie.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShipNameHandler {

    private List<String> shipNames = new ArrayList<>();
    private Random random = new Random();

    public ShipNameHandler() {
        this.shipNames.add("Costa Concordia");
        this.shipNames.add("Britannic II");
        this.shipNames.add("Titanic");
        this.shipNames.add("Sun Vista");
        this.shipNames.add("Sun Venture");
        this.shipNames.add("Achille Lauro");
        this.shipNames.add("SeaBreeze");
        this.shipNames.add("Constitution");
        this.shipNames.add("Britanis");
        this.shipNames.add("Ocean Princess");
        this.shipNames.add("Diamond Princess");
    }

    public String getName() {
        String name = this.shipNames.get(this.random.nextInt(this.shipNames.size() - 1));
        this.shipNames.remove(name);
        return name;
    }
}
