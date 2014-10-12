/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author tanmay
 */
public abstract class Shape {
    
    private int x;
    private int y;
    private int xdir;
    private int ydir;
    
    public abstract void draw(GraphicsContext gc);
    
    public abstract void animate();
    
}
