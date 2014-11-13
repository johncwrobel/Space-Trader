/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tommy Lee
 */


package space.trader;

/**
 * Class to represent weapons.
 * @author Tommy Lee
 */
public class Weapon {

    /**
     * @variable name weapon's name
     */
    private String name;

    /**
     * @variable weaponLevel weapon's level
     */
    private int weaponLevel;

    /**
     * @variable techLevel techLevel required for the weapon
     */
    private int techLevel;

    /**
     * @variable price weapon;s price
     */
    private int price;

    /**
     * Constructor for the Weapon.
     * @param name weapon name
     * @param weaponLevel the weapon's level
     * @param techLevel the current planet's tech level
     * @param price cost of weapon
     */
    public Weapon(final String name, final int weaponLevel, final int techLevel,
            final int price) {
        this.name = name;
        this.weaponLevel = weaponLevel;
        this.techLevel = techLevel;
        this.price = price;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the weaponLevel
     */
    public final int getWeaponLevel() {
        return weaponLevel;
    }

    /**
     * @param weaponLevel the weaponLevel to set
     */
    public final void setWeaponLevel(final int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }

    /**
     * @return the techLevel
     */
    public final int getTechLevel() {
        return techLevel;
    }

    /**
     * @param techLevel the techLevel to set
     */
    public final void setTechLevel(final int techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * @return the price
     */
    public final int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public final void setPrice(final int price) {
        this.price = price;
    }
}
