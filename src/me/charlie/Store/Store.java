package me.charlie.Store;

import me.charlie.Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {

    StoreType storeType;
    int maxStock;
    double storeBuyModifier;
    String name;
    private StoreNameHandler storeNames = new StoreNameHandler();

    private List<Item> stock = new ArrayList<Item>();

    private Random random = new Random();

    public Store() {
        this.name = storeNames.getName();
        this.storeType = StoreType.values()[random.nextInt(4)];
        this.maxStock = this.storeType.getMinStockBound() + random.nextInt(this.storeType.getMaxStockBound() - this.storeType.getMinStockBound() + 1);
        for (int i = 0; i < this.maxStock;  i++) {
            stock.add(new Item(storeType));
        }
    }

    public double getStoreBuyModifier(Item item) {
        storeBuyModifier = this.getStoreType().getBuyModifier(item.getItemType());
        return storeBuyModifier;
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
        return this.getName() + " | " + this.getStoreType().getName();
    }
}