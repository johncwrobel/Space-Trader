/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Benjamin Cervantes
 */
public class CharacterTest {
    
    public CharacterTest() {
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

    @Test
    public final void testCanBuy() {
        Character char1 = new Character(null, 0, 0, 0, 0, 0);
        char1.setCredits(1000);
        Assert.assertTrue(char1.canBuy(50));
        Assert.assertTrue(char1.canBuy(1000));
        Assert.assertFalse(char1.canBuy(1001));
        Assert.assertFalse(char1.canBuy(2000));
    }
}
