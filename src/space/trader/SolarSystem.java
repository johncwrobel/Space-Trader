/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

/**
 *
 * @author Benjamin Cervantes
 */
public class SolarSystem {

    private String name;
    private int xLocation;
    private int yLocation;

    public SolarSystem(String name, int xLocation, int yLocation) {
        this.name = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        
    }

    public String getName() {
        return this.name;
    }
    
    public int getXLocation() {
        return this.xLocation;
    }
    
    public int getYLocation() {
        return this.yLocation;
    }
}
