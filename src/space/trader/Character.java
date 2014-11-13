package space.trader;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 * Class to represent the player's character.
 * @author John
 */
public class Character implements Serializable, CharacterInterface {
        /**
         * @variable serialVersionUID no idea what this is
         */
        private static final long serialVersionUID = 42L;
        
        /**
         * @variable name the character's name
         */
        private String name;
        
        /**
         * @variablecredits the character's credits
         */
        private int credits;
        
        /**
         * @variable pilot the character's pilot skill level
         */
        private int pilot;
        
        /**
         * @variable fighter the character's fighter skill level
         */
        private int fighter;
        
        
        /**
         * @variable trader the character's trader skill level
         */
        private int trader;
        
        /**
         * @variable engineer the character's engineer skill level
         */
        private int engineer;
        
        /**
         * @variable the character's investor skill level
         */
        private int investor;
        
        /**
         * @variable if the character is a criminal or not
         */
        private boolean criminal;
        
        /**
         * Constructor for Character Class.
         * @param name character name
         * @param pilot pilot skill level
         * @param fighter fighter skill level
         * @param trader trader skill level
         * @param engineer engineer skill level
         * @param investor investor skill level
         */
        public Character(final String name, final int pilot, final int fighter, final int trader, final int engineer, final int investor) {
            this.name = name;
            this.pilot = pilot;
            this.fighter = fighter;
            this.trader = trader;
            this.engineer = engineer;
            this.investor = investor;
            this.credits = 2000;
            this.criminal = criminal;
        }
        
        /**
         * Getter method for character's credits.
         * @return how many credits the character has
         */
        public final int getCredits() {
            return this.credits;
        }
        
        /**
         * Getter method for character name.
         * @return the name
         */
        public final String getName() {
            return this.name;
        }
        
        /**
         * Getter method for character reputation.
         * @return if the character is a criminal or not
         */
        public final boolean isCriminal() {
            return this.criminal;
        }
        
        /**
         * create bribe amount (100-500 credits) and reduce from credits.
         * @return cost of the bribe
         */
        public final int policeBribe() {            
            return 500;
        }
        
        /**
         * Handler for if player consents to the search.
         */
        public final void consentSearch(){
            for(int i=0; i < SpaceTrader.ship.getCargoHold().size(); i++){
                if(SpaceTrader.ship.getCargoHold().get(i).isIllegal()){
                    if(getCredits() < 1000){
                        criminal = true;
                        // send to fight scene
                    }else{
                        setCredits(credits - 1000);
                    }
                }
            }
        }
        
        /**
         * deducts bribe amount from player credit.
         */
        public final void payBribe() {
            setCredits(credits - 500);
        }
           
        /**
         * Facilitates the buying process.
         * @param price amount to be deducted
         */
        public final void buy(final int price) {
            if (canBuy(price)){
               setCredits(credits - price); 
            }
        }
        
        /**
         * Checker method to make sure the character can buy something.
         * @param price cost to buy
         * @return if the character can buy it
         */
        public final boolean canBuy(final int price) {
            boolean toReturn;
            if ((credits - price) >= 0) {
                toReturn = true;
            } else {
                JOptionPane.showMessageDialog(null, "Not enough credits", "Alert" , JOptionPane.ERROR_MESSAGE);
                toReturn = false;
            }
            return toReturn;
        }
        
        /**
         * Facilitates the selling process.
         * @param price 
         */
        public final void sell(final int price) {
            setCredits(credits + price);
        }
        
        /**
         * Getter method for Pilot.
         * @return pilot
         */
        public final int getPilot() {
            return this.pilot;
        }
        
        /**
         * Getter method for Fighter.
         * @return fighter
         */
        public final int getFighter() {
            return this.fighter;
        }
        
        /**
         * Getter method for Trader.
         * @return trader
         */
        public final int getTrader() {
            return this.trader;
        }
        
        /**
         * Getter method for Engineer.
         * @return engineer skill level
         */
        public final int getEngineer() {
            return this.engineer;
        }
        
        /**
         * Getter method for Investor.
         * @return investor skill level
         */
        public final int getInvestor() {
            return this.investor;
        }
        
        /**
         * toString for the character.
         * @return String representation for the character
         */
        @Override
        public final String toString() {
            return name + ": " + pilot + " pilot points, " + fighter +
                    " fighter points, " + trader + " trader points, " +
                    engineer + " engineer points, " + investor + " investor points";
        }

        /**
         * Setter method for criminal.
         * @param criminal the criminal to set
         */
        public final void setCriminal(final boolean criminal) {
            this.criminal = criminal;
        }

        /**
         * Setter method for credits.
         * @param credits the credits to set
         */
        public final void setCredits(final int credits) {
            this.credits = credits;
        }
        
        /**
         * Setter method for name.
         * @param name to be set
         */
        public final void setName(final String name) {
            this.name = name;
        }
        
        /**
         * Setter method for pilot.
         * @param level to be set
         */
        public final void setPilot(final int level) {
            this.pilot = level;
        }
        
        /**
         * Setter method for fighter.
         * @param level to be set
         */
        public final void setFighter(final int level) {
            this.fighter = level;
        }
        
        /**
         * Setter method for trader.
         * @param level to be set
         */
        public final void setTrader(final int level) {
            this.trader = level;
        }
        
        
        /**
         * Setter method for engineer.
         * @param level to be set
         */
        public final void setEngineer(final int level) {
            this.engineer = level;
        }
        
        /**
         * Setter method for investor.
         * @param level to be set
         */
        public final void setInvestor(final int level) {
            this.investor = level;
        }
}