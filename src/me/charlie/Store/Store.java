package me.charlie.Store;

import java.util.Random;

public class Store {

    StoreType storeType;
    int inventorySize;

    private Random random = new Random();

    public Store(StoreType storeType) {
        this.storeType = storeType;
        switch (this.storeType) {
            case BLACKSMITH:
                this.inventorySize = 30 + random.nextInt(21);
            case SHIP_BUILDER:
                this.inventorySize = 20 + random.nextInt(21);
            case JEWELER:
                this.inventorySize = 40 + random.nextInt(21);
            case ARTIFICER:
                this.inventorySize = 15 + random.nextInt(26);
        }
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public StoreType getStoreType() {
        return storeType;
    }
}