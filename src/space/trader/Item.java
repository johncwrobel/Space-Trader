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
    private String name;
    private int basePrice;
    private int mtlp;
    private int mtlu;
    private int ipl;
    private int ttp;
    private int var;
    
    /**
     * Constructor for an Item
     * @param name name
     * @param mtlp the mtlp
     * @param mtlu the mtlu
     * @param ttp the ttp
     * @param basePrice the base price
     * @param ipl the ipl
     * @param var the variance
     */
    public Item(final String name, final int mtlp, final int  mtlu, final int ttp, final int basePrice, final int ipl, final int var) {
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
     * @param techLevel of the planet
     * @return the price
     */
    public final int getPrice(final int techLevel) {
        return getBasePrice() + (getIpl() * (techLevel - getMtlp())) + (getVar() * calculateVar());
    }
    
    /**
     * Helps decide the item's price
     * @return the var
     */
    private int calculateVar() {
        int toReturn;
        final int temp = (int) (Math.random() * 8);
        if (temp < 4) {
            toReturn = -1;
        } else {
            toReturn = 1;
        }
        return toReturn;
    }
    
    /**
     * Getter for MTLP
     * @return MTLP value
     */
    public final int getMLTP() {
        return getMtlp();
    }
    
    /**
     * Getter for MTLU
     * @return MTLU value
     */
    public final int getMTLU() {
        return getMtlu();
    }
    
    /**
     * Method for comparing items
     * @param o object to compare
     * @return if they are the same or not
     */
    @Override
    public final int compareTo(final Object o) {
        final Item i = (Item) o;
        return this.getName().compareTo(i.getName());
    }
    
    /**
     * Makes a string from an item
     * @return the string representation of the item
     */
    @Override
    public final String toString() {
        return getName();
    }
    
    /**
     * checks if an item is illegal
     * @return if it's illegal or not
     */
    public final boolean isIllegal() {
        boolean toReturn = false;
        if ((getName().equals("Narcotics")) | (getName().equals("Firearms"))) {
            toReturn = true;
        }
        return toReturn;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the basePrice
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * @param basePrice the basePrice to set
     */
    public void setBasePrice(final int basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * @return the mtlp
     */
    public int getMtlp() {
        return mtlp;
    }

    /**
     * @param mtlp the mtlp to set
     */
    public void setMtlp(final int mtlp) {
        this.mtlp = mtlp;
    }

    /**
     * @return the mtlu
     */
    public int getMtlu() {
        return mtlu;
    }

    /**
     * @param mtlu the mtlu to set
     */
    public void setMtlu(final int mtlu) {
        this.mtlu = mtlu;
    }

    /**
     * @return the ipl
     */
    public int getIpl() {
        return ipl;
    }

    /**
     * @param ipl the ipl to set
     */
    public void setIpl(final int ipl) {
        this.ipl = ipl;
    }

    /**
     * @return the ttp
     */
    public int getTtp() {
        return ttp;
    }

    /**
     * @param ttp the ttp to set
     */
    public void setTtp(final int ttp) {
        this.ttp = ttp;
    }

    /**
     * @return the var
     */
    public int getVar() {
        return var;
    }

    /**
     * @param var the var to set
     */
    public void setVar(final int var) {
        this.var = var;
    }
}
