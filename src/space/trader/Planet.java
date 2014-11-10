package space.trader;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Random;

/**
 *
 * @author Benjamin Cervantes and John Wrobel
 */
public class Planet implements Serializable{
    private String name;
    private int techLevel;
    private int resources;
    private SolarSystem parentSystem;
    private MarketPlace marketplace;
    
    /**
     * Constructor for Planet class
     * @param parent parent solar system
     * @param name name of planet
     */
    public Planet(final SolarSystem parent, final String name) {
        parentSystem = parent;
        this.name = name;
        techLevel = (int)(Math.random() * 8);
        resources = (int)(Math.random() * 13);
        marketplace = new MarketPlace(getTechLevel());
    }
    
    /**
     * Getter method for getName
     * @return name
     */
    public final String getName() {
        return name;
    }

    /**
     * Getter method for ParentSystem
     * @return parentSystem
     */
    public final SolarSystem getSolarSystem(){
        return this.getParentSystem();
    }
    
    /**
     * Getter method for Tech Level
     * @return techLevel
     */
    public final int getTechLevel() {
        return techLevel;
    }

    /**
     * Getter method for Resources
     * @return resources
     */
    public final int getResources() {
        return resources;
    }
    
    /**
     * toString method for the class Planet
     * @return string representation of the planet
     */
    @Override
    public final String toString() {
        // (Planet name: name, Tech Level: x, Resource Type: x)
        return ("(Planet name: " + getName() + ", Tech Level: " + getTechLevel() + ", Resource Type: " + getResources() + ")"); 
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @param techLevel the techLevel to set
     */
    public void setTechLevel(final int techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(final int resources) {
        this.resources = resources;
    }

    /**
     * @return the parentSystem
     */
    public SolarSystem getParentSystem() {
        return parentSystem;
    }

    /**
     * @param parentSystem the parentSystem to set
     */
    public void setParentSystem(final SolarSystem parentSystem) {
        this.parentSystem = parentSystem;
    }

    /**
     * @return the marketplace
     */
    public MarketPlace getMarketplace() {
        return marketplace;
    }

    /**
     * @param marketplace the marketplace to set
     */
    public void setMarketplace(final MarketPlace marketplace) {
        this.marketplace = marketplace;
    }
}
