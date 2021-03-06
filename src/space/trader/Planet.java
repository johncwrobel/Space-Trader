package space.trader;

import java.io.Serializable;

/**
 *
 * @author Benjamin Cervantes and John Wrobel
 */
public class Planet implements Serializable {

    /**
     * numtechlevels.
     */
    private final int numTechLevels = 8;
    /**
     * numResources.
     */
    private final int numResources = 13;
    /**
     * @variable serialVersionUID no clue what this is for
     */
    private static final long serialVersionUID = 42L;

    /**
     * @variable name planet's name
     */
    private String name;

    /**
     * @variable techLevel planet's techLevel
     */
    private int techLevel;

    /**
     * @variable resources planet's resources
     */
    private int resources;

    /**
     * @variable parentSystem planet's system
     */
    private SolarSystem parentSystem;

    /**
     * @variable marketplace planet's marketplace
     */
    private MarketPlace marketplace;

    /**
     * Constructor for Planet class.
     * @param parent parent solar system
     * @param name name of planet
     */
    public Planet(final SolarSystem parent, final String name) {
        parentSystem = parent;
        this.name = name;
        techLevel = (int) (Math.random() * numTechLevels);
        resources = (int) (Math.random() * numResources);
        marketplace = new MarketPlace(getTechLevel());
    }

    /**
     * Getter method for getName.
     * @return name
     */
    public final String getName() {
        return name;
    }

    /**
     * Getter method for ParentSystem.
     * @return parentSystem
     */
    public final SolarSystem getSolarSystem() {
        return this.getParentSystem();
    }

    /**
     * Getter method for Tech Level.
     * @return techLevel
     */
    public final int getTechLevel() {
        return techLevel;
    }

    /**
     * Getter method for Resources.
     * @return resources
     */
    public final int getResources() {
        return resources;
    }

    /**
     * toString method for the class Planet.
     * @return string representation of the planet
     */
    @Override
    public final String toString() {
        // (Planet name: name, Tech Level: x, Resource Type: x)
        return ("(Planet name: " + getName() + ", Tech Level: " + getTechLevel()
                + ", Resource Type: " + getResources() + ")");
    }

    /**
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @param techLevel the techLevel to set
     */
    public final void setTechLevel(final int techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * @param resources the resources to set
     */
    public final void setResources(final int resources) {
        this.resources = resources;
    }

    /**
     * @return the parentSystem
     */
    public final SolarSystem getParentSystem() {
        return parentSystem;
    }

    /**
     * @param parentSystem the parentSystem to set
     */
    public final void setParentSystem(final SolarSystem parentSystem) {
        this.parentSystem = parentSystem;
    }

    /**
     * @return the marketplace
     */
    public final MarketPlace getMarketplace() {
        return marketplace;
    }

    /**
     * @param marketplace the marketplace to set
     */
    public final void setMarketplace(final MarketPlace marketplace) {
        this.marketplace = marketplace;
    }
}
