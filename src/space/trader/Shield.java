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
    
    private String name;
    private int shieldLevel;
    private int techLevel;
    private int price;
    /**
     * Constructor for the Shield.
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

    /**
     * @return the name
     */
    final public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    final public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the shieldLevel
     */
    final public int getShieldLevel() {
        return shieldLevel;
    }

    /**
     * @param shieldLevel the shieldLevel to set
     */
    final public void setShieldLevel(final int shieldLevel) {
        this.shieldLevel = shieldLevel;
    }

    /**
     * @return the techLevel
     */
    final public int getTechLevel() {
        return techLevel;
    }

    /**
     * @param techLevel the techLevel to set
     */
    final public void setTechLevel(final int techLevel) {
        this.techLevel = techLevel;
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
}
