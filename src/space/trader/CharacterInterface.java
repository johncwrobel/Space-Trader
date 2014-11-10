/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

/**
 * Uses the Facade Design Pattern to hide the implementation of Character
 * 
 * @author tanmay
 */
public interface CharacterInterface {
    
    /**
     * Getter method for character's credits
     * @return credits
     */
    public int getCredits();
    
    /**
     * Getter method for reputation
     * @return if wanted or not
     */
    public boolean isCriminal();
    
    /**
     * Method to bribe police
     * @return bribe cost
     */
    public int policeBribe();
    
    /**
     * Method to handle the consent of a search
     */
    public void consentSearch();
    
    /**
     * Method to handle payment of bribe
     */
    public void payBribe();
    
    /**
     * Method to handle any purchase
     * @param price 
     */
    public void buy(int price);
    
    /**
     * Method to see if player can afford a price
     * @param price the price
     * @return if it can be afforded
     */
    public boolean canBuy(int price);
    
    /**
     * Method to handle sale of an item
     * @param price 
     */
    public void sell(int price);
    
    /**
     * Getter method for pilot skill level
     * @return pilot skill level
     */
    public int getPilot();
    
    /**
     * Getter method for fighter skill level
     * @return fighter skill level
     */
    public int getFighter();
    
    /**
     * Getter method for trader skill level
     * @return trader skill level
     */
    public int getTrader();
    
    /**
     * Getter method for engineer skill level
     * @return engineer skill level
     */
    public int getEngineer();
    
    /**
     * Getter method for investor skill level
     * @return investor skill level
     */
    public int getInvestor();
    
    /**
     * Sets the player as wanted or not
     * @param criminal 
     */
    public void setCriminal(boolean criminal);
    
    /**
     * Turns the player object into a string
     * @return the string version of the character
     */
    @Override
    public String toString();
    
}
