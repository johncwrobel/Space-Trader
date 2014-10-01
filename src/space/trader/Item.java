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
public class Item implements Comparable{
    public final String name;
    private final int basePrice;
    private final int mtlp;
    private final int mtlu;
    private final int ipl;
    private final int ttp;
    private final int var;
    
    public Item(String name, int mtlp, int  mtlu, int ttp, int basePrice, int ipl, int var) {
        this.name = name;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.var = var;
        this.basePrice = basePrice;
        this.ipl = ipl;
    }
    
    public int getPrice(int techLevel) {
        return basePrice + (ipl * (techLevel - mtlp)) + (var * var());
    }
    
    private int var() {
        int temp = (int) (Math.random() * 8);
        if (temp < 4) {
            return -1;
        } else {
            return 1;
        }
    }
    
    public int getMLTP() {
        return mtlp;
    }
    
    public int getMTLU() {
        return mtlu;
    }

    @Override
    public int compareTo(Object o) {
        Item i = (Item) o;
        return this.name.compareTo(i.name);
    }
    
    
}
