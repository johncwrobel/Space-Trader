package space.trader;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Benjamin Cervantes
 */
public class Universe implements Serializable {

    /**
     * offset.
     */
    private final int offset = 50;
    /**
     * offset2.
     */
    private final int offset2 = 60;
    /**
     * @variable serialVersionUID no idea what this thing does
     */
    private static final long serialVersionUID = 42L;

    /**
     * @variable numberOfSS how many solar systems you want
     */
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
     * @variable universeDimension size of the universe
     */
    private final int universeDimension = 20;

    /**
     * Constructor for Universe class.
     */
    public Universe() {
        booleanArray = new boolean[universeDimension][universeDimension];
        for (int x = 0; x < universeDimension; x++) {
            for (int y = 0; y < universeDimension; y++) {
                booleanArray[x][y] = false;
            }
        }
        numberOfSS = (int) (Math.random() * offset) + offset;
        for (int i = 0; i < numberOfSS; i++) {
            int x = (int) (Math.random() * universeDimension);
            int y = (int) (Math.random() * universeDimension);
            while (true) {
                if (booleanArray[x][y]) {
                    x = (int) (Math.random() * universeDimension);
                    y = (int) (Math.random() * universeDimension);
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
        StringBuffer returnString = new StringBuffer(offset2);
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
    public final int getNumberOfSolarSystems() {
        return numberOfSS;
    }

    /**
     * @param numberOfSS the numberOfSolarSystems to set
     */
    public final void setNumberOfSolarSystems(final int numberOfSS) {
        this.numberOfSS = numberOfSS;
    }

    /**
     * @return the solarSystems
     */
    public final ArrayList<SolarSystem> getSolarSystems() {
        return solarSystems;
    }

    /**
     * @param solarSystems the solarSystems to set
     */
    public final void setSolarSystems(final ArrayList<SolarSystem> solarSystems)
    {
        this.solarSystems = solarSystems;
    }

    /**
     * @return the booleanArray
     */
    public final boolean[][] getBooleanArray() {
        return booleanArray;
    }

    /**
     * @param booleanArray the booleanArray to set
     */
    public final void setBooleanArray(final boolean[][] booleanArray) {
        final boolean[][] copy = booleanArray;
        this.booleanArray = copy;
    }

    /**
     * @return the homeSolarSystem
     */
    public final SolarSystem getHomeSolarSystem() {
        return homeSolarSystem;
    }

    /**
     * @param homeSolarSystem the homeSolarSystem to set
     */
    public final void setHomeSolarSystem(final SolarSystem homeSolarSystem) {
        this.homeSolarSystem = homeSolarSystem;
    }

    /**
     * @return the homePlanet
     */
    public final Planet getHomePlanet() {
        return homePlanet;
    }

    /**
     * @param homePlanet the homePlanet to set
     */
    public final void setHomePlanet(final Planet homePlanet) {
        this.homePlanet = homePlanet;
    }

}

