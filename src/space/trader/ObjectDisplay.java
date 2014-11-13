/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

/**
 *
 * @author tanmay
 */
public class ObjectDisplay {
        
    /**
     * @variable item thing to be displayed
     */
    private Item item;
        
    /**
     * @variable price cost of the item
     */
    private int price;
        
    /**
     * @variable amount quantity of items
     */
    private int amount;
    
    /**
     * Constructor for class ObjectDisplay.
     * @param item the item
     * @param price the price
     * @param amount the number of the item
     */
    public ObjectDisplay(final Item item, final int price, final int amount) {
        this.item = item;
        this.price = price;
        this.amount = amount;
    }
    
    /**
     * toString method for the class ObjectDisplay.
     * @return the string version of the object
     */
    @Override
    public final String toString() {
        return getItem() + ": " + getPrice() + " credits (" + getAmount() + ")";
    }

    /**
     * @return the item
     */
    final public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    final public void setItem(final Item item) {
        this.item = item;
    }

    /**
     * @return the price
     */
    final public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    final public void setPrice(final int price) {
        this.price = price;
    }

    /**
     * @return the amount
     */
    final public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    final public void setAmount(final int amount) {
        this.amount = amount;
    }
}
