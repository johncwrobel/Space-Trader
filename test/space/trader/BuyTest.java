package space.trader;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author John
 */
public class BuyTest {
    /**
     * @variable tester an instance for the tests
     */
    private transient Character tester;

    /**
     * The set up.
     */
    @Before
    public final void setUp() {
        tester = new Character(null, 0, 0, 0, 0, 0);
    }

    /**
     * Tests buying a valid priced item.
     */
    @Test
    public final void testBuy500() {
        tester.buy(500);
        assertEquals("Thinks 2000 - 500 != 1500.", 1500, tester.getCredits());
    }

    /**
     * Tests an attempt to buy something that's too expensive.
     */
    @Test
    public final void testBuy2001() {
        tester.buy(2001);
        //dialogue should pop up
        assertEquals("Subtracted credits when it shouldn't.", 2000, tester.
                getCredits());
    }

    /**
     * Tests buying a few things.
     */
    @Test
    public final void testBuySeveralItems() {
        tester.buy(100);
        tester.buy(300);
        tester.buy(100);
        assertEquals("Thinks 100 + 300 + 100 != 500.", 1500, tester.
                getCredits());
    }

    /**
     * Tests buying several things that cost too much.
     */
    @Test
    public final void testBuySeveralTooExpensive() {
        tester.buy(1000);
        tester.buy(1500);
        //dialogue should pop up
        tester.buy(500);
        tester.buy(9001);
        assertEquals("Wacky error.", 500, tester.getCredits());
    }
}
