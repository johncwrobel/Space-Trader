/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author Johnnycakes
 */
public class Ship implements Serializable {
    private static final long serialVersionUID = 42L;

    private ArrayList<Item> cargoHold;
    private int maxCargo;
    private int fuel;
    private int maxFuel;
    private int xLocation;
    private int yLocation;
    private int gadgetslots;
    private int gadgets;
    private int maxCrew;
    private int techLevel;
    private int fuelCost;
    private int bounty;
    private int size;
    private int hull;
    private int weaponLevel;
    private int shieldLevel;
    private ShipTypes shipType = ShipTypes.SERENITY;
    /**
     * Constructor for the Ship.
     */
    public Ship() {
        maxCargo = 10;
        cargoHold = new ArrayList(maxCargo);
        cargoHold.add(new Item("Water", 0, 0, 2, 30, 3, 4));
        fuel = 10;
        maxFuel = 10;
        gadgetslots = 0;
        gadgets = 0;
        techLevel = 4;
        fuelCost = 1;
        bounty = 5;
        size = 0;
        hull = 25;
        weaponLevel = 0;
        shieldLevel = 0;
    }

    /**
     * @return the cargoHold
     */
    final public ArrayList<Item> getCargoHold() {
        return cargoHold;
    }

    /**
     * @param cargoHold the cargoHold to set
     */
    final public void setCargoHold(final ArrayList<Item> cargoHold) {
        this.cargoHold = cargoHold;
    }

    /**
     * @return the maxCargo
     */
    final public int getMaxCargo() {
        return maxCargo;
    }

    /**
     * @param maxCargo the maxCargo to set
     */
    final public void setMaxCargo(final int maxCargo) {
        this.maxCargo = maxCargo;
    }

    /**
     * @param fuel the fuel to set
     */
    final public void setFuel(final int fuel) {
        this.fuel = fuel;
    }

    /**
     * @param maxFuel the maxFuel to set
     */
    final public void setMaxFuel(final int maxFuel) {
        this.maxFuel = maxFuel;
    }

    /**
     * @return the xLocation
     */
    final public int getxLocation() {
        return xLocation;
    }

    /**
     * @param xLocation the xLocation to set
     */
    final public void setxLocation(final int xLocation) {
        this.xLocation = xLocation;
    }

    /**
     * @return the yLocation
     */
    final public int getyLocation() {
        return yLocation;
    }

    /**
     * @param yLocation the yLocation to set
     */
    final public void setyLocation(final int yLocation) {
        this.yLocation = yLocation;
    }

    /**
     * @return the gadgetslots
     */
    final public int getGadgetslots() {
        return gadgetslots;
    }

    /**
     * @param gadgetslots the gadgetslots to set
     */
    final public void setGadgetslots(final int gadgetslots) {
        this.gadgetslots = gadgetslots;
    }

    /**
     * @return the gadgets
     */
    final public int getGadgets() {
        return gadgets;
    }

    /**
     * @param gadgets the gadgets to set
     */
    final public void setGadgets(final int gadgets) {
        this.gadgets = gadgets;
    }

    /**
     * @return the maxCrew
     */
    final public int getMaxCrew() {
        return maxCrew;
    }

    /**
     * @param maxCrew the maxCrew to set
     */
    final public void setMaxCrew(final int maxCrew) {
        this.maxCrew = maxCrew;
    }

    /**
     * @return the techLevel
     */
    final public int getTechLevel() {
        return techLevel;
    }

    /**
     * @param techLevel the techLevel to set
     */
    final public void setTechLevel(final int techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * @return the fuelCost
     */
    final public int getFuelCost() {
        return fuelCost;
    }

    /**
     * @param fuelCost the fuelCost to set
     */
    final public void setFuelCost(final int fuelCost) {
        this.fuelCost = fuelCost;
    }

    /**
     * @return the bounty
     */
    final public int getBounty() {
        return bounty;
    }

    /**
     * @param bounty the bounty to set
     */
    final public void setBounty(final int bounty) {
        this.bounty = bounty;
    }

    /**
     * @return the size
     */
    final public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    final public void setSize(final int size) {
        this.size = size;
    }

    /**
     * @return the hull
     */
    final public int getHull() {
        return hull;
    }

    /**
     * @param hull the hull to set
     */
    final public void setHull(final int hull) {
        this.hull = hull;
    }

    /**
     * @return the weaponLevel
     */
    final public int getWeaponLevel() {
        return weaponLevel;
    }

    /**
     * @param weaponLevel the weaponLevel to set
     */
    final public void setWeaponLevel(final int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }

    /**
     * @return the shieldLevel
     */
    final public int getShieldLevel() {
        return shieldLevel;
    }

    /**
     * @param shieldLevel the shieldLevel to set
     */
    final public void setShieldLevel(final int shieldLevel) {
        this.shieldLevel = shieldLevel;
    }

    /**
     * @return the shipType
     */
    final public ShipTypes getShipType() {
        return shipType;
    }

    /**
     * @param shipType the shipType to set
     */
    final public void setShipType(final ShipTypes shipType) {
        this.shipType = shipType;
    }

    /**
     * Enum for the ship types.
     */
    public enum ShipTypes { //enum for the ship types
        SERENITY, FALCON, ENTERPRISE, GALACTICA, DAEDALUS
    }

/**
 * Sets the ship type, and changed any associated private vars.
 * @param aShipType
 */
    public final void setShip(final ShipTypes aShipType) {
        if (aShipType == ShipTypes.SERENITY) {
            //set new attributes based on type
            SpaceTrader.ship.setMaxCargo(10);
            SpaceTrader.ship.setMaxFuel(20);
            SpaceTrader.ship.setGadgetslots(
                    SpaceTrader.ship.getGadgetslots() + 1);
            SpaceTrader.ship.setTechLevel(4);
            SpaceTrader.ship.setFuelCost(1);
            SpaceTrader.ship.setBounty(5);
            SpaceTrader.ship.setSize(0);
            SpaceTrader.ship.setHull(25);
            SpaceTrader.ship.setWeaponLevel(0);
            SpaceTrader.ship.setShieldLevel(0);
        }
        if (aShipType == ShipTypes.FALCON) {
            SpaceTrader.ship.setMaxCargo(15);
            SpaceTrader.ship.setMaxFuel(25);
            SpaceTrader.ship.setGadgetslots(
                    SpaceTrader.ship.getGadgetslots() + 1);
            SpaceTrader.ship.setTechLevel(5);
            SpaceTrader.ship.setFuelCost(2);
            SpaceTrader.ship.setBounty(50);
            SpaceTrader.ship.setSize(1);
            SpaceTrader.ship.setHull(100);
            SpaceTrader.ship.setWeaponLevel(1);
            SpaceTrader.ship.setShieldLevel(1);
        }
        if (aShipType == ShipTypes.ENTERPRISE) {
            SpaceTrader.ship.setMaxCargo(20);
            SpaceTrader.ship.setMaxFuel(30);
            SpaceTrader.ship.setGadgetslots(
                    SpaceTrader.ship.getGadgetslots() + 1);
            SpaceTrader.ship.setTechLevel(5);
            SpaceTrader.ship.setFuelCost(3);
            SpaceTrader.ship.setBounty(75);
            SpaceTrader.ship.setSize(1);
            SpaceTrader.ship.setHull(100);
            SpaceTrader.ship.setWeaponLevel(3);
            SpaceTrader.ship.setShieldLevel(3);
        }
        if (aShipType == ShipTypes.GALACTICA) {
            SpaceTrader.ship.setMaxCargo(25);
            SpaceTrader.ship.setMaxFuel(35);
            SpaceTrader.ship.setGadgetslots(
                    SpaceTrader.ship.getGadgetslots() + 1);
            SpaceTrader.ship.setTechLevel(5);
            SpaceTrader.ship.setFuelCost(5);
            SpaceTrader.ship.setBounty(100);
            SpaceTrader.ship.setSize(1);
            SpaceTrader.ship.setHull(100);
            SpaceTrader.ship.setWeaponLevel(5);
            SpaceTrader.ship.setShieldLevel(5);
        }
        if (aShipType == ShipTypes.DAEDALUS) {
            SpaceTrader.ship.setMaxCargo(30);
            SpaceTrader.ship.setMaxFuel(40);
            SpaceTrader.ship.setGadgetslots(
                    SpaceTrader.ship.getGadgetslots() + 1);
            SpaceTrader.ship.setTechLevel(5);
            SpaceTrader.ship.setFuelCost(7);
            SpaceTrader.ship.setBounty(125);
            SpaceTrader.ship.setSize(2);
            SpaceTrader.ship.setHull(100);
            SpaceTrader.ship.setWeaponLevel(7);
            SpaceTrader.ship.setShieldLevel(7);
        }
        setShipType(aShipType);
    }

    /**
     * Removes an item from the ship's cargo hold.
     * @param name item name
     * @return if it was removed
     */
    public final boolean removeItem(final String name) {
        boolean toReturn = false;
        for (int i = 0; i < getCargoHold().size(); i++) {
            final String compareString = getCargoHold().get(i).getName() + ":";
            if (compareString.equals(name)) {
                getCargoHold().remove(i);
                toReturn = true;
            }
        }
        return toReturn;
    }

    /**
     * Returns the current fuel for the ship.
     * @return Fuel
     */

    public final int getFuel() {
        return this.fuel; //returns the ship's current Fuel
    }

    /**
     * Returns the maximum amount of fuel the ship can hold.
     * @return maxFuel
     */

    public final int getMaxFuel() {
        return this.maxFuel; //returns the ship's maximum allowed fuel
    }

    /**
     * Adds fuel to the ship.
     * @param amount the amount of fuel to add
     */

    public final void addFuel(final int amount) {
        this.setFuel(this.getFuel() + amount);
//add a certain amount of fuel to the ship
    }

    /**
     * Whether nor not the ship has enough fuel to travel to a system.
     * @param system the system to travel to
     * @return true or false
     */

    public final boolean canTravelTo(final SolarSystem system) {
        setxLocation(SpaceTrader.currentPlanet.getSolarSystem().getXLocation());
        //updates the xLocation of the ship to use later
        setyLocation(SpaceTrader.currentPlanet.getSolarSystem().getYLocation());
        //updates the yLocation of the ship to use later

        //uses distance formula to calculate if the distance is too far
        return this.getFuelCost() * Math.sqrt((getxLocation()
                - system.getXLocation(
        )) * (getxLocation() - system.getXLocation()) + (getyLocation()
                - system.getYLocation()) * (getyLocation()
                        - system.getYLocation())) <= getFuel();
    }
       /**
     * Whether nor not the ship has enough fuel to travel to a planet.
     * @param planet the system to travel to
     * @return true or false
     */

    public final boolean canTravelTo(final Planet planet) {
        return canTravelTo(planet.getSolarSystem());
        //calls above method, but with planet instead
    }

    /**
     * Moves the ship from current planet to decided planet.
     * Sets currentplanet
     * Sets currentsolarysystem
     * Sets X and Y locations
     * @param planet the planet to travel to
     */

    public final void travel(final Planet planet) {
        //subtracts fuel based on how far we travelled
        setFuel((int) (getFuel() - Math.sqrt((getxLocation()
                - planet.getSolarSystem().getXLocation()) * (getxLocation()
                        - planet.getSolarSystem().getXLocation())
                + (getyLocation() - planet.getSolarSystem().getYLocation())
                        * (getyLocation()
                                - planet.getSolarSystem().getYLocation()))));
        SpaceTrader.currentPlanet = planet; //sets currentPlanet
        SpaceTrader.currentSolarSystem = planet.getSolarSystem();
        //sets currentSolarSystem
        setxLocation(SpaceTrader.currentPlanet.getSolarSystem().getXLocation());
        //updates xLocation of ship
        setyLocation(SpaceTrader.currentPlanet.getSolarSystem().getYLocation());
        //updates yLocation of ship
    }

    /**
     * Adds an item to the ship's cargo hold.
     * @param itemName
     */
    public final void addItem(final String itemName) {
        final ArrayList<Item> itemList =
                SpaceTrader.currentPlanet.getMarketplace().items;
        for (int i = 0; i < itemList.size(); i++) {
            final String compareString = itemList.get(i).getName() + ":";
            if (compareString.equals(itemName)) {
                getCargoHold().add(itemList.get(i));
                break;
            }
        }
        //cargoHold.add(itemList.get(index))
    }

    /**
     * Checks if there is space in the cargo hold or not.
     * @return if there's room
     */
    public final boolean canAdd() {
        boolean toReturn;
        if (getCargoHold().size() < getMaxCargo()) {
            toReturn = true;
        } else {
            JOptionPane.showMessageDialog(null, "Not enough storage in the ship"
                    , "Alert" , JOptionPane.ERROR_MESSAGE);
            toReturn = false;
        }
        return toReturn;
    }

    /**
     * Getter for the ship's cargo.
     * @return ship's cargo
     */
    public final ArrayList getCargo() {
        return getCargoHold();
    }

    /**
     * Check if Ship's cargo is big enough.
     * @return if gadgets can be purchased
     */
    public final boolean checkGadget() {
        return getGadgetslots() > getGadgets();
    }

    /**
     * Increases the ship's Weapon Level.
     * @param add
     */
    public final void increaseWeaponLevel(final int add) {
        setWeaponLevel(getWeaponLevel() + add);
    }

    /**
     * Increase the ship's Shield Level.
     * @param add amount to increase by
     */
    public final void increaseShieldLevel(final int add) {
        setShieldLevel(getShieldLevel() + add);
    }
}
