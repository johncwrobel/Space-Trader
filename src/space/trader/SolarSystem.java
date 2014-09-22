package space.trader;
import java.util.*;

/**
 *
 * @author Benjamin Cervantes
 */
public class SolarSystem {

    private String name;
    private int xLocation;
    private int yLocation;
    private int numberOfPlanets;

    public SolarSystem(String name, int xLocation, int yLocation, int numberOfPlanets) {
        this.name = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.numberOfPlanets = numberOfPlanets;
        
    }
    
    public SolarSystem() {
        
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

    public void setName(String name) {
        this.name = name;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }
    
    public int getNumberOfPlanets() {
        return this.numberOfPlanets;
    }
    
    public void setNumberOfPlanets(int numberOfPlanets) {
        this.numberOfPlanets = numberOfPlanets;
    }
    
    public static void main(String args[]) {
        ArrayList al = new ArrayList();
        al.add("Solar System 1");
        al.add("Solar System 2");
        al.add("Solar System 3");
        al.add("Solar System 4");
        al.add("Solar System 5");
    }

}
