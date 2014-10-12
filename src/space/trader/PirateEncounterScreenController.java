/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author John
 */
public class PirateEncounterScreenController implements Initializable {

    @FXML
    private Canvas canvas;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void handle(MouseEvent e) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 600, 400);
        drawMouse(e, gc);
    }
    
    public void drawMouse(MouseEvent e, GraphicsContext gc) {
        double x = e.getX();
        double y = e.getY();
        gc.setStroke(Color.GREEN);
        gc.strokeLine(x - 10, y, x + 10, y);
        gc.strokeLine(x, y - 10, x, y + 10);
    }
    
}
