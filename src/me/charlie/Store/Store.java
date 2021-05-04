package me.charlie.Store;

import java.util.Random;

public class Store {

    StoreType storeType;
    int stock;
    String name;
    private StoreNameHandler storeNames = new StoreNameHandler();

    private Random random = new Random();

    public Store() {
        this.name = storeNames.getName();
        this.storeType = StoreType.values()[random.nextInt(5)];
        switch (this.storeType) {
            case BLACKSMITH:
                this.stock = 30 + random.nextInt(21);
            case SHIP_BUILDER:
                this.stock = 20 + random.nextInt(21);
            case JEWELER:
                this.stock = 40 + random.nextInt(21);
            case ARTIFICER:
                this.stock = 15 + random.nextInt(26);
        }
    }

    public int getInventorySize() {
        return stock;
    }

    public StoreType getStoreType() {
        return storeType;
    }
}