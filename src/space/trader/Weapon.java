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
     */
    public Weapon(String name, int weaponLevel, int techLevel, int price) {
        this.name = name;
        this.weaponLevel = weaponLevel;
        this.techLevel = techLevel;
        this.price = price;
    }
}
