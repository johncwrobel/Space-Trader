package space.trader;

import java.util.ArrayList;

/**
 *
 * @author Tommy Lee
 */
public class MarketPlace {
    private ArrayList<Item> items = new ArrayList<Item>();
    private int planetTechLevel;
    
    public MarketPlace(int planetTechLevel) {
        this.planetTechLevel = planetTechLevel;
        if (planetTechLevel > 6) {
            items.add(new Item("Water", 0, 0, 2, 30, 3, 4));
            items.add(new Item("Furs", 0, 0, 0, 250, 10, 10));
            items.add(new Item("Food", 1, 0, 1, 100, 5, 5));
            items.add(new Item("Ore", 2, 2, 3, 350, 20, 10));
            items.add(new Item("Games", 3, 1, 6, 250, -10, 5));
            items.add(new Item("Firearms", 3, 1, 5, 1250, -75, 100));
            items.add(new Item("Medicine", 4, 1, 6, 650, -20, 10));
            
        }
    }
}
