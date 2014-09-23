package space.trader;
import java.util.*;

/**
 *
 * @author Benjamin Cervantes
 */
public class SolarSystem {

    private String name;
    private int x;
    private int y;
    
    
    public SolarSystem(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return this.name;
    }
    
    public int getXLocation() {
        return this.x;
    }
    
    public int getYLocation() {
        return this.y;
    }

}
