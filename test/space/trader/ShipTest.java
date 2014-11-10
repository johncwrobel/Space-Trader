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
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Caleb
 */
public class ShipTest {
   
    /**
     * Test of setShip method, of class Ship.
     */
    @Test
    public final void testSetShip() {
        final Ship instance = new Ship();
        instance.setShip(Ship.ShipTypes.SERENITY);
        
        Assert.assertEquals(instance.getShipType(), Ship.ShipTypes.SERENITY);
        Assert.assertEquals(10, instance.getMaxCargo());
        
        instance.setShip(Ship.ShipTypes.ENTERPRISE);
        
        Assert.assertEquals(instance.getShipType(), Ship.ShipTypes.ENTERPRISE);
        Assert.assertEquals(15, instance.getMaxCargo());
        
        instance.setShip(Ship.ShipTypes.DAEDALUS);
        
        Assert.assertEquals(instance.getShipType(), Ship.ShipTypes.DAEDALUS);
        Assert.assertEquals(20, instance.getMaxCargo());
          
        instance.setShip(Ship.ShipTypes.FALCON);
        
        Assert.assertEquals(instance.getShipType(), Ship.ShipTypes.FALCON);
        Assert.assertEquals(25, instance.getMaxCargo());
        
        instance.setShip(Ship.ShipTypes.GALACTICA);
        
        Assert.assertEquals(instance.getShipType(), Ship.ShipTypes.GALACTICA);
        Assert.assertEquals(30, instance.getMaxCargo());
    }

    /**
     * Test of addFuel method, of class Ship.
     */
    @Test
    public final void testAddFuel() {
        int amount = 0;
        Ship instance = new Ship();
        instance.addFuel(amount);
        Assert.assertEquals(10, instance.getFuel());
        
        instance.addFuel(100);
        Assert.assertEquals(110, instance.getFuel());
        
        instance.addFuel(1000);
        Assert.assertEquals(1110, instance.getFuel());
    }
}
