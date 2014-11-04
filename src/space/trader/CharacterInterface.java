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
    
    public int getCredits();
    
    public boolean getReputation();
    
    public int policeBribe();
    
    public void consentSearch();
    
    public void payBribe();
    
    public void buy(int price);
    
    public boolean canBuy(int price);
    
    public void sell(int price);
    
    public int getPilot();
    
    public int getFighter();
    
    public int getTrader();
    
    public int getEngineer();
    
    public int getInvestor();
    
    public void setCriminal(boolean criminal);
    
    @Override
    public String toString();
    
}
