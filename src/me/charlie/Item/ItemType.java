package me.charlie.Item;

public enum ItemType {

    UPGRADE,
    WEAPON,
    JEWEL,
    ARTIFACT;

	/**
	 * 
	 * @return the size of the Item depending on ItemType.
	 */
    public int getSize() {
        switch (this) {
            case JEWEL:
                return 1;
            case WEAPON:
                return 2;
            case UPGRADE:
                return 3;
            case ARTIFACT:
                return 4;
            default:
                return 5;
        }
    }

    /**
     * 
     * @param itemType the ItemType of a given item.
     * @return the maximum amount of coins an Item of specific ItemType can cost.
     */
   public int getUpperCostBound(ItemType itemType) {
       switch (itemType) {
           case ARTIFACT:
               return 800;
           case WEAPON:
               return 90;
           case JEWEL:
               return 350;
           case UPGRADE:
               return 200;
           default:
               return 0;
       }
   }

   /**
    * 
    * @param itemType the ItemType of a given item.
    * @return the minimum amount of coins an Item of specific ItemType can cost.
    */
   public int getLowerCostBound(ItemType itemType) {
       switch (itemType) {
           case ARTIFACT:
               return 750;
           case WEAPON:
               return 75;
           case JEWEL:
               return 300;
           case UPGRADE:
               return 175;
           default:
               return 0;
       }
   }

   /**
    * 
    * @return a description of the item.
    */
    public String getDescription() {
        switch (this) {
            default:
                return "This is a " + getName();
        }
    }

    /**
     * 
     * @return the ItemType as a formatted String.
     */
    public String getName() {
        return toString().substring(0, 1).toUpperCase() + toString().substring(1).toLowerCase().replace("_", " ");
    }
}
