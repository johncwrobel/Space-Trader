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
    private int fuel;
    private int maxFuel;
    private int xLocation;
    private int yLocation;
    
    /**
     * Constructor for the Ship
     */
    public Ship() {
        maxCargo = 10;
        cargoHold = new ArrayList(maxCargo);
        cargoHold.add(new Item("Water", 0, 0, 2, 30, 3, 4));
        fuel = 10;
        maxFuel = 20;
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
     * Returns the current fuel for the ship
     * @return Fuel
     */
    
    public int getFuel(){
        return this.fuel;
    }
    
    /**
     * Returns the maximum amount of fuel the ship can hold
     * @return maxFuel
     */
    
    public int getMaxFuel(){
        return this.maxFuel;
    }
    
    /**
     * Adds fuel to the ship
     * @param amount the amount of fuel to add
     */
    
    public void addFuel(int amount){
        this.fuel += amount;
    }
    
    /**
     * Whether nor not the ship has enough fuel to travel to a system
     * @param system the system to travel to
     * @return true or false
     */
    
    public boolean canTravelTo(SolarSystem system){
        xLocation = SpaceTrader.currentPlanet.getSolarSystem().getXLocation();
        yLocation = SpaceTrader.currentPlanet.getSolarSystem().getYLocation();
        
        //uses distance formula to calculate if the distance is too far
        return Math.sqrt((xLocation-system.getXLocation())*(xLocation-system.getXLocation()) + (yLocation-system.getYLocation())*(yLocation-system.getYLocation())) <= fuel;
    }
    
       /**
     * Whether nor not the ship has enough fuel to travel to a planet
     * @param planet the system to travel to
     * @return true or false
     */
    
    public boolean canTravelTo(Planet planet){
        return canTravelTo(planet.getSolarSystem());
    }
    
    /**
     * Moves the ship from current planet to decided planet
     * Sets currentplanet
     * Sets currentsolarysystem
     * Sets X and Y locations
     * @param planet the planet to travel to
     */
    
    public void travel(Planet planet){
        fuel = (int) (fuel - Math.sqrt((xLocation-planet.getSolarSystem().getXLocation())*(xLocation-planet.getSolarSystem().getXLocation()) + (yLocation-planet.getSolarSystem().getYLocation())*(yLocation-planet.getSolarSystem().getYLocation())));
        SpaceTrader.currentPlanet = planet;
        SpaceTrader.currentSolarSystem = planet.getSolarSystem();
        xLocation = SpaceTrader.currentPlanet.getSolarSystem().getXLocation();
        yLocation = SpaceTrader.currentPlanet.getSolarSystem().getYLocation();
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
