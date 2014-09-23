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
    private static ArrayList<String> systemNames = new ArrayList<String>();
   
    static {
    systemNames.add("name1");
    systemNames.add("name2");
    systemNames.add("name3");
    systemNames.add("name4");
    systemNames.add("name5");
    
    }
    
    
    public SolarSystem() {
        Random r1 = new Random();
        int random = r1.nextInt(systemNames.size());
        name = systemNames.get(random);
        systemNames.remove(random);
        xLocation = (int)(Math.random() * 100) + 1;
        yLocation = (int)(Math.random() * 100) + 1;
        numberOfPlanets = (int)(Math.random() * 3) + 1;
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
    
    public int getNumberOfPlanets() {
        return this.numberOfPlanets;
    }

}