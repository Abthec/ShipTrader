package me.charlie.Store;

import me.charlie.Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {

    StoreType storeType;
    int maxStock;
    String name;
    private StoreNameHandler storeNames = new StoreNameHandler();

    private List<Item> stock = new ArrayList<Item>();

    private Random random = new Random();

    public Store() {
        this.name = storeNames.getName();
        this.storeType = StoreType.values()[random.nextInt(4)];
        switch (this.storeType) {
            case BLACKSMITH:
                this.maxStock = 30 + random.nextInt(21);
            case SHIP_BUILDER:
                this.maxStock = 20 + random.nextInt(21);
            case JEWELER:
                this.maxStock = 40 + random.nextInt(21);
            case ARTIFICER:
                this.maxStock = 15 + random.nextInt(26);
        }
        for (int i = 0; i < this.maxStock;  i++) {
            stock.add(new Item());
        }
    }

    public int getMaxStock() {
        return maxStock;
    }

    public StoreType getStoreType() {
        return storeType;
    }

    public String getName() {
        return name;
    }

    public List<Item> getStock() {
        return stock;
    }

    public String toString() {
        return this.getName() + " | " + this.getStoreType().getName() + " | " + this.getStock();
    }
}