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
    private static ArrayList<String> planetNames = new ArrayList<String>();
    
    public Planet(SolarSystem parent) {
        parentSystem = parent;
        name = parentSystem.getName() + " " + (parentSystem.getNumberOfPlanets() + 1);
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
    
}
