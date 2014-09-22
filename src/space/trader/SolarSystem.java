package space.trader;

/**
 *
 * @author Benjamin Cervantes
 */
public class SolarSystem {

    private String name;
    private int xLocation;
    private int yLocation;

    public SolarSystem(String name, int xLocation, int yLocation) {
        this.name = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        
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

}
