package space.trader;

public class Character {
        private String name;
	private int pilot;
	private int fighter;
	private int trader;
	private int engineer;
	private int investor;
        
        public Character(String name, int pilot, int fighter, int trader, int engineer, int investor) {
            this.name = name;
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
        
        public String toString() {
            return name + ": " + pilot + " pilot points, " + fighter +
                    " fighter points, " + trader + " trader points, " +
                    engineer + " engineer points, " + investor + " investor points";
        }
}
 
