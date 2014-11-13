/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Tommy Lee
 */
public class CanAddTest {
    /**
     * Tests when the cargo is empty.
     */
    @Test
    public final void testCanAdd() {
        Ship ship = new Ship();
        ship.setMaxCargo(10);

        assertEquals("Test failed.", ship.canAdd(), true);
    }
    /**
     * Tests when the cargo has items in it but still with room for more.
     */
    @Test
    public final void testCanAdd5() {
        ArrayList<Item> cargoHold = new ArrayList();
        Ship ship = new Ship();
        ship.setMaxCargo(10);

        for (int x = 0; x < 5; x++) {
            cargoHold.add(new Item("Test" + x, 0, 0, 0, 0, 0, 0));
        }

        ship.setCargoHold(cargoHold);

        assertEquals(ship.canAdd(), true);
    }

    /**
     * Tests when the cargo is full.
     */
    @Test
    public final void testCanAdd10() {
        ArrayList<Item> cargoHold = new ArrayList();
        Ship ship = new Ship();
        ship.setMaxCargo(10);

        for (int x = 0; x < 10; x++) {
            cargoHold.add(new Item("Test" + x, 0, 0, 0, 0, 0, 0));
        }

        ship.setCargoHold(cargoHold);

        assertEquals(ship.canAdd(), false);
    }


}
