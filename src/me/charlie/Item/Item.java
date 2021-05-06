package me.charlie.Item;

import me.charlie.Store.StoreType;

import java.util.Random;

public class Item {

    ItemType itemType;
    int size;
    int baseCost;
    int buyCost;
    int sellCost;
    String description;

    private Random random = new Random();

    public Item(StoreType storeType) {
        this.itemType = ItemType.values()[random.nextInt(4)];
        this.size = itemType.getSize();
        this.description = itemType.getDescription();
        this.baseCost = itemType.getLowerCostBound(itemType) + random.nextInt(itemType.getUpperCostBound(itemType) - itemType.getLowerCostBound(itemType) + 1);
        this.buyCost = (int)Math.round(baseCost * storeType.getBuyModifier(itemType));
        this.sellCost = (int)Math.round(baseCost * storeType.getSellModifier(itemType));
    }

    public int getBaseCost() {
        return baseCost;
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSellCost() {
        return sellCost;
    }

    public int getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String toString() {
        return this.getItemType().getName() + " | ";
    }
}