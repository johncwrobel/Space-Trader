/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.io.Serializable;

/**
 *
 * @author tanmay (Seantannah)
 */
public class Item implements Comparable, Serializable{
    public final String name;
    private final int basePrice;
    private final int mtlp;
    private final int mtlu;
    private final int ipl;
    private final int ttp;
    private final int var;
    
    /**
     * Constructor for an Item
     * @param name
     * @param mtlp
     * @param mtlu
     * @param ttp
     * @param basePrice
     * @param ipl
     * @param var 
     */
    public Item(String name, int mtlp, int  mtlu, int ttp, int basePrice, int ipl, int var) {
        this.name = name;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.var = var;
        this.basePrice = basePrice;
        this.ipl = ipl;
    }
    
    /**
     * Calculates the price of an item
     * @param techLevel
     * @return the price
     */
    public final int getPrice(int techLevel) {
        return basePrice + (ipl * (techLevel - mtlp)) + (var * var());
    }
    
    /**
     * Helps decide the item's price
     * @return 
     */
    private int var() {
        int temp = (int) (Math.random() * 8);
        if (temp < 4) {
            return -1;
        } else {
            return 1;
        }
    }
    
    /**
     * Getter for MTLP
     * @return MTLP value
     */
    public final int getMLTP() {
        return mtlp;
    }
    
    /**
     * Getter for MTLU
     * @return MTLU value
     */
    public final int getMTLU() {
        return mtlu;
    }
    
    /**
     * Method for comparing items
     * @param o
     * @return if they are the same or not
     */
    @Override
    public final int compareTo(Object o) {
        Item i = (Item) o;
        return this.name.compareTo(i.name);
    }
    
    /**
     * Makes a string from an item
     * @return the string representation of the item
     */
    @Override
    public final String toString() {
        return name;
    }
    
    public final boolean isIllegal() {
        if ((name == "Narcotics") | (name == "Firearms")) {
            return true;
        }
        return false;
    }
}
