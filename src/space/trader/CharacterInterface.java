/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

/**
 * Uses the Facade Design Pattern to hide the implementation of Character.
 *
 * @author tanmay
 */
public interface CharacterInterface {

    /**
     * Getter method for character's credits.
     * @return credits
     */
    int getCredits();

    /**
     * Getter method for reputation.
     * @return if wanted or not
     */
    boolean isCriminal();

    /**
     * Method to bribe police.
     * @return bribe cost
     */
    int policeBribe();

    /**
     * Method to handle the consent of a search.
     */
    void consentSearch();

    /**
     * Method to handle payment of bribe.
     */
    void payBribe();

    /**
     * Method to handle any purchase.
     * @param price
     */
    void buy(int price);

    /**
     * Method to see if player can afford a price.
     * @param price the price
     * @return if it can be afforded
     */
    boolean canBuy(int price);

    /**
     * Method to handle sale of an item.
     * @param price
     */
    void sell(int price);

    /**
     * Getter method for pilot skill level.
     * @return pilot skill level
     */
    int getPilot();

    /**
     * Getter method for fighter skill level.
     * @return fighter skill level
     */
    int getFighter();

    /**
     * Getter method for trader skill level.
     * @return trader skill level
     */
    int getTrader();

    /**
     * Getter method for engineer skill level.
     * @return engineer skill level
     */
    int getEngineer();

    /**
     * Getter method for investor skill level.
     * @return investor skill level
     */
    int getInvestor();

    /**
     * Sets the player as wanted or not.
     * @param criminal
     */
    void setCriminal(boolean criminal);

    /**
     * Turns the player object into a string.
     * @return the string version of the character
     */
    @Override
    String toString();

}
