package space.trader;

import java.util.ArrayList;

/**
 *
 * @author Tommy Lee
 */
public class MarketPlace {
    private final ArrayList<Item> items = new ArrayList<Item>();
    private final ArrayList<Item> canSell = new ArrayList<Item>();
    private int techLevel;
    
    public MarketPlace(int planetTechLevel) {
        this.techLevel = planetTechLevel;
        if (planetTechLevel >= 0) {
            items.add(new Item("Water", 0, 0, 2, 30, 3, 4));
            items.add(new Item("Furs", 0, 0, 0, 250, 10, 10));
            if (planetTechLevel >= 1) {
                items.add(new Item("Food", 1, 0, 1, 100, 5, 5));
                if (planetTechLevel >= 2) {
                    items.add(new Item("Ore", 2, 2, 3, 350, 20, 10));
                    if (planetTechLevel >= 3) {
                        items.add(new Item("Games", 3, 1, 6, 250, -10, 5));
                        items.add(new Item("Firearms", 3, 1, 5, 1250, -75, 100));
                        if (planetTechLevel >= 4) {
                            items.add(new Item("Medicine", 4, 1, 6, 650, -20, 10));
                            items.add(new Item("Machines", 4, 3, 5, 900, -30, 5));
                            if (planetTechLevel >= 5) {
                                items.add(new Item("Narcotics", 5, 0, 5, 3500, -125, 150));
                                if (planetTechLevel >= 6) {
                                    items.add(new Item("Robots", 6, 4, 7, 5000, -150, 100));
                                }
                            }
                        }
                    }
                }
            }
        }
        if (techLevel >= 0) {
            items.add(new Item("Water", 0, 0, 2, 30, 3, 4));
            items.add(new Item("Furs", 0, 0, 0, 250, 10, 10));
            items.add(new Item("Food", 1, 0, 1, 100, 5, 5));
            items.add(new Item("Narcotics", 5, 0, 5, 3500, -125, 150));
            if (planetTechLevel >= 1) {
                items.add(new Item("Games", 3, 1, 6, 250, -10, 5));
                items.add(new Item("Firearms", 3, 1, 5, 1250, -75, 100));
                items.add(new Item("Medicine", 4, 1, 6, 650, -20, 10));
                if (planetTechLevel >= 2) {
                    items.add(new Item("Ore", 2, 2, 3, 350, 20, 10));
                    if (planetTechLevel >= 3) {
                        items.add(new Item("Machines", 4, 3, 5, 900, -30, 5));
                        if (planetTechLevel >= 4) {
                            items.add(new Item("Robots", 6, 4, 7, 5000, -150, 100));
                        }
                    }
                }
            }
        }
        
        
    }
    
    public ArrayList<Item> getItems(){
        return items;
    }
}