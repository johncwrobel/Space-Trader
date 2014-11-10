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
     * @param item
     * @param price
     * @param amount 
     */
    public ObjectDisplay(Item item, int price, int amount) {
        this.item = item;
        this.price = price;
        this.amount = amount;
    }
    
    /**
     * toString method for the class ObjectDisplay
     * @return 
     */
    @Override
    public final String toString() {
        return item + ": " + price + " credits (" + amount + ")";
    }
}
