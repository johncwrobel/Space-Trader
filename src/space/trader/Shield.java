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
   
    /**
     * @variable name shield's name
     */
    private String name;
        
    /**
     * @variable shieldLevel shield's level
     */
    private int shieldLevel;
        
    /**
     * @variable techLevel planet tech level
     */
    private int techLevel;
        
    /**
     * @variable price cost of the shield
     */
    private int price;
    /**
     * Constructor for the Shield.
     * @param name shield name
     * @param shieldLevel level for the shield
     * @param techLevel of the current planet
     * @param price price of the item
     */
    public Shield(final String name, final int shieldLevel, final int techLevel,
            final int price) {
        this.name = name;
        this.shieldLevel = shieldLevel;
        this.techLevel = techLevel;
        this.price = price;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the shieldLevel
     */
    public final int getShieldLevel() {
        return shieldLevel;
    }

    /**
     * @param shieldLevel the shieldLevel to set
     */
    public final void setShieldLevel(final int shieldLevel) {
        this.shieldLevel = shieldLevel;
    }

    /**
     * @return the techLevel
     */
    public final int getTechLevel() {
        return techLevel;
    }

    /**
     * @param techLevel the techLevel to set
     */
    public final void setTechLevel(final int techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * @return the price
     */
    public final int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public final void setPrice(final int price) {
        this.price = price;
    }
}
