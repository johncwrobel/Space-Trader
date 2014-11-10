/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

/**
 *
 * @author Tommy Lee
 */

public class Shield {
    
    public String name;
    public int shieldLevel;
    public int techLevel;
    public int price;
    /**
     * Constructor for the Shield
     * @param name shield name
     * @param shieldLevel level for the shield
     * @param techLevel of the current planet
     * @param price price of the item
     */
    public Shield(final String name, final int shieldLevel, final int techLevel, final int price) {
        this.name = name;
        this.shieldLevel = shieldLevel;
        this.techLevel = techLevel;
        this.price = price;
    }
}
