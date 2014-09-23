package space.trader;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Benjamin Cervantes
 */
public class Planet {
    private String name;
    private int techLevel;
    private int resources;
    private SolarSystem parentSystem;
    
    public Planet(SolarSystem parent, String name) {
        parentSystem = parent;
        this.name = name;
        techLevel = (int)(Math.random() * 8);
        resources = (int)(Math.random() * 13);
        
    }

    public String getName() {
        return name;
    }


    public int getTechLevel() {
        return techLevel;
    }


    public int getResources() {
        return resources;
    }
    
    
    public String toString() {
        return ("Planet name: " + name + " Tech Level: " + techLevel + " Resource Type:" + resources); 
    }
}
