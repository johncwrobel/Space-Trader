/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author Johnnycakes
 */
public class Ship implements Serializable{
    
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
        return this.fuel; //returns the ship's current Fuel
    }
    
    /**
     * Returns the maximum amount of fuel the ship can hold
     * @return maxFuel
     */
    
    public int getMaxFuel(){
        return this.maxFuel; //returns the ship's maximum allowed fuel
    }
    
    /**
     * Adds fuel to the ship
     * @param amount the amount of fuel to add
     */
    
    public void addFuel(int amount){
        this.fuel += amount; //add a certain amount of fuel to the ship
    }
    
    /**
     * Whether nor not the ship has enough fuel to travel to a system
     * @param system the system to travel to
     * @return true or false
     */
    
    public boolean canTravelTo(SolarSystem system){
        xLocation = SpaceTrader.currentPlanet.getSolarSystem().getXLocation(); //updates the xLocation of the ship to use later
        yLocation = SpaceTrader.currentPlanet.getSolarSystem().getYLocation(); //updates the yLocation of the ship to use later
        
        //uses distance formula to calculate if the distance is too far
        return Math.sqrt((xLocation-system.getXLocation())*(xLocation-system.getXLocation()) + (yLocation-system.getYLocation())*(yLocation-system.getYLocation())) <= fuel;
    }
    
       /**
     * Whether nor not the ship has enough fuel to travel to a planet
     * @param planet the system to travel to
     * @return true or false
     */
    
    public boolean canTravelTo(Planet planet){
        return canTravelTo(planet.getSolarSystem()); //calls above method, but with planet instead
    }
    
    /**
     * Moves the ship from current planet to decided planet
     * Sets currentplanet
     * Sets currentsolarysystem
     * Sets X and Y locations
     * @param planet the planet to travel to
     */
    
    public void travel(Planet planet){
        //subtracts fuel based on how far we travelled
        fuel = (int) (fuel - Math.sqrt((xLocation-planet.getSolarSystem().getXLocation())*(xLocation-planet.getSolarSystem().getXLocation()) + (yLocation-planet.getSolarSystem().getYLocation())*(yLocation-planet.getSolarSystem().getYLocation())));
        SpaceTrader.currentPlanet = planet; //sets currentPlanet
        SpaceTrader.currentSolarSystem = planet.getSolarSystem(); //sets currentSolarSystem
        xLocation = SpaceTrader.currentPlanet.getSolarSystem().getXLocation(); //updates xLocation of ship
        yLocation = SpaceTrader.currentPlanet.getSolarSystem().getYLocation(); //updates yLocation of ship
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
    
    /**
     * Getter for the ship's cargo
     * @return 
     */
    public ArrayList getCargo() {
        return cargoHold;
    }
}
