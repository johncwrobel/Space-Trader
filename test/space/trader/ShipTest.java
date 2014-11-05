/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Caleb
 */
public class ShipTest {
    
    public ShipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setShip method, of class Ship.
     */
    @Test
    public void testSetShip() {
        System.out.println("setShip");
        Ship.ShipTypes aShipType = null;
        Ship instance = new Ship();
        instance.setShip(aShipType);
    }

    /**
     * Test of removeItem method, of class Ship.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        String name = "";
        Ship instance = new Ship();
        boolean expResult = false;
        boolean result = instance.removeItem(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFuel method, of class Ship.
     */
    @Test
    public void testGetFuel() {
        System.out.println("getFuel");
        Ship instance = new Ship();
        int expResult = 10;
        int result = instance.getFuel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxFuel method, of class Ship.
     */
    @Test
    public void testGetMaxFuel() {
        System.out.println("getMaxFuel");
        Ship instance = new Ship();
        int expResult = 10;
        int result = instance.getMaxFuel();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFuel method, of class Ship.
     */
    @Test
    public void testAddFuel() {
        System.out.println("addFuel");
        int amount = 0;
        Ship instance = new Ship();
        instance.addFuel(amount);
    }



    /**
     * Test of canAdd method, of class Ship.
     */
    @Test
    public void testCanAdd() {
        System.out.println("canAdd");
        Ship instance = new Ship();
        boolean expResult = true;
        boolean result = instance.canAdd();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkGadget method, of class Ship.
     */
    @Test
    public void testCheckGadget() {
        System.out.println("checkGadget");
        Ship instance = new Ship();
        boolean expResult = false;
        boolean result = instance.checkGadget();
        assertEquals(expResult, result);
    }

    /**
     * Test of increaseWeaponLevel method, of class Ship.
     */
    @Test
    public void testIncreaseWeaponLevel() {
        System.out.println("increaseWeaponLevel");
        int add = 0;
        Ship instance = new Ship();
        instance.increaseWeaponLevel(add);
    }

    /**
     * Test of increaseShieldLevel method, of class Ship.
     */
    @Test
    public void testIncreaseShieldLevel() {
        System.out.println("increaseShieldLevel");
        int add = 0;
        Ship instance = new Ship();
        instance.increaseShieldLevel(add);
    }
    
}
