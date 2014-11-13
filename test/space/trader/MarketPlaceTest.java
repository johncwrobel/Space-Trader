/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author tanmay
 */
public class MarketPlaceTest {

    private transient MarketPlace test;
    private Item i;

    /**
     * Tests the canSell method.
     */
    @Test
    final public void testCanSell0() {
        test = new MarketPlace(0);

        //test in bounds
        i = new Item("Water", 0, 0, 2, 30, 3, 4);
        assertEquals("Test failed.", test.canSell(i), true);

        //test out of bounds
        i = new Item("Medicine", 4, 1, 6, 650, -20, 10);
        assertEquals("Test failed.", test.canSell(i), false);
    }

    /**
     * Tests the canSell method.
     */
    @Test
    final public void testCanSell1() {
        test = new MarketPlace(1);

        //test in bounds
        i = new Item("Games", 3, 1, 6, 250, -10, 5);
        assertEquals("Test failed.", test.canSell(i), true);

        //test out of bounds
        i = new Item("Ore", 2, 2, 3, 350, 20, 10);
        assertEquals("Test failed.", test.canSell(i), false);

    }

    /**
     * Tests the canSell method.
     */
    @Test
    final public void testCanSell2() {
        test = new MarketPlace(2);

        //test in bounds
        i = new Item("Ore", 2, 2, 3, 350, 20, 10);
        assertEquals("Test failed.", test.canSell(i), true);

        //test out of bounds
        i = new Item("Machines", 4, 3, 5, 900, -30, 5);
        assertEquals("Test failed.", test.canSell(i), false);

    }

    /**
     * Tests the canSell method.
     */
    @Test
    final public void testCanSell3() {
        test = new MarketPlace(3);

        //test in bounds
        i = new Item("Machines", 4, 3, 5, 900, -30, 5);
        assertEquals("Test failed.", test.canSell(i), true);

        //test out of bounds
        i = new Item("Robots", 6, 4, 7, 5000, -150, 100);
        assertEquals("Test failed.", test.canSell(i), false);

    }

    /**
     * Tests the canSell method.
     */
    @Test
    final public void testCanSell4() {
        test = new MarketPlace(4);

        //test in bounds
        i = new Item("Robots", 6, 4, 7, 5000, -150, 100);
        assertEquals("Test failed.", test.canSell(i), true);


    }

    /**
     * Tests the canSell method.
     */
    @Test
    final public void testCanSell5() {
        test = new MarketPlace(5);

        //test in bounds
        i = new Item("Robots", 6, 4, 7, 5000, -150, 100);
        assertEquals("Test failed.", test.canSell(i), true);


    }
}
