package space.trader;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Benjamin Cervantes
 */
public class Planet {
    private String name;
    private int xLocation;
    private int yLocation;
    private int techLevel;
    private int resources;
    private static ArrayList<String> planetNames = new ArrayList<String>();
    
    static {
    planetNames.add("planetName1");
    planetNames.add("planetName2");
    planetNames.add("planetName3");
    planetNames.add("planetName4");
    planetNames.add("planetName5");
    
    }
    
    public Planet() {
        Random r1 = new Random();
        int random = r1.nextInt(planetNames.size());
        name = planetNames.get(random);
        planetNames.remove(random);
        xLocation = (int)(Math.random() * 100) + 1;
        yLocation = (int)(Math.random() * 100) + 1;
        techLevel = (int)(Math.random() * 8);
        resources = (int)(Math.random() * 13);
        
    }

    public String getName() {
        return name;
    }


    public int getxLocation() {
        return xLocation;
    }


    public int getyLocation() {
        return yLocation;
    }


    public int getTechLevel() {
        return techLevel;
    }


    public int getResources() {
        return resources;
    }
    
}
