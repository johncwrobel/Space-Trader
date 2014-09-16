package space.trader;

public class Character {
	private int pilot;
	private int fighter;
	private int trader;
	private int engineer;
	private int investor;
        
        public Character(int pilot, int fighter, int trader, int engineer, int investor) {
            this.pilot = pilot;
            this.fighter = fighter;
            this.trader = trader;
            this.engineer = engineer;
            this.investor = investor;
        }
        
        public int getPilot() {
            return this.pilot;
        }
        
        public int getFighter() {
            return this.fighter;
        }
        
        public int getTrader() {
            return this.trader;
        }
        
        public int getEngineer() {
            return this.engineer;
        }
        
        public int getInvestor() {
            return this.investor;
        }
}
 
