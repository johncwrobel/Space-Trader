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
    private Item item;
    private int price;
    private int amount;
    
    /**
     * Constructor for class ObjectDisplay
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
     * toString method for the class ObjectDisplay
     * @return the string version of the object
     */
    @Override
    public final String toString() {
        return item + ": " + price + " credits (" + amount + ")";
    }
}
