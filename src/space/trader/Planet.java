package space.trader;

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
    
    public Planet(String name, int xLocation, int yLocation, int techLevel, int resources) {
        this.name = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.techLevel = techLevel;
        this.resources = resources;
    }
    public Planet() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }
    
}
