package space.trader;

import javax.swing.JOptionPane;

public class Character {
        private String name;
        private int credits;
	private int pilot;
	private int fighter;
	private int trader;
	private int engineer;
	private int investor;
        private boolean criminal;
        
        /**
         * Constructor for Character Class
         * @param name
         * @param pilot
         * @param fighter
         * @param trader
         * @param engineer
         * @param investor 
         */
        public Character(String name, int pilot, int fighter, int trader, int engineer, int investor, boolean criminal) {
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
         * Getter method for character's credits
         * @return how many credits the character has
         */
        public int getCredits() {
            return this.credits;
        }
        
        /**
         * Getter method for character reputation
         * @return if the character is a criminal or not
         */
        public boolean getReputation() {
            return this.criminal;
        }
        
        /**
         * create bribe amount (100-500 credits) and reduce from credits
         * @return 
         */
        public int policeBribe() {
            int bribeAmount = ((int)Math.random() * 400) + 100;
            return bribeAmount;
        }
        
        /**
         * deducts bribe amount from player credits
         * @param amount 
         */
        public void payBribe(int amount) {
            credits -= amount;
        }
             
        /**
         * Facilitates the buying process
         * @param price 
         */
        public void buy(int price) {
            credits -= price;
        }
        
        /**
         * Checker method to make sure the character can buy something
         * @param price
         * @return if the character can buy it
         */
        public boolean canBuy(int price) {
            if ((credits - price) >= 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Not enough credits", "Alert" , JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        /**
         * Facilitates the selling process
         * @param price 
         */
        public void sell(int price) {
            credits += price;
        }
        
        /**
         * Getter method for Pilot
         * @return pilot
         */
        public int getPilot() {
            return this.pilot;
        }
        
        /**
         * Getter method for Fighter
         * @return fighter
         */
        public int getFighter() {
            return this.fighter;
        }
        
        /**
         * Getter method for Trader
         * @return trader
         */
        public int getTrader() {
            return this.trader;
        }
        
        /**
         * Getter method for Engineer
         * @return engineer
         */
        public int getEngineer() {
            return this.engineer;
        }
        
        /**
         * Getter method for Investor
         * @return 
         */
        public int getInvestor() {
            return this.investor;
        }
        
        /**
         * toString for the character
         * @return String representation for the character
         */
        @Override
        public String toString() {
            return name + ": " + pilot + " pilot points, " + fighter +
                    " fighter points, " + trader + " trader points, " +
                    engineer + " engineer points, " + investor + " investor points";
        }
}
 
