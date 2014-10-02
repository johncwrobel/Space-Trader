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
 * @author Johnnycakes
 */
public class Ship {
    
    public ArrayList<Item> cargoHold;
    private int maxCargo;
    
    /**
     * Constructor for the Ship
     */
    public Ship() {
        maxCargo = 10;
        cargoHold = new ArrayList(maxCargo);
        cargoHold.add(new Item("Water", 0, 0, 2, 30, 3, 4));
    }
    
    /**
     * Removes an item from the ship's cargo hold
     * @param name
     * @return if it was removed
     */
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
    
    /**
     * Adds an item to the ship's cargo hold
     * @param itemName 
     */
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
    
    /**
     * Checks if there is space in the cargo hold or not
     * @return if there's room
     */
    public boolean canAdd() {
        if (cargoHold.size() < maxCargo) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Not enough storage in the ship", "Alert" , JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
