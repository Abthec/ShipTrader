package me.charlie.Item;

import java.util.Random;

import me.charlie.Island.Island;
import me.charlie.Store.Store;
import me.charlie.Store.StoreType;

/**
 * Stores information about items.
 * 
 * @author charlie.
 *
 */
public class Item {

	ItemType itemType;
	UpgradeType upgradeType;
	int size;
	int baseCost;
	int buyCost;
	int sellCost;
	int purchasedPrice;
	int soldPrice;
	boolean usedAsUpgrade;
	boolean wasStolen;
	Island placeOfPurchase;
	Island placeOfSale;
	String description;

	private Random random = new Random();

	/**
	 * Creates an Item
	 * 
	 * @param storeType the type of store the item is being created in.
	 */
	public Item(StoreType storeType) {
		this.itemType = ItemType.values()[random.nextInt(4)];
		this.size = itemType.getSize();
		this.description = itemType.getDescription();
		this.baseCost = itemType.getLowerCostBound(itemType)
				+ random.nextInt(itemType.getUpperCostBound(itemType) - itemType.getLowerCostBound(itemType) + 1);
		this.buyCost = (int) Math.round(baseCost * storeType.getBuyModifier(itemType));
		this.placeOfPurchase = null;
		this.placeOfSale = null;
		this.purchasedPrice = 0;
		this.soldPrice = 0;
		this.usedAsUpgrade = false;
		if (itemType.equals(ItemType.UPGRADE)) {
			this.upgradeType = UpgradeType.values()[random.nextInt(4)];
		} else {
			this.upgradeType = null;
		}
	}

	/**
	 * Sets the Item as stolen.
	 */
	public void setAsStolen() {
		this.wasStolen = true;
	}

	/**
	 * Sets the boolean usedAsUpgrade to true.
	 */
	public void setUsedAsUpgrade() {
		this.usedAsUpgrade = true;
	}

	/**
	 * 
	 * @return if the Item was used as an Upgrade or not.
	 */
	public boolean usedAsUpgrade() {
		return usedAsUpgrade;
	}

	/**
	 * Assigns the value to where the item was sold.
	 * 
	 * @param island the place the Item was sold.
	 */
	public void setPlaceOfSale(Island island) {
		placeOfSale = island;
	}

	/**
	 * 
	 * @return the Island where the item was sold.
	 */
	public Island getPlaceOfSale() {
		return placeOfSale;
	}

	/**
	 * Assigns the price that the Item was sold for.
	 * 
	 * @param price the price the Item was sold for.
	 */
	public void setSoldPrice(int price) {
		soldPrice = price;
	}

	/**
	 * 
	 * @return the price the Item was sold for.
	 */
	public int getSoldPrice() {
		return soldPrice;
	}

	/**
	 * Assign the Island the Item was purchased on.
	 * 
	 * @param island where the Item was purchased.
	 */
	public void setPlaceOfPurchase(Island island) {
		this.placeOfPurchase = island;
	}

	/**
	 * 
	 * @return the place the Item was purchased.
	 */
	public Island getPlaceOfPurchase() {
		return placeOfPurchase;
	}

	/**
	 * Assigns the value the Item was purchased for.
	 * 
	 * @param purchasedPrice the price the Item was purchased for.
	 */
	public void setPurchasedPrice(int purchasedPrice) {
		this.purchasedPrice = purchasedPrice;
	}

	/**
	 * 
	 * @return the price the Item was purchased for.
	 */
	public int getPurchasedPrice() {
		return purchasedPrice;
	}

	/**
	 * 
	 * @return the Item's cost before buy or sell modifiers are applied.
	 */
	public int getBaseCost() {
		return baseCost;
	}

	/**
	 * 
	 * @return the Item's cost after a buy modifier has been applied.
	 */
	public int getBuyCost() {
		return buyCost;
	}

	/**
	 * Calculates the Item's sell cost given a specific Store.
	 * 
	 * @param store the Store the Item is being sold at.
	 * @return the cost of the Item based off the Store it's being sold at.
	 */
	public int getSellCost(Store store) {
		sellCost = (int) Math.round(this.getBaseCost() * store.getStoreSellModifier(this));
		return sellCost;
	}

	/**
	 * 
	 * @return how much cargo space the Item takes up.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 
	 * @return the Item's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return the Item's ItemType.
	 */
	public ItemType getItemType() {
		return itemType;
	}

	/**
	 * 
	 * @return the Item's UpgradeType.
	 */
	public UpgradeType getUpgradeType() {
		return upgradeType;
	}

	/**
	 * Converts an Item object to a String.
	 */
	public String toString() {
		return this.getItemType().getName() + " | ";
	}
}