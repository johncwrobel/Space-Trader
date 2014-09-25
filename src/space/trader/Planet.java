package space.trader;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Benjamin Cervantes and John Wrobel
 */
public class Planet {
    private String name;
    private int techLevel;
    private int resources;
    private SolarSystem parentSystem;
    
    /**
     * Constructor for Planet class
     * @param parent
     * @param name 
     */
    public Planet(SolarSystem parent, String name) {
        parentSystem = parent;
        this.name = name;
        techLevel = (int)(Math.random() * 8);
        resources = (int)(Math.random() * 13);
        
    }
    
    /**
     * Getter method for getName
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for Tech Level
     * @return techLevel
     */
    public int getTechLevel() {
        return techLevel;
    }

    /**
     * Getter method for Resources
     * @return resources
     */
    public int getResources() {
        return resources;
    }
    
    @Override
    public String toString() {
        // (Planet name: name, Tech Level: x, Resource Type: x)
        return ("(Planet name: " + name + ", Tech Level: " + techLevel + ", Resource Type: " + resources + ")"); 
    }
}
