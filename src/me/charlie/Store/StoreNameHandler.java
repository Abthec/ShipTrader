package me.charlie.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoreNameHandler {

    private Random random = new Random();

    private List<String> names = new ArrayList<String>();

    public StoreNameHandler() {
        this.names.add("Tesco Express");
        this.names.add("7-Eleven");
        this.names.add("Circle K");
        this.names.add("CBA");
        this.names.add("FamilyMart");
        this.names.add("Lawson");
        this.names.add("Ministop");
        this.names.add("Carrefour City");
        this.names.add("SPAR Express");
        this.names.add("OXXO");
        this.names.add("Four Square");
    }

    public String getName() {
        String name = this.names.get(this.random.nextInt(this.names.size() - 1));
        this.names.remove(name);
        return name;
    }
}
