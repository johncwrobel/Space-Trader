/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
    }

    /**
     * Test of removeItem method, of class Ship.
     */
    @Test
    public void testRemoveItem() {
    }

    /**
     * Test of getFuel method, of class Ship.
     */
    @Test
    public void testGetFuel() {
    }

    /**
     * Test of getMaxFuel method, of class Ship.
     */
    @Test
    public void testGetMaxFuel() {
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
        Assert.assertEquals(10, instance.getFuel());
        
        instance.addFuel(100);
        Assert.assertEquals(110, instance.getFuel());
        
        instance.addFuel(1000);
        Assert.assertEquals(1110, instance.getFuel());
    }



    /**
     * Test of canAdd method, of class Ship.
     */
    @Test
    public void testCanAdd() {
    }

    /**
     * Test of checkGadget method, of class Ship.
     */
    @Test
    public void testCheckGadget() {
    }

    /**
     * Test of increaseWeaponLevel method, of class Ship.
     */
    @Test
    public void testIncreaseWeaponLevel() {
    }

    /**
     * Test of increaseShieldLevel method, of class Ship.
     */
    @Test
    public void testIncreaseShieldLevel() {
    }
    
}
