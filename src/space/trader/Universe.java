package space.trader;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Benjamin Cervantes
 */
public class Universe implements Serializable{
    
    private int numberOfSolarSystems;
    public ArrayList<SolarSystem> solarSystems = new ArrayList<SolarSystem>();
    private boolean[][] booleanArray;
    public final SolarSystem homeSolarSystem;
    public final Planet homePlanet;
    
    /**
     * Constructor for Universe class
     */
    public Universe() {
        booleanArray = new boolean[20][20];
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                booleanArray[x][y] = false;
            }
        }
        numberOfSolarSystems = (int)(Math.random() * 50) + 50;
        for (int i = 0; i < numberOfSolarSystems; i ++) {
            int x = (int)(Math.random() * 20);
            int y = (int)(Math.random() * 20);
            while (true) {
                if (booleanArray[x][y] == true) {
                    x = (int)(Math.random() * 20);
                    y = (int)(Math.random() * 20);
                } else {
                    break;
                }
            }
            solarSystems.add(new SolarSystem(x, y));
            booleanArray[x][y] = true;
        }
        
        homeSolarSystem = solarSystems.get(0);
        homePlanet = homeSolarSystem.getPlanet(0);
    }
    
    /**
     * toString method for the class
     * @return toString
     */
    @Override
    public final String toString() {
        String returnString = "";
        for (SolarSystem ss: solarSystems) {
            returnString = returnString + ss.toString() + "\n";
        }
        returnString += "\nNumber of Solar Systems in Universe:" + numberOfSolarSystems + "\n";
        return returnString;
    }
    
    public final SolarSystem getSystem(int x, int y) {
        for (SolarSystem s: solarSystems) {
            int systemX = s.getXLocation();
            int systemY = s.getYLocation();
            
            if (x == systemX && y == systemY) {
                return s;
            }
        }
        
        return null;
    }
        
}

