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
    private int techLevel;
    private int resources;

    public SolarSystem(String name, int xLocation, int yLocation, int techLevel, int resources) {
        this.name = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.techLevel = techLevel;
        this.resources = resources;
        
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
    
    public int getTechLevel() {
        return this.techLevel;
    }
    
    public int getResources() {
        return this.resources;
    }
}
