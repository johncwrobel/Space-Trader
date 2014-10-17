/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.trader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author John
 */
public class PirateEncounterScreenController implements Initializable {

    @FXML
    private Canvas canvas;
    
    @FXML
    private Label time;
    
    @FXML
    private Button start;
    
    private int timer = 3;
            
    private Timeline clock;
    
    private boolean[][] target = new boolean[20][20];
    
    private boolean playing = false;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }
    
    public void updateCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 400, 400);
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                if (target[i][j]) {
                    gc.fillRect(i * 20, j * 20, 20, 20);
                }
            }
        }
    }
    
    public class TimeClass implements EventHandler {

        int counter;
        
        public TimeClass(int count) {
            counter = count;
        }

        @Override
        public void handle(Event event) {
            
            if(counter >= 1) {
                time.setText("TIMER: " + counter + " seconds");
            } else {
                clock.stop();
                time.setText("GAME OVER");
                playing = false;
            }
            counter--;
        }
    }
    
    public void startGame(ActionEvent e) {
        if (!playing) {
            playing = true;
            int count = timer;
            time.setText("TIMER: " + count + " seconds");
            count--;

            target = new boolean[20][20];

            for (int i = 0; i < 3; i++) {
                int x = (int)(Math.random() * 20);
                int y = (int)(Math.random() * 20);
                if (!target[x][y]) {
                    target[x][y] = true;
                } else {
                    i--;
                }
            }

            updateCanvas();

            TimeClass tc = new TimeClass(count);
            clock = new Timeline(new KeyFrame(Duration.seconds(1), tc));
            clock.setCycleCount(4);
            clock.play();
        }
    }
    
    
    
    public void handle(MouseEvent e) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        updateCanvas();
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
