package space.trader;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Benjamin Cervantes
 */
<<<<<<< HEAD
public class Universe implements Serializable{
                
    /**
     * @variable serialVersionUID no idea what this thing does
     */
    private static final long serialVersionUID = 42L;
                    
    /**
     * @variable numberOfSS how many solar systems you want
     */
=======
public class Universe implements Serializable {
    private static final long serialVersionUID = 42L;

>>>>>>> origin/master
    private int numberOfSS;
                    
    /**
     * @variable solarSystems backing array for the solar systems
     */
    private ArrayList<SolarSystem> solarSystems = new ArrayList<SolarSystem>();
                    
    /**
     * @variable booleanArray the array that decides system positions
     */
    private boolean[][] booleanArray;
                    
    /**
     * @variable homeSolarSystem starting position
     */
    private SolarSystem homeSolarSystem;
                    
    /**
     * @variable homePlanet starting position
     */
    private Planet homePlanet;

    /**
     * Constructor for Universe class.
     */
    public Universe() {
        booleanArray = new boolean[20][20];
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                booleanArray[x][y] = false;
            }
        }
        numberOfSS = (int) (Math.random() * 50) + 50;
        for (int i = 0; i < numberOfSS; i++) {
            int x = (int) (Math.random() * 20);
            int y = (int) (Math.random() * 20);
            while (true) {
                if (booleanArray[x][y]) {
                    x = (int) (Math.random() * 20);
                    y = (int) (Math.random() * 20);
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
     * toString method for the class.
     * @return toString
     */
    @Override
    public final String toString() {
        StringBuffer returnString = new StringBuffer(60);
        for (SolarSystem ss : getSolarSystems()) {
            String toConcatenate = (ss.toString() + "\n");
            returnString.append(toConcatenate);
        }
        returnString.append("\nNumber of Solar Systems in Universe:"
                + getNumberOfSolarSystems() + "\n");
        return returnString.toString();
    }

    /**
     * Getter method for the solar system.
     * @param x x coordinate
     * @param y y coordinate
     * @return the solar system at the coordinates
     */
    public final SolarSystem getSystem(final int x, final int y) {
        SolarSystem toReturn = null;
        for (SolarSystem s : getSolarSystems()) {
            final int systemX = s.getXLocation();
            final int systemY = s.getYLocation();

            if (x == systemX && y == systemY) {
                toReturn = s;
            }
        }
        return toReturn;
    }

    /**
     * @return the numberOfSolarSystems
     */
    final public int getNumberOfSolarSystems() {
        return numberOfSS;
    }

    /**
     * @param numberOfSS the numberOfSolarSystems to set
     */
    final public void setNumberOfSolarSystems(final int numberOfSS) {
        this.numberOfSS = numberOfSS;
    }

    /**
     * @return the solarSystems
     */
    final public ArrayList<SolarSystem> getSolarSystems() {
        return solarSystems;
    }

    /**
     * @param solarSystems the solarSystems to set
     */
    final public void setSolarSystems(final ArrayList<SolarSystem> solarSystems)
    {
        this.solarSystems = solarSystems;
    }

    /**
     * @return the booleanArray
     */
    final public boolean[][] getBooleanArray() {
        return booleanArray;
    }

    /**
     * @param booleanArray the booleanArray to set
     */
    final public void setBooleanArray(final boolean[][] booleanArray) {
        final boolean[][] copy = booleanArray;
        this.booleanArray = copy;
    }

    /**
     * @return the homeSolarSystem
     */
    final public SolarSystem getHomeSolarSystem() {
        return homeSolarSystem;
    }

    /**
     * @param homeSolarSystem the homeSolarSystem to set
     */
    final public void setHomeSolarSystem(final SolarSystem homeSolarSystem) {
        this.homeSolarSystem = homeSolarSystem;
    }

    /**
     * @return the homePlanet
     */
    final public Planet getHomePlanet() {
        return homePlanet;
    }

    /**
     * @param homePlanet the homePlanet to set
     */
    final public void setHomePlanet(final Planet homePlanet) {
        this.homePlanet = homePlanet;
    }

}

