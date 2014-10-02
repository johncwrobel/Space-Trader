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
        
        /**
         * Constructor for Character Class
         * @param name
         * @param pilot
         * @param fighter
         * @param trader
         * @param engineer
         * @param investor 
         */
        public Character(String name, int pilot, int fighter, int trader, int engineer, int investor) {
            this.name = name;
            this.pilot = pilot;
            this.fighter = fighter;
            this.trader = trader;
            this.engineer = engineer;
            this.investor = investor;
            this.credits = 2000;
        }
        
        public int getCredits() {
            return this.credits;
        }
        
        public void buy(int price) {
            credits -= price;
        }
        
        public boolean canBuy(int price) {
            if ((credits - price) >= 0) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Not enough credits", "Alert" , JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
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
         * Gettr method for Investor
         * @return 
         */
        public int getInvestor() {
            return this.investor;
        }
        
        @Override
        public String toString() {
            return name + ": " + pilot + " pilot points, " + fighter +
                    " fighter points, " + trader + " trader points, " +
                    engineer + " engineer points, " + investor + " investor points";
        }
}
 
