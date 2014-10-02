/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.util.ArrayList;
import javax.swing.JOptionPane;



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
    
    public boolean removeItem(String name) {
        for (int i = 0; i < cargoHold.size(); i++) {
            String compareString = cargoHold.get(i).name + ":";
            if (compareString.equals(name)) {
                cargoHold.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public void addItem(String itemName) {
        ArrayList<Item> itemList = SpaceTrader.currentPlanet.marketplace.items;
        for (int i = 0; i < itemList.size(); i++) {
            String compareString = itemList.get(i).name + ":";
            if (compareString.equals(itemName)) {
                cargoHold.add(itemList.get(i));
                System.out.println("Item Added");
                break;
            }
        }
        //cargoHold.add(itemList.get(index))
    }
    public boolean canAdd() {
        if (cargoHold.size() < maxCargo) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Not enough storage in the ship", "Alert" , JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
