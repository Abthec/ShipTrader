package me.charlie.Store;

import me.charlie.Item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {

    private StoreType storeType;
    private int maxStock;
    private double storeBuyModifier;
    private double storeSellModifier;
    private String name;
    private StoreNameHandler storeNames = new StoreNameHandler();
    private List<Item> stock = new ArrayList<Item>();
    private Random random = new Random();

    /**
     * Creates an instance of Store.
     * Initializes the stores name, storeType, maxStock and the items in the stock.
     */
    public Store() {
        this.name = storeNames.getName();
        this.storeType = StoreType.values()[random.nextInt(4)];
        this.maxStock = this.storeType.getMinStockBound() + random.nextInt(this.storeType.getMaxStockBound() - this.storeType.getMinStockBound() + 1);
        for (int i = 0; i < this.maxStock;  i++) {
            stock.add(new Item(storeType));
        }
    }

    /**
     * removes a specified item from the list and prints a string saying it was purchased.
     * 
     * @param item an item selected for purchase by the player.
     */
    public void buyItem(Item item) {
        stock.remove(item);
        System.out.println(item.getItemType().getName() + " was purchased for " + item.getBuyCost() + " coins.");
    }

    /**
     * gets the purchasing coefficient for a specified item depending on the storeType and itemType.
     * 
     * @param item an item selected by the player for purchasing.
     * @return the coefficient of purchasing.
     */
    public double getStoreBuyModifier(Item item) {
        storeBuyModifier = this.getStoreType().getBuyModifier(item.getItemType());
        return storeBuyModifier;
    }

    /**
     * gets the selling coefficient for a specified item depending on storeType and itemType.
     * 
     * @param item an item selected by the player for purchasing.
     * @return the selling coefficient.
     */
    public double getStoreSellModifier(Item item) {
        storeSellModifier = this.getStoreType().getSellModifier(item.getItemType());
        return storeSellModifier;
    }

    /**
     * 
     * @return the maximum amount of items a store can stock.
     */
    public int getMaxStock() {
        return maxStock;
    }

    /**
     * 
     * @return the store's StoreType.
     */
    public StoreType getStoreType() {
        return storeType;
    }

    /**
     * 
     * @return the name of the store.
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return return a list of all the items in the shops stock.
     */
    public List<Item> getStock() {
        return stock;
    }
    
    /**
     * fill in the missing item slots in the stock with new items.
     */
    public void reStock() {
    	int itemsMissing = this.getMaxStock() - this.getStock().size();
    	for (int i=0; i < itemsMissing; i++) {
    		stock.add(new Item(storeType));
    	}
    }

    /**
     * convert the Store object to a String.
     */
    public String toString() {
        return this.getName() + " | " + this.getStoreType().getName();
    }
}