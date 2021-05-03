package me.charlie.Item;

import java.util.Random;

public class Item {

    ItemType itemType;
    int size;
    int cost;
    String description;

    Random random = new Random();

    public Item(ItemType itemType) {
        this.itemType = itemType;
        this.size = itemType.getSize();
        this.description = itemType.getDescription();
        switch (this.itemType) {
            case ARTIFACT:
                this.cost = 750 + random.nextInt(50);
            case WEAPON:
                this.cost = 75 + random.nextInt(15);
            case JEWEL:
                this.cost = 300 + random.nextInt(50);
            case UPGRADE:
                this.cost = 175 + random.nextInt(25);
        }
    }

    public int getCost() {
        return cost;
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
}
