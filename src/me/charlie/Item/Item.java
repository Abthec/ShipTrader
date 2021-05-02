package me.charlie.Item;

public class Item {

    ItemType itemType;
    int size;
    String description;

    public Item(ItemType itemType) {
        this.itemType = itemType;
        this.size = itemType.getSize();
        this.description = itemType.getDescription();
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
