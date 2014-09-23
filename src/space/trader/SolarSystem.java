package space.trader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin Cervantes
 */
public class SolarSystem {

    private String name;
    private int xLocation;
    private int yLocation;
    private int numberOfPlanets;
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private static ArrayList<String> systemNames = new ArrayList<String>();
   
    static {
        try(BufferedReader br = new BufferedReader(new FileReader("ass.dat"))) {
            String line = br.readLine();

            while (line != null) {
                systemNames.add(line);
                line = br.readLine();
            }
            
            
        }   catch (Exception ex) {
            Logger.getLogger(SolarSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    // toString format:    name(x,y): planet1 planet2 planet3
    public String toString() {
        String returnVal = "";
        returnVal += name + "(" + xLocation + ","+"):";
        for (int i = 0; i < numberOfPlanets; i++) {
            returnVal += " " + planets.get(i);
        }
        return returnVal;
    }
    
    public SolarSystem(int x, int y) {
        Random r1 = new Random();
        int random = r1.nextInt(systemNames.size());
        name = systemNames.get(random);
        systemNames.remove(random);
        xLocation = x;
        yLocation = y;
        numberOfPlanets = (int)(Math.random() * 3) + 1;
        for (int i = 0; i < numberOfPlanets; i++) {
            planets.add(new Planet(this, this.name+" "+i));
        }
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