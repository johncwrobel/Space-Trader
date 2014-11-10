package space.trader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Benjamin Cervantes and John Wrobel
 */
public class Planet implements Serializable{
    private String name;
    private int techLevel;
    private int resources;
    private SolarSystem parentSystem;
    public MarketPlace marketplace;
    
    /**
     * Constructor for Planet class
     * @param parent
     * @param name 
     */
    public Planet(final SolarSystem parent, final String name) {
        parentSystem = parent;
        this.name = name;
        techLevel = (int)(Math.random() * 8);
        resources = (int)(Math.random() * 13);
        marketplace = new MarketPlace(techLevel);
    }
    
    /**
     * Getter method for getName
     * @return name
     */
    public final String getName() {
        return name;
    }

    /**
     * Getter method for ParentSystem
     * @return parentSystem
     */
    public final SolarSystem getSolarSystem(){
        return this.parentSystem;
    }
    
    /**
     * Getter method for Tech Level
     * @return techLevel
     */
    public final int getTechLevel() {
        return techLevel;
    }

    /**
     * Getter method for Resources
     * @return resources
     */
    public final int getResources() {
        return resources;
    }
    
    /**
     * toString method for the class Planet
     * @return string representation of the planet
     */
    @Override
    public final String toString() {
        // (Planet name: name, Tech Level: x, Resource Type: x)
        return ("(Planet name: " + name + ", Tech Level: " + techLevel + ", Resource Type: " + resources + ")"); 
    }
}
