/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.util.ArrayList;



/**
 *
 * @author John
 */
public class Ship {
    
    public ArrayList<Item> cargoHold;
    private int maxCargo;
    
    public Ship() {
        maxCargo = 10;
        cargoHold = new ArrayList(maxCargo);
        cargoHold.add(new Item("Water", 0, 0, 2, 30, 3, 4));
    }
}
