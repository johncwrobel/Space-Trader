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
public class Item {
    private final String name;
    private final int mtlp;
    private final int mtlu;
    private final int ttp;
    private final int var;
    private final int mtl;
    private final int mth;
    
    public Item(String name, int mtlp, int  mtlu, int ttp, int var, int mtl, int mth) {
        this.name = name;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.var = var;
        this.mtl = mtl;
        this.mth = mth;
    }
    
    
    
}
