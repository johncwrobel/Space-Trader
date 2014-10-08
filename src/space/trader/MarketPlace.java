package space.trader;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tommy Lee
 */
public class MarketPlace {
    public final ArrayList<Item> items = new ArrayList<>();
    private final ArrayList<Integer> prices = new ArrayList<>();
    private ArrayList<Integer> amount = new ArrayList<>();
    private final ArrayList<Item> canSell = new ArrayList<>();
    private final ArrayList<Integer> sellingPrices = new ArrayList<>();
    private int techLevel;
    
    /**
     * Constructs the MarketPlace based on a bunch of variables
     * @param planetTechLevel 
     */
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
            canSell.add(new Item("Water", 0, 0, 2, 30, 3, 4));
            canSell.add(new Item("Furs", 0, 0, 0, 250, 10, 10));
            canSell.add(new Item("Food", 1, 0, 1, 100, 5, 5));
            canSell.add(new Item("Narcotics", 5, 0, 5, 3500, -125, 150));
            if (planetTechLevel >= 1) {
                canSell.add(new Item("Games", 3, 1, 6, 250, -10, 5));
                canSell.add(new Item("Firearms", 3, 1, 5, 1250, -75, 100));
                canSell.add(new Item("Medicine", 4, 1, 6, 650, -20, 10));
                if (planetTechLevel >= 2) {
                    canSell.add(new Item("Ore", 2, 2, 3, 350, 20, 10));
                    if (planetTechLevel >= 3) {
                        canSell.add(new Item("Machines", 4, 3, 5, 900, -30, 5));
                        if (planetTechLevel >= 4) {
                            canSell.add(new Item("Robots", 6, 4, 7, 5000, -150, 100));
                        }
                    }
                }
            }
        }
        
        for (Item i: items) {
            prices.add(i.getPrice(techLevel));
            amount.add((int) (Math.random() * 10));
        }
        
        for (Item i: canSell) {
            sellingPrices.add(i.getPrice(techLevel));
        }
    }
    
    /**
     * Creates the MarketPlace display
     * @return the display for the MarketPlace
     */
    public ArrayList<String> getDisplay() {
        ArrayList<String> display = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            display.add(items.get(i).toString() +": " +prices.get(i)+" credits ( " + amount.get(i)+" )");
        }
        
        return display;
    }
    
    /**
     * Checks if the item can be sold
     * @param i
     * @return if it can be sold or not
     */
    public boolean canSell(Item i) {
        for (Item s: canSell) {
            if (s.compareTo(i) == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Facilitates the buying process
     * @param name 
     */
    public void buy(String name) {
        int index = 0;
        for (int i = 0; i < items.size(); i++) {
            String compareString = items.get(i).name + ":";
            if (compareString.equals(name)) {
                index = i;
                break;
            }
        }
        amount.set(index, amount.get(index) - 1);
    }
    
    /**
     * Checks if the item can be bought
     * @param name
     * @return if it can be bought or not
     */
    public boolean canBuy(String name) {
        int index = 0;
        for (int i = 0; i < items.size(); i++) {
            String compareString = items.get(i).name + ":";
            if (compareString.equals(name)) {
                index = i;
                break;
            }
        }
        if (amount.get(index) == 0) {
            JOptionPane.showMessageDialog(null, "Not enough supply", "Alert" , JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Determines the selling price of an item
     * @param i
     * @return the price
     */
    public int getSellingPrice(Item i) {
        int itemIndex = 0;
        for (int j = 0; j < canSell.size(); j++) {
            if (canSell.get(j).compareTo(i) == 0) {
                itemIndex = j;
            }
        }
        return sellingPrices.get(itemIndex);
    }
}
