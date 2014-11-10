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

public class Weapon {
    
    public String name;
    public int weaponLevel;
    public int techLevel;
    public int price;
    
    /**
     * Constructor for the Weapon
     * @param name weapon name
     * @param weaponLevel the weapon's level
     * @param techLevel the current planet's tech level
     * @param price cost of weapon
     */
    public Weapon(final String name, final int weaponLevel, final int techLevel, final int price) {
        this.name = name;
        this.weaponLevel = weaponLevel;
        this.techLevel = techLevel;
        this.price = price;
    }
}
